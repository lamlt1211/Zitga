package com.bkap.repositories;

import com.bkap.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 07/09/2020 - 17:02
 * @created_by Tung lam
 * @since 07/09/2020
 */
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
    VerificationToken findByToken(String verifyToken);

    void deleteByExpiryDateLessThan(Date now);
}
