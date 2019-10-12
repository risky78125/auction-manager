package com.wuqi.auction.repository;

import com.wuqi.auction.pojo.po.Item;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public interface ItemRepository {
    Item findById(Integer id);
}
