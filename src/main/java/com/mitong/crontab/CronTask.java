package com.mitong.crontab;

import com.mitong.crontab.exception.ExpressionException;
import com.mitong.crontab.expression.CronExpression;
import com.mitong.crontab.handler.builder.CronExpressionBuilder;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Milton
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 可执行定时任务
 * @since 1.0
 */
public abstract class CronTask implements Runnable {
    private CronExpression cronExpression;

    private ScheduledExecutorService es;

    public CronTask(String cronExpression) throws ExpressionException {
        this.cronExpression = CronExpressionBuilder.build(cronExpression);
        es = Executors.newScheduledThreadPool(1);
        es.scheduleAtFixedRate(this, 0, 1, TimeUnit.SECONDS);
    }

    protected boolean isRuntime() {
        Set<Integer> minutes = this.cronExpression.getMinute().getRange();
        Set<Integer> hours = this.cronExpression.getHour().getRange();
        Set<Integer> days = this.cronExpression.getDay().getRange();
        Set<Integer> months = this.cronExpression.getMonth().getRange();
        Set<Integer> weeks = this.cronExpression.getWeek().getRange();
        DateTime now = new DateTime(new Date());
        if (minutes.contains(now.getMinuteOfHour()) && hours.contains(now.getHourOfDay())
                && (days.contains(now.getDayOfMonth())
                        || weeks.contains(now.getDayOfWeek() == 7 ? 0 : now.getDayOfWeek()))
                && months.contains(now.getMonthOfYear())) {
            return true;
        }
        return false;
    }

    public void shutdown() {
        if (es != null) {
            es.shutdown();
        }
    }
}
