package com.wuqi.auction.utils;

import lombok.Data;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class FieldValidatedInfo {

    private String fieldName;
    private List<String> message;

}
