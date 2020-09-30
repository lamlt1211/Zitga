package com.bkap.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 30/07/2020 - 09:43
 * @created_by Tung lam
 * @since 30/07/2020
 */
public enum RoleStatus {
    ROLE_USER(2L), ROLE_ADMIN(1L);

    private static final Map<RoleStatus, Long> BY_VALUE = new HashMap<>();

    static {
        for (RoleStatus status : values()) {
            BY_VALUE.put(status, status.value);
        }
    }

    private final Long value;

    RoleStatus(Long value) {
        this.value = value;
    }


    public static Long valueOfStatus(RoleStatus status) {
        return BY_VALUE.get(status);
    }
}
