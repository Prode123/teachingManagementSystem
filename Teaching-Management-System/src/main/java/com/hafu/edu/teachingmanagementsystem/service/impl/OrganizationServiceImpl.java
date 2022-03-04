package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.dao.OrganizationDao;
import com.hafu.edu.teachingmanagementsystem.entity.Organization;
import com.hafu.edu.teachingmanagementsystem.service.OrganizationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Organization)表服务实现类
 *
 * @author makejava
 * @since 2022-02-15 23:01:01
 */
@Service("organizationService")
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private OrganizationDao organizationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collegeId 主键
     * @return 实例对象
     */
    @Override
    public Organization queryById(Long collegeId) {
        return this.organizationDao.queryById(collegeId);
    }

    /**
     * 分页查询
     *
     * @param organization 筛选条件
     * @param pageRequest  分页对象
     * @return 查询结果
     */
    @Override
    public Page<Organization> queryByPage(Organization organization, PageRequest pageRequest) {
        long total = this.organizationDao.count(organization);
        return new PageImpl<>(this.organizationDao.queryAllByLimit(organization, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    @Override
    public Organization insert(Organization organization) {
        this.organizationDao.insert(organization);
        return organization;
    }

    /**
     * 修改数据
     *
     * @param organization 实例对象
     * @return 实例对象
     */
    @Override
    public Organization update(Organization organization) {
        this.organizationDao.update(organization);
        return this.queryById(organization.getCollegeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collegeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long collegeId) {
        return this.organizationDao.deleteById(collegeId) > 0;
    }

    /**
     * @Description: 查询学院下或者部门下的信息
     * @Param:
     * @return: json
     * @Author: 程世玉
     * @Date: 2022/2/15
     */
    @Override
    public R queryByCommonAndCondition(String factory, String condition) {
        List<String> list = organizationDao.queryByCommonAndCondition(factory,condition);


        return new R().setData(list);
    }
}
