package com.hafu.edu.teachingmanagementsystem.Config;


import com.hafu.edu.teachingmanagementsystem.Utils.splitUtils;
import com.hafu.edu.teachingmanagementsystem.entity.Permission;
import com.hafu.edu.teachingmanagementsystem.service.PermissionService;
import com.hafu.edu.teachingmanagementsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author 程世玉
 * @create 2022/1/23 21:38
 * @PROJECT_NAME StoreProject2_0_version
 * @Description
 */
@Component
public class MyuserDetailsService  implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    public static SpringSecurityUser  user = null;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1、获取数据库数据
        com.hafu.edu.teachingmanagementsystem.entity.User originAdmin = userService.getUserByNumber(username);

        // 2、通过这个user读取所有的角色

        String roleId = originAdmin.getRoleId();
        List<String> roleList_Id = splitUtils.splitString(roleId, ",");

        // 3、通过这个user读取所有的权限
        Set<Permission> permissionList = permissionService.getPermissionsByRoleId(roleList_Id);
        // 4、创建一个list集合用来存放权限和角色信息
        ArrayList<GrantedAuthority> authorityList = new ArrayList<>();
        // 5、存入所有的角色信息

        /*5、存入角色信息*/
        for (String role : roleList_Id) {
            /*获取*/
            String roleName = "ROLE_" + role;

            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(roleName);

            authorityList.add(simpleGrantedAuthority);

        }

        /*6、存入权限信息*/
        for (Permission authority : permissionList) {
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(authority.getOperation());

            authorityList.add(simpleGrantedAuthority);
        }

         user = new SpringSecurityUser(originAdmin, authorityList);

        return user;

    }
}
