package com.wuqi.auction.repository;

import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.pojo.vo.CategoryNode;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public interface CategoryRepository {
    void insert(Category category);

    List<Category> plainList();

    List<CategoryNode> treeList();

    int deleteInIds(List<Integer> ids);

    int updateById(Category category);
}
