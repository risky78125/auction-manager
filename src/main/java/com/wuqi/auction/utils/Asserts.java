package com.wuqi.auction.utils;

import com.wuqi.auction.exception.NormalException;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class Asserts {

    private Asserts() {
    }

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new NormalException(message);
        }
    }
}
