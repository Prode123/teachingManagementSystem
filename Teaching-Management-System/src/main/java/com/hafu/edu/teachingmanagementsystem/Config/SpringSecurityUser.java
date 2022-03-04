package com.hafu.edu.teachingmanagementsystem.Config;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

/**
 * @author 程世玉
 * @create 2022/1/23 21:34
 * @PROJECT_NAME StoreProject2_0_version
 * @Description
 */
public class SpringSecurityUser extends User {
    private static final long serialVersionUID = 1L;

    private final com.hafu.edu.teachingmanagementsystem.entity.User originalUserDB;

    public SpringSecurityUser(com.hafu.edu.teachingmanagementsystem.entity.User originalUserDB, List<GrantedAuthority> authorities){
        super(originalUserDB.getUsername(),originalUserDB.getPasswd(),authorities);
        this.originalUserDB = originalUserDB;
        this.originalUserDB.setPasswd(null);
    }

    public com.hafu.edu.teachingmanagementsystem.entity.User getOriginalUserDB() {
        return originalUserDB;
    }
}
