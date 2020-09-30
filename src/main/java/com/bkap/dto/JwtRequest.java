package com.bkap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 23/07/2020 - 11:36
 * @created_by Tung lam
 * @since 23/07/2020
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;
}
