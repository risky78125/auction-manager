package com.wuqi.auction.service.impl;

import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.repository.CategoryRepository;
import com.wuqi.auction.service.CategoryService;
import com.wuqi.auction.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    @Override
    public void add(CategoryBody category) {
        Category copy = BeanUtils.copy(category, Category.class);
        this.categoryRepository.insert(copy);
    }
}
