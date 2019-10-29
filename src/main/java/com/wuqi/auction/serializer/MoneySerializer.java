package com.wuqi.auction.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.wuqi.auction.money.Money;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
//@JsonComponent
public class MoneySerializer extends StdSerializer<Money> {

    public MoneySerializer() {
        super(Money.class);
    }

    @Override
    public void serialize(Money value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeString(new ObjectMapper().writeValueAsString(value));
//        gen.writeString(value.toString());
    }
}
