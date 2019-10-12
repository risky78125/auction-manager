package com.wuqi.auction.advice;

import com.wuqi.auction.exception.AuctionException;
import com.wuqi.auction.utils.ResultWrapper;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(AuctionException.class)
    public ResponseEntity<ResultWrapper> handleInterruptException(AuctionException e) {
        return ResponseEntity.status(e.getCode())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(ResultWrapper.error(e.getCode(), e.getMessage()));
    }

}
