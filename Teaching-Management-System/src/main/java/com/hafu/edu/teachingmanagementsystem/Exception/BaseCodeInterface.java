package com.hafu.edu.teachingmanagementsystem.Exception;

/**
 * @author lt
 */
public interface BaseCodeInterface {

    /**
     * 错误码
     */
    int getResultCode();

    /**
     * 错误描述
     */
    String getResultMsg();
}
