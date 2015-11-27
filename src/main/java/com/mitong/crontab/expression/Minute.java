package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 分钟
 * @since 1.0
 */
public class Minute extends ExpressionPart {
    private static final int MIN_MINUTE = 0;

    private static final int MAX_MINUTE = 59;

    public Minute(String minutes) throws ExpressionException {
        super(minutes);
    }

    @Override
    public int getMin() {
        return MIN_MINUTE;
    }

    @Override
    public int getMax() {
        return MAX_MINUTE;
    }
}
