package com.hafu.edu.teachingmanagementsystem.Exception.ex;

/**
 * @author 程世玉
 * @create 2022/2/8 16:13
 * @PROJECT_NAME Teaching-Management-System
 * @Description getUser出现为null，number不存在，抛出这个异常
 */

public class getUserNullPointerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public getUserNullPointerException() {
        super();
    }

    public getUserNullPointerException(String message) {
        super(message);
    }

    public getUserNullPointerException(String message, Throwable cause) {
        super(message, cause);
    }

    public getUserNullPointerException(Throwable cause) {
        super(cause);
    }

    protected getUserNullPointerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
