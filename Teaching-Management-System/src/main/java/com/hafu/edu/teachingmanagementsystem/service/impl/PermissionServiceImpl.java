package com.hafu.edu.teachingmanagementsystem.service.impl;

import com.hafu.edu.teachingmanagementsystem.entity.Permission;
import com.hafu.edu.teachingmanagementsystem.dao.PermissionDao;
import com.hafu.edu.teachingmanagementsystem.service.PermissionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (Permission)表服务实现类
 *
 * @author makejava
 * @since 2022-02-06 17:46:23
 */
@Service("permissionService")
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Permission queryById(Long pid) {
        return this.permissionDao.queryById(pid);
    }

    /**
     * 分页查询
     *
     * @param permission  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Permission> queryByPage(Permission permission, PageRequest pageRequest) {
        long total = this.permissionDao.count(permission);
        return new PageImpl<>(this.permissionDao.queryAllByLimit(permission, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission insert(Permission permission) {
        this.permissionDao.insert(permission);
        return permission;
    }

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    @Override
    public Permission update(Permission permission) {
        this.permissionDao.update(permission);
        return this.queryById(permission.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long pid) {
        return this.permissionDao.deleteById(pid) > 0;
    }


    /**
     * @Description: 通过roleId查询所有的权限
     * @Param:
     * @return: list
     * @Author: 程世玉
     * @Date: 2022/2/9
     */
    @Override
    public Set<Permission> getPermissionsByRoleId(List<String> roleIds) {
      Set<Permission> permissions = new HashSet<>();
        ArrayList<Permission> list = new ArrayList<>();
        for (String roleId : roleIds) {
            ArrayList<Long> arrayList2 = permissionDao.queryPermissIdByRoleId(roleId);
            for (Long permissionId : arrayList2) {
                Permission permission = permissionDao.queryById(permissionId);
                list.add(permission);
            }
        }
        permissions.addAll(list);
        return permissions;
    }


}
