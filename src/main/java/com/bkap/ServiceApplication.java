package com.bkap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 15:50
 * @created_by Tung lam
 * @since 22/07/2020
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ServiceApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}
