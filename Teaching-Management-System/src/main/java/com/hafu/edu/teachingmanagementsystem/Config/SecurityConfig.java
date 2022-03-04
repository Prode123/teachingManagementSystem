package com.hafu.edu.teachingmanagementsystem.Config;

import com.hafu.edu.teachingmanagementsystem.Exception.SimpleAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 程世玉
 * @create 2022/1/23 15:39
 * @PROJECT_NAME StoreProject2_0_version
 * @Description
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        /*用户可以有角色或者权限即可，但是如果没有权限或者角色是不可以的*/
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
    }


    @Override
    protected void configure(HttpSecurity security) throws Exception {

        security.csrf().disable();
        //开启跨域访问
        security.cors().disable();
        security.authorizeRequests()
                .antMatchers("/css/**")
                .permitAll()
                .antMatchers("/js/**")
                .permitAll()
                .antMatchers("/img/**")
                .permitAll()
                .antMatchers("/file/**")
                .permitAll()
                .antMatchers("/user/getCode")
                .permitAll()
                .antMatchers("/fileOperate/restartUpload")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/index.html")
                .permitAll()
                .loginProcessingUrl("/user/tologin")
                .permitAll()
                .successForwardUrl("/user/LoginSuccess")
                .permitAll()
                .failureForwardUrl("/user/loginError")
                .permitAll()
                .usernameParameter("number")
                .passwordParameter("passwd")
                .and()
                .logout()
                .logoutSuccessUrl("/index.html")
                .and()
                .exceptionHandling()
                .accessDeniedHandler(new SimpleAccessDeniedHandler());
    }
}
