package com.wuqi.auction.pojo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
@Data
public class CategoryBody {

    @NotBlank(message = "分类名称不能为空")
    @Length(min = 1, max = 10)
    private String name;
    private Integer parentId;

}
