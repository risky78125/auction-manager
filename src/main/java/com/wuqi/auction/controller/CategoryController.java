package com.wuqi.auction.controller;

import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.pojo.vo.CategoryNode;
import com.wuqi.auction.service.CategoryService;
import com.wuqi.auction.utils.PageItem;
import com.wuqi.auction.utils.ResultWrapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@RestController
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResultWrapper add(@RequestBody CategoryBody body) {
        this.categoryService.add(body);
        return ResultWrapper.success("分类增加成功");
    }

    @RequestMapping("/category/list/plain")
    public ResultWrapper plainList() {
        List<Category> categories = this.categoryService.listWithPlain();
        return ResultWrapper.success(categories);
    }

    @RequestMapping("/category/list/tree")
    public ResultWrapper treeList() {
        List<CategoryNode> tree = this.categoryService.listWithTree();
        return ResultWrapper.success(tree);
    }

}
