package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 小时
 * @since 1.0
 */
public class Hour extends ExpressionPart {
    private static final int MIN_HOUR = 0;

    private static final int MAX_HOUR = 23;

    public Hour(String hours) throws ExpressionException {
        super(hours);
    }

    @Override
    public int getMin() {
        return MIN_HOUR;
    }

    @Override
    public int getMax() {
        return MAX_HOUR;
    }
}
