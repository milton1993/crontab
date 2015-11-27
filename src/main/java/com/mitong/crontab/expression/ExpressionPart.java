package com.mitong.crontab.expression;

import com.mitong.crontab.exception.ExpressionException;
import com.mitong.crontab.handler.parser.NumberExpressionParser;

import java.util.Set;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-27
 * @description 对表达式的一个部分的封装
 * @since 1.0
 */
public class ExpressionPart {
    protected Set<Integer> range;

    public ExpressionPart(String range) throws ExpressionException {
        this.range = NumberExpressionParser.parse(range, this.getMin(), this.getMax());
    }

    protected ExpressionPart() {
    }

    public Set<Integer> getRange() {
        return range;
    }

    public void setRange(Set<Integer> range) {
        this.range = range;
    }

    public int getMin() {
        return 0;
    }

    public int getMax() {
        return Integer.MAX_VALUE;
    }
}
