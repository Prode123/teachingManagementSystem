package com.hafu.edu.teachingmanagementsystem.dao;

import com.hafu.edu.teachingmanagementsystem.entity.Prize;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * (Prize)表数据库访问层
 *
 * @author makejava
 * @since 2022-02-06 17:46:37
 */
public interface PrizeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pizId 主键
     * @return 实例对象
     */
    Prize queryById(Long pizId);

    /**
     * 查询指定行数据
     *
     * @param prize    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Prize> queryAllByLimit(Prize prize, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param prize 查询条件
     * @return 总行数
     */
    long count(Prize prize);

    /**
     * 新增数据
     *
     * @param prize 实例对象
     * @return 影响行数
     */
    int insert(Prize prize);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Prize> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Prize> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Prize> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Prize> entities);

    /**
     * 修改数据
     *
     * @param prize 实例对象
     * @return 影响行数
     */
    int update(Prize prize);

    /**
     * 通过主键删除数据
     *
     * @param pizId 主键
     * @return 影响行数
     */
    int deleteById(Long pizId);


    /**
     * 通过用户id查询当前用户的所有奖项
     * @author lt
     */
    List<Prize> selectAllPrize(Prize prize);



    /**
     * 管理员根据审核状态查询奖项
     * @author lt
     */
    List<Prize> findAllPrize(Prize prize);


    /**
     * 管理员通过条件查询本学院的奖项 用于下载Excel文件
     * @author lt
     * 2022/2/15
     */
    List<Prize> adminFindAllPrize(Prize prize);

    /**
     * 管理员通过条件仅查询本学院老师的奖项 用于下载Excel文件
     * @author lt
     * 2022/2/15
     */
    List<Prize> adminFindAllTeacherPrize(Prize prize);

    /**
     * 管理员通过条件仅查询本学院学生的奖项 用于下载Excel文件
     * @author lt
     * 2022/2/15
     */
    List<Prize> adminFindAllStudentPrize(Prize prize);

    /**
     * 通过图片路径删除奖项 此接口计划为奖项重新上传服务
     * @author lt
     */
    int deleteByPathFront(Prize prize);

    /**
     * 测试多状态查询
     * @author lt
     */
    List<Prize> testStatus(Prize prize);
}

