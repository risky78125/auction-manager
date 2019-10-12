package com.wuqi.auction.money;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class MoneyTest {

    @Test
    public void format() {

        Money money = new Money(123456);
        System.out.println("money = " + money);
        Money add = money.add(23020);
        System.out.println("add = " + add);
        Money minus = money.minus(129090);
        System.out.println("minus = " + minus);
        Money multiply = money.multiply(1.9);
        System.out.println("multiply = " + multiply);
        Money divide = money.divide(3.17);
        System.out.println("divide = " + divide);

    }
}