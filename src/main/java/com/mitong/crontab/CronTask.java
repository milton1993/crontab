package com.mitong.crontab;

/**
 * @author Milton
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 可执行定时任务
 * @since 1.0
 */
public abstract class CronTask implements Runnable {
    private String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
