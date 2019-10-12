package com.wuqi.auction.service;

import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.pojo.vo.CategoryNode;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public interface CategoryService {

    void add(CategoryBody category);

    List<Category> listWithPlain();

    List<CategoryNode> listWithTree();

}
