package com.bkap.services;

import com.bkap.dto.RoleDTO;

import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 30/07/2020 - 11:27
 * @created_by Tung lam
 * @since 30/07/2020
 */
public interface RoleService {
    List<RoleDTO> findByUsersUserName(String userName);
}
