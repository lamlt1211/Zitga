package com.bkap.exception;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 27/08/2020 - 14:54
 * @created_by Tung lam
 * @since 27/08/2020
 */
public class RestTemplateException extends RuntimeException {
    private static final long serialVersionUID = -3242126885270683621L;

    public RestTemplateException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RestTemplateException(String message) {
        super(message);
    }

    public RestTemplateException(String message, Throwable cause) {
        super(message, cause);
    }
}
