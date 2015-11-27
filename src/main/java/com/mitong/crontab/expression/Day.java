package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 日期
 * @since 1.0
 */
public class Day extends ExpressionPart {
    private static final int MIN_DAY = 1;

    private static final int MAX_DAY = 31;

    public Day(String days) throws ExpressionException {
        super(days);
    }

    @Override
    public int getMin() {
        return MIN_DAY;
    }

    @Override
    public int getMax() {
        return MAX_DAY;
    }
}
