package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.entity.Organization;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Organization)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-15 23:01:01
 */
public interface OrganizationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collegeId 主键
     * @return 实例对象
     */
    Organization queryById(Long collegeId);

    /**
     * 查询指定行数据
     *
     * @param organization 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<Organization> queryAllByLimit(Organization organization, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param organization 查询条件
     * @return 总行数
     */
    long count(Organization organization);

    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 影响行数
     */
    int insert(Organization organization);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Organization> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Organization> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Organization> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Organization> entities);

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 影响行数
     */
    int update(Organization organization);

    /**
     * 通过主键删除数据
     *
     * @param collegeId 主键
     * @return 影响行数
     */
    int deleteById(Long collegeId);

    /**
     * @Description: 查询学院下或者部门下的信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/15
     */
    List<String> queryByCommonAndCondition(@Param("faculty") String faculty, @Param("condition") String condition);
}

