package com.wuqi.auction.service.impl;

import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.pojo.vo.CategoryNode;
import com.wuqi.auction.repository.CategoryRepository;
import com.wuqi.auction.service.CategoryService;
import com.wuqi.auction.utils.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Category> listWithPlain() {
        return this.categoryRepository.plainList();
    }

    @Override
    public List<CategoryNode> listWithTree() {
        return this.categoryRepository.treeList();
    }

    @Override
    public void deleteInIds(List<Integer> ids) {
        this.categoryRepository.deleteInIds(ids);
    }
}
