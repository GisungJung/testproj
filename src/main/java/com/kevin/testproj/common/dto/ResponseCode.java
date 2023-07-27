package com.kevin.testproj.common.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kevin.testproj.common.exception.BizException;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ResponseCode {
    OK(200,HttpStatus.OK, "Ok"),
    INVALID_REFRESH_TOKEN(401, HttpStatus.BAD_REQUEST, "Invalid Refresh Token"),
    BAD_REQUEST(400, HttpStatus.BAD_REQUEST, "Bad request"),
    INVALID_PASSWORD(401, HttpStatus.NOT_FOUND, "비밀번호가 틀립니다"),
    INVALID_USERID(401, HttpStatus.NOT_FOUND, "아이디가 존재하지 않습니다"),
    VALIDATION_ERROR(402, HttpStatus.BAD_REQUEST, "Validation error"),
    NOT_FOUND(404, HttpStatus.NOT_FOUND, "Requested resource is not found"),
    Menu_Exist(409, HttpStatus.CONFLICT,"이미 존재하는 MenuCd입니다"),
    INTERNAL_ERROR(9999, HttpStatus.INTERNAL_SERVER_ERROR, "현재 일시적인 장애로 인해 서비스 접속이 원활하지 않습니다."),
    DATA_ACCESS_ERROR(501, HttpStatus.INTERNAL_SERVER_ERROR, "Data access error"),
    UNAUTHORIZED(403, HttpStatus.UNAUTHORIZED, "User unauthorized"),
    TOKEN_CREATE_FAIL(7000, HttpStatus.INTERNAL_SERVER_ERROR, "토큰 생성에 실패하였습니다."),
    USER_NOT_FOUND(7001, HttpStatus.NOT_FOUND, "사용자 ID/PW 로그인 결과 : 로그인 실패. ID또는 PW를 확인하세요."),
    SSO_CONN_FAIL(7002, HttpStatus.BAD_REQUEST, "한샘 SSO 로그인을 해주세요."),
    COM_USER_NOT_FOUND(7003, HttpStatus.NOT_FOUND, "등록된 사용자 정보가 존재하지 않습니다."),
    USER_INFO_ERROR(7004, HttpStatus.INTERNAL_SERVER_ERROR, "복수권한 사용자 입니다."),
    TOKEN_VALID_FAILED(7005, HttpStatus.UNAUTHORIZED, "엑세스 토큰 검증에 실패하였습니다."),
    DUPLICATE_LOGIN_ERROR(7006, HttpStatus.UNAUTHORIZED, "중복 로그인 입니다."),
    USER_AUTH_CHANGE_ERROR(7007, HttpStatus.UNAUTHORIZED, "권한이 변경되었습니다."),
    MOBL_USE_PSBL_ERROR(7008, HttpStatus.UNAUTHORIZED, "모바일 미등록 사용자입니다. 관리자에게 문의 해주세요. "),
    MOBL_USE_CRTF_ERROR(7009, HttpStatus.UNAUTHORIZED, " 인증 만료 계정입니다."),
    WEB_AUTH_NOT_FOUND(7010, HttpStatus.UNAUTHORIZED, " 이용권한이 없습니다."),
    MOBL_COM_AUTH_ERROR(8000, HttpStatus.INTERNAL_SERVER_ERROR, "조회권한 오류 입니다."),
    MOBL_EXPIRED_KCM_ERROR(8001, HttpStatus.INTERNAL_SERVER_ERROR, "본인인증 기한이 만료 되었습니다."),
    MOBL_EXPIRED_CERT_ERROR(8002, HttpStatus.INTERNAL_SERVER_ERROR, "간편인증 기한이 만료 되었습니다."),
    DAYOFF_CAPA_ERROR(9001, HttpStatus.INTERNAL_SERVER_ERROR, "해당 날짜의 휴무CAPA를 변경하시겠습니까?"),
    DAYOFF_BLEN_CAPA_ERROR(9002, HttpStatus.INTERNAL_SERVER_ERROR, ""),
    SERVICE_MAINTENANCE_ERROR(9003, HttpStatus.INTERNAL_SERVER_ERROR, ""),
    SERVICE_MAINTENANCE_ALERT_ERROR(9004, HttpStatus.INTERNAL_SERVER_ERROR, ""),
    NOT_MAPPED_TO_BLCO_NO_ERROR(9005, HttpStatus.INTERNAL_SERVER_ERROR, "아이디에 매핑된 소속협력사 코드가 존재하지 않습니다."),
    NOT_REG_TO_BLCO_NO_ERROR(9006, HttpStatus.INTERNAL_SERVER_ERROR, "등록되어있지 않은 소속협력사 코드입니다.");



    private final Integer code;
    private final HttpStatus httpStatus;
    private final String message;

    public String getMessage(Throwable e) {
        String var10001 = this.getMessage();
        return this.getMessage(var10001 + " - " + e.getMessage());
    }

    public String getMessage(String message) {
        return (String) Optional.ofNullable(message).filter(Predicate.not(String::isBlank)).orElse(this.getMessage());
    }

    public static ResponseCode valueOf(HttpStatus httpStatus) {
        if (httpStatus == null) {
            throw new BizException("HttpStatus is null.");
        } else {
            return (ResponseCode) Arrays.stream(values()).filter((errorCode) -> {
                return errorCode.getHttpStatus() == httpStatus;
            }).findFirst().orElseGet(() -> {
                if (httpStatus.is4xxClientError()) {
                    return BAD_REQUEST;
                } else {
                    return httpStatus.is5xxServerError() ? INTERNAL_ERROR : OK;
                }
            });
        }
    }

    public String toString() {
        return String.format("%s (%d)", this.name(), this.getCode());
    }

    private ResponseCode(final Integer code, final HttpStatus httpStatus, final String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    public String getMessage() {
        return this.message;
    }

}
