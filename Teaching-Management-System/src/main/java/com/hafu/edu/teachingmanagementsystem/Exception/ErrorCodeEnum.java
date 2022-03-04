package com.hafu.edu.teachingmanagementsystem.Exception;

import lombok.Getter;

/**
 * @author lt
 */
@Getter
public enum ErrorCodeEnum implements BaseCodeInterface{

    // 数据操作错误定义
    BODY_NOT_MATCH(400, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(401, "登录已失效!"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503, "服务器正忙，请稍后再试!"),
    //用户相关：10000**
    USER_ACCOUNT_NOT_FOUND(10001, "账号不存在!"),
    DoNotAllowToDisableTheCurrentUser(10002, "不允许禁用当前用户"),
    USER_USERNAME_NOT_ACCESS(10003, "未获取到用户名"),
    USER_PASSWORD_ERROR(10004, "密码错误"),
    MENU_NOT_ERROR(10005, "没有菜单"),
    RESOURCE_DOES_NOT_EXIST(10006, "抱歉，您所操作的资源不存在"),
    BATCH_DELETION_FAILED(10007, "批量删除失败"),
    DOWNLOAD_ERROR(10008,"下载错误，请重新操作");
    //业务异常

    /**
     * 错误码
     */
    private int resultCode;

    /**
     * 错误描述
     */
    private String resultMsg;

    ErrorCodeEnum(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

}
