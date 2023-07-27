package com.kevin.testproj.common.exception;

import com.kevin.testproj.common.dto.ResponseCode;

public class BizException extends RuntimeException {
    private final ResponseCode errorCode;

    public BizException() {
        super(ResponseCode.INTERNAL_ERROR.getMessage());
        this.errorCode = ResponseCode.INTERNAL_ERROR;
    }

    public BizException(String message) {
        super(message);
        this.errorCode = ResponseCode.INTERNAL_ERROR;
    }

    public BizException(String message, Throwable cause) {
        super(ResponseCode.INTERNAL_ERROR.getMessage(message), cause);
        this.errorCode = ResponseCode.INTERNAL_ERROR;
    }

    public BizException(Throwable cause) {
        super(ResponseCode.INTERNAL_ERROR.getMessage(cause));
        this.errorCode = ResponseCode.INTERNAL_ERROR;
    }

    public BizException(ResponseCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BizException(ResponseCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(ResponseCode errorCode, String message, Throwable cause) {
        super(errorCode.getMessage(message), cause);
        this.errorCode = errorCode;
    }

    public BizException(ResponseCode errorCode, Throwable cause) {
        super(errorCode.getMessage(cause), cause);
        this.errorCode = errorCode;
    }

    public ResponseCode getErrorCode() {
        return this.errorCode;
    }
}
