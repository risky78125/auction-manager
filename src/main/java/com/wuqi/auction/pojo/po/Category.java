package com.wuqi.auction.pojo.po;

import lombok.Data;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class Category {

    private Integer id;
    private String name;
    private Integer parentId;

    public Integer getParentId() {
        return this.parentId == null ? 0 : this.parentId;
    }
}
