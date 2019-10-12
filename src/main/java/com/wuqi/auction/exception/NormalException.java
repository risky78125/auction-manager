package com.wuqi.auction.exception;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class NormalException extends AuctionException {

    public NormalException() {
    }

    public NormalException(int code) {
        super(code);
    }

    public NormalException(String message) {
        super(message);
    }

    public NormalException(int code, String message) {
        super(code, message);
    }

    public NormalException(int code, Throwable cause) {
        super(code, cause);
    }

    public NormalException(int code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
