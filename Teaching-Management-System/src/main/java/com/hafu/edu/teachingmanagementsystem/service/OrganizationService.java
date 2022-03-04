package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.entity.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Organization)表服务接口
 *
 * @author makejava
 * @since 2022-02-15 23:01:01
 */
public interface OrganizationService {

    /**
     * 通过ID查询单条数据
     *
     * @param collegeId 主键
     * @return 实例对象
     */
    Organization queryById(Long collegeId);

    /**
     * 分页查询
     *
     * @param organization 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    Page<Organization> queryByPage(Organization organization, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    Organization insert(Organization organization);

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    Organization update(Organization organization);

    /**
     * 通过主键删除数据
     *
     * @param collegeId 主键
     * @return 是否成功
     */
    boolean deleteById(Long collegeId);

    R queryByCommonAndCondition(String faculty, String condition);

}
