package com.mitong.crontab.common;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 数字操作工具类
 * @since 1.0
 */
public class NumberUtils {
    private static final int DEFAULT_STEP = 1;

    /**
     * 得到min到max区间取步长为1的所有整数，min可以大于max
     * @param min
     * @param max
     * @return
     * */
    public static Set<Integer> getRange(int min, int max) {
        return getRange(min, max, DEFAULT_STEP);
    }

    /**
     * 得到min到max区间取步长为step的所有整数，min可以大于max
     * @param min
     * @param max
     * @param step
     * @return
     * */
    public static Set<Integer> getRange(int min, int max, int step) {
        Set<Integer> rangeList = new HashSet<Integer>();
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        for (int i = min; i <= max; i += step) {
            rangeList.add(i);
        }
        return rangeList;
    }

    /**
     * 判断value是否在min和max之间，min可以大于max
     * @param value
     * @param min
     * @param max
     * @return
     * */
    public static boolean isInRange(int value, int min, int max) {
        return (min < max) ? (value >= min && value <= max) : (value >= max && value <= min);
    }
}
