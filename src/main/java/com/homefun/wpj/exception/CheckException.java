package com.homefun.wpj.exception;

/**
 * Name：CheckException
 * Time：2016/8/24 14:42
 * author：WPJ587
 * description：验证异常
 **/

public class CheckException extends RuntimeException {
    private String errCode;
    private String errMsg;

    public CheckException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errCode, String errMsg) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
    public CheckException(String errCode,String errMsg){
        this.errCode=errCode;
        this.errMsg=errMsg;
    }
    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

}
