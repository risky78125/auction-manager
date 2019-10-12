package com.wuqi.auction.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class ResultWrapper {

    private static final int DEFAULT_SUCCESS_CODE = HttpStatus.OK.value();
    private static final String DEFAULT_SUCCESS_MESSAGE = HttpStatus.OK.getReasonPhrase();
    private static final int DEFAULT_ERROR_CODE = HttpStatus.BAD_REQUEST.value();
    private static final String DEFAULT_ERROR_MESSAGE = HttpStatus.BAD_REQUEST.getReasonPhrase();

    private int code;
    private boolean status;
    private String message;
    private Object data;

    private ResultWrapper() {
    }

    private ResultWrapper(int code, boolean status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /* ---------------表示成功-------------- */

    public static ResultWrapper success() {
        return success(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE);
    }

    public static ResultWrapper success(int code) {
        return success(code, handleMessage(code));
    }

    public static ResultWrapper success(String message) {
        return success(DEFAULT_SUCCESS_CODE, message);
    }

    public static ResultWrapper success(Object data) {
        return success(DEFAULT_SUCCESS_CODE, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static ResultWrapper success(int code, String message) {
        return success(code, message, null);
    }

    public static ResultWrapper success(int code, String message, Object data) {
        String msg = handleMessage(code, message);
        return create(code, true, msg, data);
    }

    /* ---------------表示失败-------------- */

    public static ResultWrapper error() {
        return error(DEFAULT_ERROR_CODE, DEFAULT_ERROR_MESSAGE);
    }

    public static ResultWrapper error(String message) {
        return error(DEFAULT_ERROR_CODE, message);
    }

    public static ResultWrapper error(int code) {
        return error(code, handleMessage(code));
    }

    public static ResultWrapper error(int code, String message) {
        String msg = handleMessage(code, message);
        return create(code, false, msg, null);
    }

    /* ---------------私有方法-------------- */

    private static ResultWrapper create(int code, boolean status, String message, Object data) {
        return new ResultWrapper(code, status, message, data);
    }

    private static String handleMessage(int code) {
        return HttpStatus.valueOf(code).getReasonPhrase();
    }

    private static String handleMessage(int code, String message) {
        return StringUtils.isEmpty(message) ? HttpStatus.valueOf(code).getReasonPhrase() : message;
    }

}
