package com.mitong.crontab.handler.builder;

import com.mitong.crontab.constant.CommonConstant;
import com.mitong.crontab.exception.ExpressionException;
import com.mitong.crontab.expression.*;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-27
 * @description 把string表达式转换成CronExpression对象
 * @since 1.0
 */
public class CronExpressionBuilder {
    public static CronExpression build(String cronExpression) throws ExpressionException {
        String[] parts = cronExpression.split(CommonConstant.CRON_EXPRESSION_SEPARATOR);
        if (parts.length != 5) {
            throw new ExpressionException("Expression must be five parts separated by whitespace!");
        }
        CronExpression cronExpressionObj = new CronExpression();
        cronExpressionObj.setMinute(new Minute(parts[0]));
        cronExpressionObj.setHour(new Hour(parts[1]));
        cronExpressionObj.setDay(new Day(parts[2]));
        cronExpressionObj.setMonth(new Month(parts[3]));
        cronExpressionObj.setWeek(new Week(parts[4]));
        return cronExpressionObj;
    }
}
