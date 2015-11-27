package com.mitong.crontab;

import com.mitong.crontab.exception.ExpressionException;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-27
 */
public class CronTest {
    public static void main(String[] args) throws ExpressionException {
        CronTask task = new CronTask("* * * * *") {
            @Override
            public void run() {
                if (this.isRuntime()) {
                    System.out.println(1);
                }
            }
        };
    }
}
