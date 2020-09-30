package com.bkap.repositories;

import com.bkap.entity.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 07/09/2020 - 17:05
 * @created_by Tung lam
 * @since 07/09/2020
 */
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByToken(String verifyToken);

    void deleteByExpiryDateLessThan(Date now);
}
