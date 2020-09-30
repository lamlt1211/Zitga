package com.bkap.task;

import com.bkap.repositories.PasswordResetTokenRepository;
import com.bkap.repositories.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 07/09/2020 - 17:16
 * @created_by Tung lam
 * @since 07/09/2020
 */
@Service
@Transactional
public class RemoveExpiryDateTokenTask {
    @Autowired
    private VerificationTokenRepository verifycationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Scheduled(cron = "0 0 11 * * ?")
    public void removeExpiryDateToken() {
        Date now = Date.from(Instant.now());
        verifycationTokenRepository.deleteByExpiryDateLessThan(now);
        passwordResetTokenRepository.deleteByExpiryDateLessThan(now);
    }
}
