package com.wuqi.auction.service.impl;

import com.wuqi.auction.pojo.po.Item;
import com.wuqi.auction.repository.ItemRepository;
import com.wuqi.auction.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemRepository itemRepository;

    @Override
    public Item findOne(Integer id) {
        return this.itemRepository.findById(id);
    }
}
