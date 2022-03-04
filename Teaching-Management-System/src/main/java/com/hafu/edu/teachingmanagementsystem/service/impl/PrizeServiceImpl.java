package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import com.hafu.edu.teachingmanagementsystem.Exception.ServiceException;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Document;
import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import com.hafu.edu.teachingmanagementsystem.dao.PrizeDao;
import com.hafu.edu.teachingmanagementsystem.service.PrizeService;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * (Prize)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:46:38
 */
@Service("prizeService")
@Transactional
public class PrizeServiceImpl implements PrizeService {
    @Resource
    private PrizeDao prizeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pizId 主键
     * @return 实例对象
     */
    @Override
    public Prize queryById(Long pizId) {
        return this.prizeDao.queryById(pizId);
    }

    /**
     * 分页查询
     *
     * @param prize       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Prize> queryByPage(Prize prize, PageRequest pageRequest) {
        long total = this.prizeDao.count(prize);
        return new PageImpl<>(this.prizeDao.queryAllByLimit(prize, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param prize 实例对象
     * @return 实例对象
     */
    @Override
    public Prize insert(Prize prize) {
        this.prizeDao.insert(prize);
        return prize;
    }


    /**
     * @Description: 修改数据
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @Override
    public Prize update(Prize prize) {
        this.prizeDao.update(prize);
        return this.queryById(prize.getPizId());
    }

    /**
     * 通过主键删除数据
     *
     * @param pizId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long pizId) {
        return this.prizeDao.deleteById(pizId) > 0;
    }

    /**
     * @Description: 删除单个或者多个的奖项信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @Override
    public R deleteByListId(ArrayList<Integer> pizIdList) {
        for (Integer pizId : pizIdList) {
            int flag = prizeDao.deleteById(pizId.longValue());
            if (flag == 0){
                return R.exp(ErrorCodeEnum.RESOURCE_DOES_NOT_EXIST);
            }
        }

        return R.ok();
    }

    /**
     * 上传奖项
     * @author lt
     * 2022/2/11
     */

