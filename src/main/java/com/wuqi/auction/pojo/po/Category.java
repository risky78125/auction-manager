package com.wuqi.auction.pojo.po;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotBlank;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class Category {

    private Integer id;
    @NotBlank(message = "分类名称不能为空")
    private String name;
    private Integer parentId;

    public boolean isValid() {
        return StringUtils.hasText(name);
    }

    public Integer getParentId() {
        return parentId == null || parentId <= 0 ? null : this.parentId;
    }

}
