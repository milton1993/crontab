package com.mitong.crontab.expression;

import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-26
 * @description 小时
 * @since 1.0
 */
public class Hour {
    /**
     * 须执行定时任务的小时
     * */
    private List<Integer> hours;

    public Hour(String hours) {
        this.hours = this.parseHours(hours);
    }

    private List<Integer> parseHours(String hours) {
        return null;
    }

    public List<Integer> getHours() {
        return hours;
    }

    public void setHours(List<Integer> hours) {
        this.hours = hours;
    }
}
