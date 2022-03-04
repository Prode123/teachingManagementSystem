package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.dao.CourseinformationDao;
import com.hafu.edu.teachingmanagementsystem.entity.Courseinformation;
import com.hafu.edu.teachingmanagementsystem.service.CourseinformationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Courseinformation)表服务实现类
 *
 * @author makejava
 * @since 2022-02-22 15:58:54
 */
@Service("courseinformationService")
public class CourseinformationServiceImpl implements CourseinformationService {
    @Resource
    private CourseinformationDao courseinformationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Courseinformation queryById(Integer id) {
        return this.courseinformationDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param courseinformation 筛选条件
     * @param pageRequest       分页对象
     * @return 查询结果
     */
    @Override
    public Page<Courseinformation> queryByPage(Courseinformation courseinformation, PageRequest pageRequest) {
        long total = this.courseinformationDao.count(courseinformation);
        return new PageImpl<>(this.courseinformationDao.queryAllByLimit(courseinformation, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param courseinformation 实例对象
     * @return 实例对象
     */
    @Override
    public Courseinformation insert(Courseinformation courseinformation) {
        this.courseinformationDao.insert(courseinformation);
        return courseinformation;
    }

    /**
     * 修改数据
     *
     * @param courseinformation 实例对象
     * @return 实例对象
     */
    @Override
    public Courseinformation update(Courseinformation courseinformation) {
        this.courseinformationDao.update(courseinformation);
        return this.queryById(courseinformation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {

        return this.courseinformationDao.deleteById(id) > 0;
    }
    /**
     * @Description: 查询课程名
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/22
     * 根据学院，专业，年级，学期，层次查询课程名
     */
    @Override
    public R queryByInfo(Courseinformation courseinformation) {
        /*通过限制条件查询出所有满足条件的课程*/
        ArrayList<String> list = courseinformationDao.queryByLimit(courseinformation);

        /*判断list是否为空*/
        if (list.size() == 0){
            return R.exp(201,"抱歉，查询错误，请重新查询");
        }

        return R.ok().setData(list);
    }
}
