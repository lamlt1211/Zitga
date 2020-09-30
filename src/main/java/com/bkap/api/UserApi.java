package com.bkap.api;

import com.bkap.dto.PasswordDTO;
import com.bkap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 14:54
 * @created_by Tung lam
 * @since 22/07/2020
 */
@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;


    @PostMapping("/changePassword")
    public void updateNewPassword(@RequestBody PasswordDTO passwordDTO) {
        userService.changePassword(passwordDTO);
    }
}
