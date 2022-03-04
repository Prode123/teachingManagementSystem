package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.User;
import com.hafu.edu.teachingmanagementsystem.entity.UserImages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * (UserImages)表服务接口
 *
 * @author makejava
 * @since 2022-02-06 17:47:16
 */

public interface UserImagesService {

    /**
     * 通过ID查询单条数据
     *
     * @param useId 主键
     * @return 实例对象
     */
    UserImages queryById(Long useId);

    /**
     * 分页查询
     *
     * @param userImages  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<UserImages> queryByPage(UserImages userImages, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userImages 实例对象
     * @return 实例对象
     */
    UserImages insert(UserImages userImages);

    /**
     * 修改数据
     *
     * @param userImages 实例对象
     * @return 实例对象
     */
    UserImages update(UserImages userImages);

    /**
     * 通过主键删除数据
     *
     * @param useId 主键
     * @return 是否成功
     */
    boolean deleteById(Long useId);

    /**
     * 通过用户id查询个人头像
     * @author lt
     */
    R selectByUserId(User user);


    /**
     * 通过用户id修改头像
     * @author lt
     */
    R updateHeadImage(@RequestParam("fileName") MultipartFile file, User user);

}
