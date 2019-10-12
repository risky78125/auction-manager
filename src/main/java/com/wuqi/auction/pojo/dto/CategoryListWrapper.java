package com.wuqi.auction.pojo.dto;

import com.wuqi.auction.pojo.po.Category;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class CategoryListWrapper {

    @Valid
    @NotEmpty(message = "需要传递更新的数据")
    private List<Category> categories;

}
