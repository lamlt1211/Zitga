package com.bkap.repositories;

import com.bkap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:51
 * @created_by Tung lam
 * @since 22/07/2020
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findAllByUsersUsername(String userName);
}
