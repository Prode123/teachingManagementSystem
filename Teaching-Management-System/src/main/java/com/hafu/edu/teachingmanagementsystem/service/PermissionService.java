package com.hafu.edu.teachingmanagementsystem.service;

import com.hafu.edu.teachingmanagementsystem.entity.Permission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * (Permission)表服务接口
 *
 * @author makejava
 * @since 2022-02-06 17:46:23
 */

public interface PermissionService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Permission queryById(Long pid);

    /**
     * 分页查询
     *
     * @param permission  筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Permission> queryByPage(Permission permission, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 实例对象
     */
    Permission update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Long pid);

    /**
     * 通过roleId查询所有的权限
     * @param roleIds roleid
     * @return List<Permission>
     */
    Set<Permission> getPermissionsByRoleId(List<String> roleIds);

}
