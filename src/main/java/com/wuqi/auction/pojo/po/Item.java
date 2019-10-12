package com.wuqi.auction.pojo.po;

import com.wuqi.auction.money.Money;
import lombok.Data;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class Item {

    private Integer id;
    private String name;
    private Money price;

}
