package com.bkap.services;

import com.bkap.dto.PasswordDTO;
import com.bkap.dto.UserDTO;
import com.bkap.dto.VerificationTokenDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:59
 * @created_by Tung lam
 * @since 22/07/2020
 */
public interface UserService {

    UserDTO getUserByUserName(String name);

    List<UserDTO> getAllUsers();

    List<UserDTO> getAllUsersEnable();

    UserDTO getUserByMail(String email);

    UserDTO getUserById(Long id);

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUserById(UserDTO userDTO);

    UserDTO disableUser(Long id);

    void changePassword(PasswordDTO passwordDTO);

    Page<UserDTO> getUserByPage(String searchValue, Integer pageNo, Integer pageSize, String sortBy);

    String createVerificationToken(UserDTO userDTO);

    VerificationTokenDTO getVerificationToken(String verifyToken);

    String createPasswordResetToken(UserDTO userDTO);

    VerificationTokenDTO getPasswordResetToken(String verifyToken);

    UserDTO activeUser(UserDTO userDTO);

    UserDTO updateUserBlockedStatus(Long id, Integer status);

    Long countUser();
}
