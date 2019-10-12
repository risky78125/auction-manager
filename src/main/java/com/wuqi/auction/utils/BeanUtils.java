package com.wuqi.auction.utils;

import com.wuqi.auction.exception.AuctionException;
import lombok.extern.slf4j.Slf4j;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Slf4j
public class BeanUtils {

    private BeanUtils() {
    }

    public static <T> T copy(Object source, Class<T> clazz) {
        try {
            T obj = clazz.newInstance();
            org.springframework.beans.BeanUtils.copyProperties(source, obj);
            return obj;
        } catch (Exception e) {
            log.error("类[{}]无法实例化, 请检查. 可能的原因是: {}", clazz.getName(), e.getMessage());
            throw new AuctionException(500, e);
        }
    }
}
