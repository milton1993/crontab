package com.mitong.crontab.constant;

import java.util.regex.Pattern;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-26
 * @description 常量
 * @since 1.0
 */
public class CommonConstant {
    public static final String REGEXP_ANY = "^\\*$|^\\*/1$";

    public static final String REGEXP_ANY_WITH_STEP = "^\\*/\\d{1,2}$";

    public static final String REGEXP_NUMBER = "^\\d{1,2}$";

    public static final String REGEXP_NUMBER_RANGE = "^\\d{1,2}-\\d{1,2}$";

    public static final String REGEXP_NUMBER_RANGE_WITH_STEP = "^\\d{1,2}-\\d{1,2}/\\d{1,2}$";

    public static final String REGEXP_NUMBER_ARRAY = "^(\\d{1,2},)+\\d{1,2}$";

    public static final int MIN_MINUTE = 0;

    public static final int MAX_MINUTE = 59;

    public static final int MIN_HOUR = 0;

    public static final int MAX_HOUR = 23;

    public static final int MIN_DAY = 1;

    public static final int MAX_DAY = 31;

    public static final int MIN_MONTH = 1;

    public static final int MAX_MONTH = 12;

    public static final int MIX_WEEK = 0;

    public static final int MAX_WEEK = 6;

    public static final String CRON_EXPRESSION_SEPARATOR = " ";

    public static final String ARRAY_SEPARATOR = ",";

    public static final String RANGE_SEPARATOR = "-";

    public static final String STEP_SEPARATOR = "/";

    public static void main(String[] args) {
        System.out.println(Pattern.matches(REGEXP_NUMBER_ARRAY, "12,1,2,2,22"));
    }
}
