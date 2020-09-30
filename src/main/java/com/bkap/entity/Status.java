package com.bkap.entity;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 30/07/2020 - 09:42
 * @created_by Tung lam
 * @since 30/07/2020
 */
public enum Status {
    ACTIVE(1), INACTIVE(0);

    private final int value;

    Status(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
