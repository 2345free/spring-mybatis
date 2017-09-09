package com.example.samples.sm.service.exception;

import java.io.Serializable;


/**
 * 〈一句话功能简述〉<br>
 * 〈运行时异常统一使用此异常包装后向上抛出, 统一异常处理类GlobalExceptionResolver会处理并返回响应〉
 *
 * @author tianyi
 * @create 2017/8/23
 * @since 1.0.0
 */
public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1468560227019739872L;

    private String code;

    private String errMsg;

    public BusinessException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public BusinessException(String code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public BusinessException(String code, String errMsg, Throwable cause) {
        this.code = code;
        this.errMsg = errMsg;
    }

    public BusinessException(String errMsg, Throwable cause) {
        super(errMsg, cause);
        this.code = "500";
        this.errMsg = errMsg;
    }

    public BusinessException(Throwable cause) {
        super(cause);
        this.code = "500";
        this.errMsg = "system error";
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
