package com.hafu.edu.teachingmanagementsystem.Exception;

import com.hafu.edu.teachingmanagementsystem.Exception.ex.getUserNullPointerException;
import com.hafu.edu.teachingmanagementsystem.Utils.R;
import com.hafu.edu.teachingmanagementsystem.service.impl.UserServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author lt
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

    /**
     * 捕捉异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public R handlerServiceException(ServiceException e) {
//        打印异常信息 测试时使用
        e.printStackTrace();
        return R.exp(e.getErrorCode(), e.getErrorMsg());
    }



    /**
     * 统一异常处理
     */
    @ExceptionHandler(Exception.class)
    public R handlerException(Exception e) {
        e.printStackTrace();
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return R.exp(201,e.getMessage()+"，请您正确操作！！");
        }else if (e instanceof AccessDeniedException){
            return R.exp(403,"您没有权限操作该部分！！");
        }
        return R.exp();
    }

    /**
     * getUser通过number获取学生信息的时候出现任何异常就抛出这个异常
     * @param e 异常信息
     * @return json
     */
    @ExceptionHandler(getUserNullPointerException.class)
    public R getUserNullException(Exception e) {
        e.printStackTrace();
        R r = new R();
        r.setCode(201);
        r.setMsg(e.getMessage());
        return r;
    }



}

