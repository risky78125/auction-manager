package com.wuqi.auction.controller;

import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.service.CategoryService;
import com.wuqi.auction.utils.ResultWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/category")
    public ResultWrapper add(@RequestBody CategoryBody body) {
        this.categoryService.add(body);
        return ResultWrapper.success("分类增加成功");
    }

}
