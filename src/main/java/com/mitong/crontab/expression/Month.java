package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;
import com.mitong.crontab.handler.parser.MonthExpressionParser;

import java.util.Set;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-27
 * @description 
 */
public class Month extends ExpressionPart {
    private static final int MIN_MONTH = 1;

    private static final int MAX_MONTH = 12;

    public Month(String months) throws ExpressionException {
        this.setRange(MonthExpressionParser.parse(months, MIN_MONTH, MAX_MONTH));
    }

    @Override
    public Set<Integer> getRange() {
        return this.range;
    }

    @Override
    public void setRange(Set<Integer> range) {
        super.setRange(range);
    }

    @Override
    public int getMin() {
        return MIN_MONTH;
    }

    @Override
    public int getMax() {
        return MAX_MONTH;
    }
}
