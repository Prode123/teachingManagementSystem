package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.entity.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Document)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-06 17:45:55
 */
public interface DocumentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param did 主键
     * @return 实例对象
     */
    Document queryById(Long did);

    /**
     * 查询指定行数据
     *
     * @param document 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Document> queryAllByLimit(Document document, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param document 查询条件
     * @return 总行数
     */
    long count(Document document);

    /**
     * 新增数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int insert(Document document);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Document> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Document> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Document> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Document> entities);

    /**
     * 修改数据
     *
     * @param document 实例对象
     * @return 影响行数
     */
    int update(Document document);

    /**
     * 通过主键删除数据
     *
     * @param did 主键
     * @return 影响行数
     */
    int deleteById(Long did);

    /**
     * 查询学生人才培养方案
     * @return
     */
    List<Document> getStudentTrainResouce(Document document);


    /**
     * 用户根据指定条件查询数据
     * @author lt
     */
    List<Document> mohuSelect(Document document);

    /**
     * 管理员根据审核条件查询所有文件
     * @author lt
     */
    List<Document> selectAllDocument(Document document);

    /**
     * 上传文件
     * @author lt
     * 2022/2/11
     */
    int uploadFile(Document document);
}

