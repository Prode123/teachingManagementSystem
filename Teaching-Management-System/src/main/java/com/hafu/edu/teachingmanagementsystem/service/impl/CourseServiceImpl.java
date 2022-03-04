package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.entity.Course;
import com.hafu.edu.teachingmanagementsystem.dao.CourseDao;
import com.hafu.edu.teachingmanagementsystem.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:45:40
 */
@Service("courseService")
@Transactional
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseDao courseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    @Override
    public Course queryById(Long cid) {
        return this.courseDao.queryById(cid);
    }

    /**
     * 分页查询
     *
     * @param course      筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Course> queryByPage(Course course, PageRequest pageRequest) {
        long total = this.courseDao.count(course);
        return new PageImpl<>(this.courseDao.queryAllByLimit(course, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course insert(Course course) {
        this.courseDao.insert(course);
        return course;
    }

    /**
     * 修改数据
     *
     * @param course 实例对象
     * @return 实例对象
     */
    @Override
    public Course update(Course course) {
        this.courseDao.update(course);
        return this.queryById(course.getCid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long cid) {
        return this.courseDao.deleteById(cid) > 0;
    }
}
