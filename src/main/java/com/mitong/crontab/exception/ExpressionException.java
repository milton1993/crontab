package com.mitong.crontab.exception;

/**
 * @author mitong
 * @email mitong@aliyun.com
 * @date 15-11-26
 * @description 表达式格式错误
 * @since 1.0
 */
public class ExpressionException extends Exception {
    public ExpressionException() {
        super();
    }

    public ExpressionException(String message) {
        super(message);
    }

    public ExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpressionException(Throwable cause) {
        super(cause);
    }
}