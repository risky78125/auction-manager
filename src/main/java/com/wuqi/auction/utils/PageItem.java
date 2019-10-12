package com.wuqi.auction.utils;

import java.util.List;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class PageItem {

    private Integer total;
    private List<?> items;

    private PageItem() {
    }

    private PageItem(Integer total, List<?> items) {
        this.total = total;
        this.items = items;
    }

    public static PageItem of(List<?> items) {
        return of(-1, items);
    }

    public static PageItem of(Integer total, List<?> items) {
        return new PageItem(total, items);
    }

    public Integer getTotal() {
        return total;
    }

    public List<?> getItems() {
        return items;
    }
}
