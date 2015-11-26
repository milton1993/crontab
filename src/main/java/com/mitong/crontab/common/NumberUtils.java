package com.mitong.crontab.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-26
 * @description 数字操作工具类
 * @since 1.0
 */
public class NumberUtils {
    private static final int DEFAULT_STEP = 1;

    public static List<Integer> getRange(int min, int max) {
        return getRange(min, max, DEFAULT_STEP);
    }

    public static List<Integer> getRange(int min, int max, int step) {
        List<Integer> rangeList = new ArrayList<Integer>();
        for (int i = min; i <= max; i += step) {
            rangeList.add(i);
        }
        return rangeList;
    }

    public static boolean isInRange(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
