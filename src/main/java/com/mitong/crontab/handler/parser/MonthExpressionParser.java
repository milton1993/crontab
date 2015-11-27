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
public class MonthExpressionParser {
    private static final Map<String, Integer> monthToNumberMap = new HashMap<String, Integer>();

    static {
        monthToNumberMap.put("jan", 1);
        monthToNumberMap.put("feb", 2);
        monthToNumberMap.put("mar", 3);
        monthToNumberMap.put("apr", 4);
        monthToNumberMap.put("may", 5);
        monthToNumberMap.put("jun", 6);
        monthToNumberMap.put("jul", 7);
        monthToNumberMap.put("aug", 8);
        monthToNumberMap.put("sept", 9);
        monthToNumberMap.put("oct", 10);
        monthToNumberMap.put("nov", 11);
        monthToNumberMap.put("dec", 12);
    }

    public static Set<Integer> parse(String months, int minMonth, int maxMonth) throws ExpressionException {
        months = months.toLowerCase();
        Set<String> keySet = monthToNumberMap.keySet();
        for (String monthAbbr : keySet) {
            months = months.replaceAll(monthAbbr, String.valueOf(monthToNumberMap.get(monthAbbr)));
        }
        return NumberExpressionParser.parse(months, minMonth, maxMonth);
    }
}
