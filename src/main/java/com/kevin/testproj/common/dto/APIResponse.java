package com.kevin.testproj.common.dto;

import org.springframework.http.HttpStatus;
public class APIResponse<T> extends ResponseDto{
    private final T data;

    private APIResponse(T data) {
        super(true, ResponseCode.OK.getCode(), ResponseCode.OK.getMessage());
        this.data = data;
    }

    private APIResponse(T data, String message) {
        super(true, ResponseCode.OK.getCode(), message);
        this.data = data;
    }

    private APIResponse(ResponseCode code) {
        super(HttpStatus.OK == code.getHttpStatus(), code.getCode(), code.getMessage());
        this.data = null;
    }

    private APIResponse(ResponseCode code, String message) {
        super(HttpStatus.OK == code.getHttpStatus(), code.getCode(), message);
        this.data = null;
    }

    private APIResponse(Exception ex, Integer code) {
        super(false, code, ex.getMessage());
        this.data = null;
    }

    public static <T> APIResponse<T> of(ResponseCode code) {
        return new APIResponse(code);
    }

    public static <T> APIResponse<T> of(ResponseCode code, String message) {
        return new APIResponse(code, message);
    }

    public static <T> APIResponse<T> of(Exception ex, Integer code) {
        return new APIResponse(ex, code);
    }

    public static <T> APIResponse<T> of(T data) {
        return new APIResponse(data);
    }

    public static <T> APIResponse<T> of(T data, String message) {
        return new APIResponse(data, message);
    }

    public static <T> APIResponse<T> empty() {
        return new APIResponse((ResponseCode)null);
    }

    public T getData() {
        return this.data;
    }
}
