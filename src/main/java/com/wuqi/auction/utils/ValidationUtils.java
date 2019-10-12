package com.wuqi.auction.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class ValidationUtils {

    public static Collection<FieldValidatedInfo> convert(BindingResult br) {
        Map<String, FieldValidatedInfo> map = new HashMap<>();
        for (FieldError error : br.getFieldErrors()) {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            FieldValidatedInfo info = map.get(fieldName);
            if (info == null) {
                info = new FieldValidatedInfo();
                info.setFieldName(fieldName);
                info.setMessage(new ArrayList<>());
                map.put(fieldName, info);
            }
            info.getMessage().add(message);
        }
        return map.values();
    }

}
