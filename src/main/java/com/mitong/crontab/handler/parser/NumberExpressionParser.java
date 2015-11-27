package com.mitong.crontab.handler.parser;

import com.mitong.crontab.common.NumberUtils;
import com.mitong.crontab.constant.CommonConstant;
import com.mitong.crontab.exception.ExpressionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-27
 * @description 转换数字表达式
 * @since 1.0
 */
public class NumberExpressionParser {
    private static final Logger LOGGER = LoggerFactory.getLogger(NumberExpressionParser.class);

    public static Set<Integer> parse(String expression, int minValue, int maxValue) throws ExpressionException {
        Set<Integer> result = new HashSet<Integer>();
        if (Pattern.matches(CommonConstant.REGEXP_ANY, expression)) {
            return NumberUtils.getRange(minValue, maxValue);
        } else if (Pattern.matches(CommonConstant.REGEXP_ANY_WITH_STEP, expression)) {
            return NumberUtils.getRange(minValue, maxValue,
                    Integer.parseInt(expression.split(CommonConstant.STEP_SEPARATOR)[1]));
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER, expression)) {
            addOne(result, expression, minValue, maxValue);
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_ARRAY, expression)) {
            String[] numbers = expression.split(CommonConstant.ARRAY_SEPARATOR);
            for (String number : numbers) {
                addOne(result, number, minValue, maxValue);
            }
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_RANGE, expression)) {
            String[] numbers = expression.split(CommonConstant.RANGE_SEPARATOR);
            if (NumberUtils.isInRange(Integer.parseInt(numbers[0]), minValue, maxValue)
                    && NumberUtils.isInRange(Integer.parseInt(numbers[1]), minValue, maxValue)) {
                return NumberUtils.getRange(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            } else {
                LOGGER.error("Value is out of range {}-{}!", minValue, maxValue);
                throw new ExpressionException("Value is out of range " + minValue + "-" + maxValue + "!");
            }
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_RANGE_WITH_STEP, expression)) {
            String[] parts = expression.split(CommonConstant.STEP_SEPARATOR);
            String[] numbers = parts[0].split(CommonConstant.RANGE_SEPARATOR);
            if (NumberUtils.isInRange(Integer.parseInt(numbers[0]), minValue, maxValue)
                    && NumberUtils.isInRange(Integer.parseInt(numbers[1]), minValue, maxValue)) {
                return NumberUtils.getRange(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]),
                        Integer.parseInt(parts[1]));
            } else {
                LOGGER.error("Value is out of range {}-{}!", minValue, maxValue);
                throw new ExpressionException("Value is out of range " + minValue + "-" + maxValue + "!");
            }
        } else {
            LOGGER.error("Format of given value is wrong!");
            throw new ExpressionException("Format of given value is wrong!");
        }
        return result;
    }

    private static void addOne(Set<Integer> result, String number, int minValue, int maxValue) throws ExpressionException {
        int value = Integer.parseInt(number);
        if (NumberUtils.isInRange(value, minValue, maxValue)) {
            result.add(value);
        } else {
            LOGGER.error("Value is out of range {}-{}!", minValue, maxValue);
            throw new ExpressionException("Value is out of range " + minValue + "-" + maxValue + "!");
        }
    }
}
