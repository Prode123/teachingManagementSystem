package com.hafu.edu.teachingmanagementsystem.Utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author 程世玉
 * @create 2022/2/7 9:59
 * @PROJECT_NAME Teaching-Management-System
 * @Description  本类继承BCryptPasswordEncoder，用来进行密码加密
 *              使用的时候，直接用本类对象调用encoder（）方法即可
 */

@Component
public class BCryptPasswordEncoderUtils extends BCryptPasswordEncoder {

}