    public R uploadFile1(@RequestParam("file") MultipartFile file, Prize prize){
            if(file.isEmpty()){
                return R.exp(201,"上传文件为空");
            }
//       获取文件名
//        String fileName1 = DateTime.Now.ToString("yyyyMMddHHmmss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
//        生成唯一文件名
        String fileName = unique;
//        定义奖项存储路径
        String path1 = "C://file//prize" ;
        File path = new File(path1 + File.separator + fileName);
        if(!path.getParentFile().exists()){ //判断文件父目录是否存在
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
//        设置奖项路径
        prize.setPathFront("/manangmentSystem/file" + File.separator + fileName);
//        设置创建时间
        prize.setCreateTime(new Date());
//        设置设置审核状态
        prize.setStatus(0);
//        操作数据库 将上传的奖项信息插入数据库
        int i = prizeDao.insert(prize);

        if(i>0){
            return R.ok().setData(prize);
        }
        else{
            return R.exp(201,"上传失败");
        }
    }

    /**
     * 上传奖项1 此接口只支持学生上传
     * 多文件上传 需要循环上传 把各个文件的路径拼接存储到数据库
     * 把 pwinner和tid字段拼接 然后组合 给数据库增加多条记录
     * @author lt
     * 2022/2/20
     */
    @Override
    public R uploadFile(@RequestParam("files") MultipartFile[] files, Prize prize){
        String allpath="";
        for (MultipartFile file : files) {
            if(file.isEmpty()){
                return R.exp(201,"上传文件为空");
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            Random random = new Random();
            String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());

            String originalFilename = file.getOriginalFilename();
            // media后缀
//            String originalFilename = file.getName();
//            System.out.println(originalFilename);
//            //获取最后一个.的位置
            int lastIndexOf = originalFilename.lastIndexOf(".");
//            //获取文件的后缀名 .jpg
            String suffix = originalFilename.substring(lastIndexOf);
//        生成唯一文件名
            String fileName = unique+suffix;
//        定义奖项存储路径
            String path1 = "C://file//prize" ;
            File path = new File(path1 + File.separator + fileName);

            allpath+="/manangmentSystem/file/"+ fileName+",";
            if(!path.getParentFile().exists()){ //判断文件父目录是否存在
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
        }
//       去掉allpath中的最后一个逗号 这样substring就是符合数据库路径的pathFront了
        String substring = allpath.substring(0, allpath.length() - 1);

        System.out.println(prize.getIsDelete() + " prize.getIsDelete()");

//        把pwinner分割
        String[] split1 = prize.getIsDelete().split(",");
//        把tid分割
        String[] split2 = prize.getTid().split(",");

//        设置奖项路径
//        prize.setPathFront("/manangmentSystem/file" + File.separator + fileName);
          prize.setPathFront(substring);
//        设置创建时间
        prize.setCreateTime(new Date());
//        设置设置审核状态
        prize.setStatus(0);

//       把学生的信息插入到数据库
        for (int i = 0; i < split1.length; i++) {
            prize.setUid( Long.parseLong(split1[i]));
            int j = prizeDao.insert(prize);
            if(j<1){
                return R.exp();
            }
        }
//       把老师的信息插入到数据库
        for (int i = 0; i < split2.length; i++) {
            prize.setUid( Long.parseLong(split2[i]));
//            将指导老师字段设置为空
            prize.setTid(null);
            prize.setTname(null);
            int j = prizeDao.insert(prize);
            if(i==split2.length-1&&j>0){
                return R.ok();
            }
        }
//        操作数据库 将上传的奖项信息循环插入数据库
        return R.exp();
    }
    /**
     * 老师上传奖项
     * @author lt
     */
    @Override
    public R teacherUploadFile(@RequestParam("files") MultipartFile[] files, Prize prize){
        String allpath="";
        for (MultipartFile file : files) {
            if(file.isEmpty()){
                return R.exp(201,"上传文件为空");
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
            String fileName = unique+suffix;
//        定义奖项存储路径
            String path1 = "C://file//prize" ;
            File path = new File(path1 + File.separator + fileName);
            allpath+="/manangmentSystem/file"+ File.separator + fileName+",";
            if(!path.getParentFile().exists()){ //判断文件父目录是否存在
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
        }
//       去掉allpath中的最后一个逗号 这样substring就是符合数据库路径的pathFront了
        String substring = allpath.substring(0, allpath.length() - 1);

//        把pwinner分割
        String[] split = prize.getIsDelete().split(",");
//        设置奖项路径
//        prize.setPathFront("/manangmentSystem/file" + File.separator + fileName);
        prize.setPathFront(substring);
//        设置创建时间
        prize.setCreateTime(new Date());
//        设置设置审核状态
        prize.setStatus(0);

//       把老师的信息插入到数据库
        for (int i = 0; i < split.length; i++) {
            prize.setUid( Long.parseLong(split[i]));
            int j = prizeDao.insert(prize);
            if(i==split.length-1&&j>0){
                return R.ok();
            }
        }
        return R.exp();
    }

    /**
     * @Description: 审核奖项通过
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/12
     */
    @Override
    public R updatePrizeByPizId(ArrayList<Integer> pizIdList, Long authId) {
        for (int i = 0; i < pizIdList.size(); i++) {

            Prize prize = new Prize();
            prize.setPizId(pizIdList.get(i).longValue());
            prize.setAuditId(authId);
            prize.setStatus(1);
            int update = prizeDao.update(prize);
            if (update == 0){
                return R.exp(201,"在第"+ (i+1) +"条审核失败，共审核通过0条");
            }
        }

        return R.ok();
    }

    /**
     * 管理员审核奖项不通过
     * @author lt
     * 2022/2/12
     */
    @Override
    public R failedPrize(Prize prize){
        prize.setStatus(2);
        prize.setModifiedTime(new Date());
        int i = prizeDao.update(prize);
        if(i>0){
            return R.ok().setData(prize);
        }else
            return R.exp(201,"操作失败");
    }

    /**
     * 重新上传奖项
     * @author lt
     * 2022/2/12
     */
    public R restartUpload1(@RequestParam("file") MultipartFile file,Prize prize){

        if(file.isEmpty()){
            return R.exp(201,"上传文件为空");
        }
//       获取文件名
//        String fileName1 = DateTime.Now.ToString("yyyyMMddHHmmss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Random random = new Random();
        String unique = random.nextInt(89999 + 10000) + simpleDateFormat.format(new Date());
//        生成唯一文件名
        String fileName = unique;
//        定义奖项存储路径
        String path1 = "C://file//prize" ;
        File path = new File(path1 + File.separator + fileName);
        if(!path.getParentFile().exists()){ //判断文件父目录是否存在
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
//        设置奖项路径
//        prize.setPathFront("/manangmentSystem/file" + "/" + fileName);
        prize.setPathFront("/manangmentSystem/file" + File.separator + fileName);
//        设置修改时间
        prize.setModifiedTime(new Date());
//        设置为待审核状态
        prize.setStatus(0);
//        将不通过的原因重新置为null
        prize.setReason(null);
//        操作数据库 将上传的奖项信息插入数据库
        int i = prizeDao.update(prize);
        if(i>0){
            return R.ok().setData(prize);
        }
        else return R.exp(201,"重新失败");
    }

    /**
     * 学生重新上传奖项
     * @author lt
     * 2022/2/20
     */
    @Override
    public R restartUpload(@RequestParam("files") MultipartFile[] files,Prize prize){
//        先删除原有的数据库记录再进行上传
        int i = prizeDao.deleteByPathFront(prize);
        if(i<1){
            return R.fail().setData("删除原奖项失败");
        }
        String allpath="";
        for (MultipartFile file : files) {
            if(file.isEmpty()){
                return R.exp(201,"上传文件为空");
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
            String fileName = unique+suffix;
//        定义奖项存储路径
            String path1 = "C://file//prize" ;
            File path = new File(path1 + File.separator + fileName);
            allpath="/manangmentSystem/file"+ File.separator + fileName+",";
            if(!path.getParentFile().exists()){ //判断文件父目录是否存在
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
        }
        //       去掉allpath中的最后一个逗号 这样substring就是符合数据库路径的pathFront了
        String substring = allpath.substring(0, allpath.length() - 1);

//         从pwinner和tid获取所有的获奖人id
//        String  id=prize.getPwinner()+","+prize.getTid();

//        把pwinner分割
        String[] split1 = prize.getPwinner().split(",");

//        把tid分割
        String[] split2 = prize.getTid().split(",");
//        把id以逗号分割
//        String replace = id.replaceAll(",", "").trim();
//        String[] split = id.split(",");

//        设置奖项路径
//        prize.setPathFront("/manangmentSystem/file" + File.separator + fileName);
        prize.setPathFront(substring);

//        设置上传时间
        prize.setCreateTime(new Date());
//        设置为待审核状态
        prize.setStatus(0);
//        将不通过的原因置为null
        prize.setReason(null);

//        操作数据库 将上传的奖项信息循环插入数据库
//        for (int i = 0; i < split.length; i++) {
//            prize.setUid( Long.parseLong(split[i]));
//            int j = prizeDao.update(prize);
//            if(i==split.length-1&&j>0){
//                return R.ok();
//            }
//        }
        return R.exp();
    }


    /**
     * 通过pathFront删除奖项
     * @author lt
     */
    @Override
    public int deleteByPathFront(Prize prize){
        return prizeDao.deleteByPathFront(prize);
    }

}
