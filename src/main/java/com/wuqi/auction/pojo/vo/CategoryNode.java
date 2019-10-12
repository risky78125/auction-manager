package com.wuqi.auction.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class CategoryNode {

    private Integer id;
    private String name;
    private Integer parentId;
    private List<CategoryNode> children;

}
