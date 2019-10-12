package com.wuqi.auction.exception;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class AuctionException extends RuntimeException {

    private int code;

    public AuctionException() {
        this(400);
    }

    public AuctionException(int code) {
        this.code = code;
    }

    public AuctionException(String message) {
        this(400, message);
    }

    public AuctionException(int code, String message) {
        super(message);
        this.code = code;
    }

    public AuctionException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public AuctionException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
