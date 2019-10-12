package com.wuqi.auction.money;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 创建人: 武奇
 * 创建事件: 2019/10/12
 */
public class Money {

    private long value;

    public Money() {
        this(0L);
    }

    public Money(Long val) {
        this.value = val == null ? 0 : val;
    }

    public Money add(Money other) {
        return new Money(this.value + other.value);
    }

    public Money add(long other) {
        return new Money(this.value + other);
    }

    public Money minus(Money other) {
        return new Money(this.value - other.value);
    }

    public Money minus(long other) {
        return new Money(this.value - other);
    }

    public  Money multiply(double multiplier) {
        BigDecimal n1 = new BigDecimal(this.value);
        BigDecimal n2 = new BigDecimal(multiplier);
        BigDecimal result = n1.multiply(n2);
        BigDecimal scale = result.setScale(0, BigDecimal.ROUND_HALF_UP);
        return new Money(scale.longValue());
    }

    public Money divide(double divisor) {
        BigDecimal n1 = new BigDecimal(this.value);
        BigDecimal n2 = new BigDecimal(divisor);
        BigDecimal result = n1.divide(n2, 0, RoundingMode.HALF_UP);
        return new Money(result.longValue());
    }

    public String format() {
        return format(FormatType.LOWSER_CASE);
    }

    public String format(FormatType type) {
        long value = Math.abs(this.value);
        long copper = value % 100;
        long silver = value / 100 % 100;
        long gold = value / 10000;
        String money = "%sg%ss%sc";
        switch (type) {
            case UPPER_CASE:
                money = "%sG%sS%sC";
                break;
            case CHINESE:
                money = "%s金%s银%s铜";
                break;
        }
        if (this.value < 0) {
            money = "-".concat(money);
        }
        return String.format(money, gold, silver, copper);
    }

    @Override
    public String toString() {
        return format();
    }

    public long value() {
        return this.value;
    }
}
