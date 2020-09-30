package com.bkap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 23/07/2020 - 11:35
 * @created_by Tung lam
 * @since 23/07/2020
 */
@NoArgsConstructor
@Getter
@Setter
public class APIResponse<T> {
    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("data")
    private T data;

    private PageMetaData pageMetaData;

    public APIResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
