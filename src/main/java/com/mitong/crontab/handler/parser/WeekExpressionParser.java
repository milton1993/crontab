package com.mitong.crontab.handler.parser;

import com.mitong.crontab.exception.ExpressionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-27
 */
public class WeekExpressionParser {
    private static final Map<String, Integer> weekToNumberMap = new HashMap<String, Integer>();

    static {
        weekToNumberMap.put("sun", 0);
        weekToNumberMap.put("mon", 1);
        weekToNumberMap.put("tue", 2);
        weekToNumberMap.put("wed", 3);
        weekToNumberMap.put("thur", 4);
        weekToNumberMap.put("fri", 5);
        weekToNumberMap.put("sat", 6);
    }

    public static Set<Integer> parse(String weeks, int minWeek, int maxWeek) throws ExpressionException {
        weeks = weeks.toLowerCase();
        Set<String> keySet = weekToNumberMap.keySet();
        for (String monthAbbr : keySet) {
            weeks = weeks.replaceAll(monthAbbr, String.valueOf(weekToNumberMap.get(monthAbbr)));
        }
        return NumberExpressionParser.parse(weeks, minWeek, maxWeek);
    }
}
