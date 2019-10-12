package com.wuqi.auction.service.impl;

import com.wuqi.auction.exception.NormalException;
import com.wuqi.auction.pojo.dto.CategoryBody;
import com.wuqi.auction.pojo.po.Category;
import com.wuqi.auction.pojo.vo.CategoryNode;
import com.wuqi.auction.repository.CategoryRepository;
import com.wuqi.auction.service.CategoryService;
import com.wuqi.auction.utils.Asserts;
import com.wuqi.auction.utils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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

    @Override
    public void update(Category category) {
        this.categoryRepository.updateById(category);
    }

    @Transactional
    @Override
    public void batchUpdate(List<Category> categories) {
        if (!CollectionUtils.isEmpty(categories)) {
            for (Category category : categories) {
                this.categoryRepository.updateById(category);
            }
        } else {
            throw new NormalException("请正确的传递数据");
        }
    }
}
