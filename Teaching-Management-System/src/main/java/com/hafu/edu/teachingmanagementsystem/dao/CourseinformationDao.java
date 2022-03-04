package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.entity.Courseinformation;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * (Courseinformation)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-22 15:58:53
 */
public interface CourseinformationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Courseinformation queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param courseinformation 查询条件
     * @param pageable          分页对象
     * @return 对象列表
     */
    List<Courseinformation> queryAllByLimit(Courseinformation courseinformation, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param courseinformation 查询条件
     * @return 总行数
     */
    long count(Courseinformation courseinformation);

    /**
     * 新增数据
     *
     * @param courseinformation 实例对象
     * @return 影响行数
     */
    int insert(Courseinformation courseinformation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courseinformation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Courseinformation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Courseinformation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Courseinformation> entities);

    /**
     * 修改数据
     *
     * @param courseinformation 实例对象
     * @return 影响行数
     */
    int update(Courseinformation courseinformation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    ArrayList<String> queryByLimit(Courseinformation courseinformation);
}

