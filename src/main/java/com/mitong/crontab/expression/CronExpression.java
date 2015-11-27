package com.mitong.crontab.expression;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description crontab表达式
 * @since 1.0
 */
public class CronExpression {
    private ExpressionPart minute;
    private ExpressionPart hour;
    private ExpressionPart day;
    private ExpressionPart month;
    private ExpressionPart week;

    public ExpressionPart getMinute() {
        return minute;
    }

    public void setMinute(ExpressionPart minute) {
        this.minute = minute;
    }

    public ExpressionPart getHour() {
        return hour;
    }

    public void setHour(ExpressionPart hour) {
        this.hour = hour;
    }

    public ExpressionPart getDay() {
        return day;
    }

    public void setDay(ExpressionPart day) {
        this.day = day;
    }

    public ExpressionPart getMonth() {
        return month;
    }

    public void setMonth(ExpressionPart month) {
        this.month = month;
    }

    public ExpressionPart getWeek() {
        return week;
    }

    public void setWeek(ExpressionPart week) {
        this.week = week;
    }
}
