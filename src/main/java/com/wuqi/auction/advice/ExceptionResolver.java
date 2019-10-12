package com.wuqi.auction.advice;

import com.wuqi.auction.exception.AuctionException;
import com.wuqi.auction.exception.NormalException;
import com.wuqi.auction.utils.FieldValidatedInfo;
import com.wuqi.auction.utils.ResultWrapper;
import com.wuqi.auction.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@RestControllerAdvice
@Slf4j
public class ExceptionResolver {

    @ExceptionHandler(NormalException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultWrapper handleNormalException(NormalException e) {
        return ResultWrapper.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(AuctionException.class)
    public ResponseEntity<ResultWrapper> handleInterruptException(AuctionException e) {
        log.error("必须解决的异常: ", e);
        return ResponseEntity.status(e.getCode())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(ResultWrapper.error(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultWrapper handleDBException(SQLException e) {
        log.warn("数据库出错, 错误码: {}", e.getErrorCode());
        log.warn("原因为: ", e);
        switch (e.getErrorCode()) {
            case 1062:
                return ResultWrapper.error("数据重复");
            case 1451:
                return ResultWrapper.error("外键约束问题");
        }
        return ResultWrapper.error("数据操作失败");
    }

    /**
     * 捕获所有数据校验问题
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultWrapper handleValidException(MethodArgumentNotValidException e) {
        log.warn("数据校验未通过: ", e);
        Collection<FieldValidatedInfo> errors = ValidationUtils.convert(e.getBindingResult());
        return ResultWrapper.error("请检查数据合法性", errors);
    }
}
