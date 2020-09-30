package com.bkap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 28/08/2020 - 09:27
 * @created_by Tung lam
 * @since 28/08/2020
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PasswordDTO {
    private String currentPassword;
    private String newPassword;
}
