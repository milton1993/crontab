package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;
import com.mitong.crontab.handler.parser.WeekExpressionParser;

import java.util.Set;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-27
 */
public class Week extends ExpressionPart {
    public static final int MIN_WEEK = 0;

    public static final int MAX_WEEK = 6;

    public Week(String weeks) throws ExpressionException {
        this.setRange(WeekExpressionParser.parse(weeks, MIN_WEEK, MAX_WEEK));
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
        return MIN_WEEK;
    }

    @Override
    public int getMax() {
        return MIN_WEEK;
    }
}
