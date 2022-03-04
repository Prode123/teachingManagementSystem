package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Courseinformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Courseinformation)表服务接口
 *
 * @author makejava
 * @since 2022-02-22 15:58:54
 */
public interface CourseinformationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Courseinformation queryById(Integer id);

    /**
     * 分页查询
     *
     * @param courseinformation 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    Page<Courseinformation> queryByPage(Courseinformation courseinformation, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param courseinformation 实例对象
     * @return 实例对象
     */
    Courseinformation insert(Courseinformation courseinformation);

    /**
     * 修改数据
     *
     * @param courseinformation 实例对象
     * @return 实例对象
     */
    Courseinformation update(Courseinformation courseinformation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    /**
     * @Description: 查询课程名
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/22
     * 根据学院，专业，年级，学期，层次查询课程名
     */
    R queryByInfo(Courseinformation courseinformation);
}
