package com.mitong.crontab.expression;

import com.mitong.crontab.common.NumberUtils;
import com.mitong.crontab.constant.CommonConstant;
import com.mitong.crontab.exception.ExpressionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-26
 * @description 分钟
 * @since 1.0
 */
public class Minute {
    /**
     * 需要执行任务的分钟点
     * */
    private List<Integer> minutes;

    private static final Logger LOGGER = LoggerFactory.getLogger(Minute.class);

    public Minute(String minutes) throws ExpressionException {
        this.minutes = this.parseMinutes(minutes);
    }

    public List<Integer> getMinutes() {
        return minutes;
    }

    public void setMinutes(List<Integer> minutes) {
        this.minutes = minutes;
    }

    private List<Integer> parseMinutes(String minutes) throws ExpressionException {
        List<Integer> result = new ArrayList<Integer>();
        if (Pattern.matches(CommonConstant.REGEXP_ANY, minutes)) {
            return NumberUtils.getRange(CommonConstant.MIN_MINUTE, CommonConstant.MAX_MINUTE);
        } else if (Pattern.matches(CommonConstant.REGEXP_ANY_WITH_STEP, minutes)) {
            return NumberUtils.getRange(CommonConstant.MIN_MINUTE, CommonConstant.MAX_MINUTE,
                    Integer.parseInt(minutes.split(CommonConstant.STEP_SEPARATOR)[1]));
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER, minutes)) {
            this.addOne(result, minutes);
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_ARRAY, minutes)) {
            String[] numbers = minutes.split(CommonConstant.ARRAY_SEPARATOR);
            for (String number : numbers) {
                this.addOne(result, number);
            }
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_RANGE, minutes)) {
            String[] numbers = minutes.split(CommonConstant.RANGE_SEPARATOR);
            if (NumberUtils.isInRange(Integer.parseInt(numbers[0]), CommonConstant.MIN_MINUTE,
                    CommonConstant.MAX_MINUTE)
                    && NumberUtils.isInRange(Integer.parseInt(numbers[1]), CommonConstant.MIN_MINUTE,
                            CommonConstant.MAX_MINUTE)) {
                return NumberUtils.getRange(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
            } else {
                LOGGER.error("Minute value is out of range 0-59!");
                throw new ExpressionException("Minute value is out of range 0-59!");
            }
        } else if (Pattern.matches(CommonConstant.REGEXP_NUMBER_RANGE_WITH_STEP, minutes)) {
            String[] parts = minutes.split(CommonConstant.STEP_SEPARATOR);
            String[] numbers = parts[0].split(CommonConstant.RANGE_SEPARATOR);
            if (NumberUtils.isInRange(Integer.parseInt(numbers[0]), CommonConstant.MIN_MINUTE,
                    CommonConstant.MAX_MINUTE)
                    && NumberUtils.isInRange(Integer.parseInt(numbers[1]), CommonConstant.MIN_MINUTE,
                    CommonConstant.MAX_MINUTE)) {
                return NumberUtils.getRange(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(parts[1]));
            } else {
                LOGGER.error("Minute value is out of range 0-59!");
                throw new ExpressionException("Minute value is out of range 0-59!");
            }
        } else {
            LOGGER.error("Format of given minute is wrong!");
            throw new ExpressionException("Format of given minute is wrong!");
        }
        return result;
    }

    private void addOne(List<Integer> result, String number) throws ExpressionException {
        int value = Integer.parseInt(number);
        if (NumberUtils.isInRange(value, CommonConstant.MIN_MINUTE, CommonConstant.MAX_MINUTE)) {
            result.add(value);
        } else {
            LOGGER.error("Minute value is out of range 0-59!");
            throw new ExpressionException("Minute value is out of range 0-59!");
        }
    }
}
