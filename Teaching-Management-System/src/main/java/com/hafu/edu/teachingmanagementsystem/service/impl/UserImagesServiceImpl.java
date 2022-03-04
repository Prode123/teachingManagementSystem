package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import com.hafu.edu.teachingmanagementsystem.Exception.ServiceException;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.Utils.splitUtils;
import com.hafu.edu.teachingmanagementsystem.dao.UserDao;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.entity.UserImages;
import com.hafu.edu.teachingmanagementsystem.dao.UserImagesDao;
import com.hafu.edu.teachingmanagementsystem.service.UserImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * (UserImages)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:47:16
 */
@Service("userImagesService")
@Transactional
public class UserImagesServiceImpl implements UserImagesService {
    @Resource
    private UserImagesDao userImagesDao;


    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    @Override
    public UserImages queryById(Long useId) {
        return this.userImagesDao.queryById(useId);
    }

    /**
     * 分页查询
     *
     * @param userImages  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserImages> queryByPage(UserImages userImages, PageRequest pageRequest) {
        long total = this.userImagesDao.count(userImages);
        return new PageImpl<>(this.userImagesDao.queryAllByLimit(userImages, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userImages 实例对象
     * @return 实例对象
     */
    @Override
    public UserImages insert(UserImages userImages) {
        this.userImagesDao.insert(userImages);
        return userImages;
    }

    /**
     * 修改数据
     *
     * @param userImages 实例对象
     * @return 实例对象
     */
    @Override
    public UserImages update(UserImages userImages) {
        this.userImagesDao.update(userImages);
        return this.queryById(userImages.getUseId());
    }

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long useId) {
        return this.userImagesDao.deleteById(useId) > 0;
    }

    /**
     * 通过用户id查询个人头像
     *
     * @author lt
     */
    @Override
    public R selectByUserId(User user) {
        if (user.getUid() == null) {
            return R.exp(201, "用户名不能为空");
        } else {
            UserImages userImages = userImagesDao.selectByUserId(user.getUid());
            System.out.println(userImages);
            return R.ok().setData(userImages);
        }
    }


    /**
     * 通过用户id修改头像
     *
     * @author lt
     */
    @Override
    public R updateHeadImage(@RequestParam("fileName") MultipartFile file, User user) {

        if (file.isEmpty()) {
            return R.exp(201, "上传头像为空");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
        String originalFilename = file.getOriginalFilename();
//            //获取最后一个.的位置
        int lastIndexOf = originalFilename.lastIndexOf(".");
//            //获取文件的后缀名 .jpg
        String suffix = originalFilename.substring(lastIndexOf);

//        生成唯一文件名
        String fileName = unique + suffix;
//        获取文件大小
        int size = (int) file.getSize();
//        定义头像存储路径
        String path1 = "C://file//user_images";
        File path = new File(path1 + File.separator + fileName);
        if (!path.getParentFile().exists()) { //判断文件父目录是否存在
            path.getParentFile().mkdirs();
        }
        try {
            file.transferTo(path); //保存文件
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
//            e.printStackTrace();
            throw new ServiceException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new ServiceException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
//        操作数据库

        /*通过uid查询该用户原本的头像路径*/
        Long uid = user.getUid();
        UserImages oldUserImage = userImagesDao.selectByUserId(uid);
        /*获取原本头像的路径*/
        String oldUserImagePath = oldUserImage.getPath();
        /*删除原本的头像*/
        List<String> splitString = splitUtils.splitString(oldUserImagePath, "/");
        /*拼接真实的绝对路径，而不是映射路径，所有人一开始都有一个原始头像*/
        File deleteFilePath = new File(path1 + File.separator + splitString.get(splitString.size() - 1));
        if (!("origin.png".equals(splitString.get(splitString.size() - 1)))) {
            /*执行删除*/
            deleteFilePath.delete();
        }


        /*修改头像表内的数据*/
        UserImages userImages = new UserImages();
        userImages.setModifiedTime(new Date());
        userImages.setPath("/manangmentSystem/file/" + fileName);
        System.out.println(userImages);
        userImages.setSize((long) size);
        userImages.setUid(uid);
        int i = userImagesDao.updateHeadImage(userImages);
        if (i > 0) {
            return R.ok().setData(userImages);
        } else {
            return R.exp(201, "上传失败");
        }
    }

}
