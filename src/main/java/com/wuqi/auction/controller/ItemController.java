package com.wuqi.auction.controller;

import com.wuqi.auction.pojo.po.Item;
import com.wuqi.auction.service.ItemService;
import com.wuqi.auction.utils.ResultWrapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@RestController
public class ItemController {

    @Resource
    private ItemService itemService;

    @RequestMapping("/item/{id}")
    public ResultWrapper getOne(@PathVariable Integer id) {
        Item item = this.itemService.findOne(id);
        return ResultWrapper.success(item);
    }

}
