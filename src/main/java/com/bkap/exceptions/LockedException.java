package com.bkap.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:49
 * @created_by Tung lam
 * @since 22/07/2020
 */
@ResponseStatus(HttpStatus.LOCKED)
public class LockedException extends RuntimeException {
    public LockedException(String message) {
        super(message);
    }
}
