package com.hafu.edu.teachingmanagementsystem.Utils;

import com.hafu.edu.teachingmanagementsystem.Exception.ErrorCodeEnum;
import lombok.Data;

@Data
public class R {
    private int code;
    private String msg;
    private Object data;

    /**
     * 设置数据
     *
     * @param data 数据
     * @return R
     */
    public R setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * 操作成功
     *
     * @return R
     */
    public static R ok() {
        R r = new R();
        r.code = 200;
        r.msg = "OK";
        return r;
    }

    /**
     * 操作失败
     *
     * @return R
     */
    public static R fail() {
        R r = new R();
        r.code = 205;
        r.msg = "fail";
        return r;
    }

    /**
     * 系统异常
     */
    public static R exp() {
        R r = new R();
        r.code = 500;
        r.msg = "exception";
        return r;
    }


    /**
     * 运行时异常
     */
    public static R exp(int code, String msg) {
        R r = new R();
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static R exp(ErrorCodeEnum errorCodeEnum) {
        R r = new R();
        r.code = errorCodeEnum.getResultCode();
        r.msg = errorCodeEnum.getResultMsg();
        return r;
    }
}

