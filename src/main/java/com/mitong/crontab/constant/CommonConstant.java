package com.mitong.crontab.constant;

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

    public static final String CRON_EXPRESSION_SEPARATOR = " ";

    public static final String ARRAY_SEPARATOR = ",";

    public static final String RANGE_SEPARATOR = "-";

    public static final String STEP_SEPARATOR = "/";
}
