package com.bkap.services.impl;

import com.bkap.dto.PasswordDTO;
import com.bkap.dto.UserDTO;
import com.bkap.dto.VerificationTokenDTO;
import com.bkap.entity.PasswordResetToken;
import com.bkap.entity.Role;
import com.bkap.entity.RoleStatus;
import com.bkap.entity.Status;
import com.bkap.entity.Users;
import com.bkap.entity.VerificationToken;
import com.bkap.exceptions.DuplicateException;
import com.bkap.exceptions.NotFoundException;
import com.bkap.repositories.PasswordResetTokenRepository;
import com.bkap.repositories.UserRepository;
import com.bkap.repositories.VerificationTokenRepository;
import com.bkap.securities.WebUtils;
import com.bkap.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:57
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    private static final String ROLE_USER = "ROLE_USER";


    @Override
    public UserDTO getUserByUserName(String name) {
        Users users = userRepository.findByUsername(name);
        if (users.equals(null)) {
            throw new NotFoundException("User.NotFound.Name");
        }
        return modelMapper.map(users, UserDTO.class);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<Users> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("Empty.user");
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(u -> {
            UserDTO userDTO = modelMapper.map(u, UserDTO.class);
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    public UserDTO getUserByMail(String email) {
        Users user = userRepository.findByEmail(email);
        if (user != null)
            return modelMapper.map(user, UserDTO.class);
        return null;
    }

    @Override
    public List<UserDTO> getAllUsersEnable() {
        List<Users> users = userRepository.findAllUserEnable();
        if (users.isEmpty()) {
            throw new NotFoundException("Empty.user");
        }
        List<UserDTO> userDTOS = new ArrayList<>();
        users.forEach(u -> {
            UserDTO userDTO = modelMapper.map(u, UserDTO.class);
            userDTOS.add(userDTO);
        });
        return userDTOS;
    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (optionalUsers.isPresent()) {
            log.info("findById user success");
            return modelMapper.map(optionalUsers.get(), UserDTO.class);
        }
        throw new NotFoundException("User.Id.NotFound");

    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.findByUsername(userDTO.getUsername()) != null || userRepository.findByUsername(userDTO.getEmail()) != null) {
            throw new DuplicateException("Exist.user");
        }
        List<Role> roleList = new ArrayList<>();
        Users users = modelMapper.map(userDTO, Users.class);
        users.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        users.setStatus(Status.ACTIVE.getValue());
        Role role = new Role();
        role.setId(RoleStatus.valueOfStatus(RoleStatus.ROLE_USER));
        roleList.add(role);
        users.setRoles(roleList);
        Users users1 = userRepository.save(users);
        return modelMapper.map(users1, UserDTO.class);
    }

    public UserDTO updateUserById(UserDTO userDTO) {
        Optional<Users> response = userRepository.findById(userDTO.getId());
        if (response.isPresent()) {
            Users user = response.get();
            user.setFullName(userDTO.getFullName());
            user.setEmail(userDTO.getEmail());
            user.setAddress(userDTO.getAddress());
            user.setPhone(userDTO.getPhone());
            user.setUpdatedAt(new Date());
            return modelMapper.map(userRepository.save(user), UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public UserDTO disableUser(Long id) {
        Optional<Users> optionalUsers = userRepository.findById(id);
        if (optionalUsers.isPresent()) {
            optionalUsers.get().setStatus(Status.INACTIVE.getValue());
            log.info("disable user success");
            return null;
        }
        throw new NotFoundException("User.Id.NotFound");

    }

    // get tất cả user theo page
    @Override
    public Page<UserDTO> getUserByPage(String searchValue, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Users> pageResult = userRepository.findBySearchValueAndRoles_Name(searchValue, ROLE_USER, pageable);
        return null;
    }


    public void changePassword(PasswordDTO passwordDTO) {
        UserDetails userDetails = WebUtils.getUserDetail();
        Users result = userRepository.findByUsername(userDetails.getUsername());

        if (result != null && bCryptPasswordEncoder.matches(passwordDTO.getCurrentPassword(), result.getPassword())) {
            result.setPassword(bCryptPasswordEncoder.encode(passwordDTO.getNewPassword()));
            userRepository.save(result);
        } else {
            throw new NotFoundException("User.Id.NotFound");
        }
    }

    public String createVerificationToken(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        String token = UUID.randomUUID().toString();
        VerificationToken myToken = new VerificationToken(token, user);
        return verificationTokenRepository.save(myToken).getToken();
    }

    public VerificationTokenDTO getVerificationToken(String verifyToken) {
        VerificationToken token = verificationTokenRepository.findByToken(verifyToken);
        return getCommonToken(
                token.getId(),
                token.getToken(),
                token.getUser(),
                token.getExpiryDate());
    }

    private VerificationTokenDTO getCommonToken(Long id, String verifyToken, Users user, Date expiryDate) {
        return new VerificationTokenDTO(
                id,
                verifyToken,
                modelMapper.map(user, UserDTO.class),
                expiryDate);
    }

    public String createPasswordResetToken(UserDTO userDTO) {
        Users user = modelMapper.map(userDTO, Users.class);
        String token = UUID.randomUUID().toString();
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        return passwordResetTokenRepository.save(myToken).getToken();
    }

    public VerificationTokenDTO getPasswordResetToken(String verifyToken) {
        PasswordResetToken token = passwordResetTokenRepository.findByToken(verifyToken);
        return getCommonToken(
                token.getId(),
                token.getToken(),
                token.getUser(),
                token.getExpiryDate());
    }

    public UserDTO activeUser(UserDTO userDTO) {
        Users user = null;
        Users responseUser;
        Optional<Users> response = userRepository.findById(userDTO.getId());
        if (response.isPresent()) {
            user = response.get();
            user.setEnabled(true);
            responseUser = userRepository.save(user);
            return modelMapper.map(responseUser, UserDTO.class);
        } else {
            return new UserDTO();
        }
    }

    public UserDTO updateUserBlockedStatus(Long id, Integer status) {
        Users user = null;
        Users userResponse = null;
        Optional<Users> result = userRepository.findById(id);
        if (result.isPresent()) {
            user = result.get();
            user.setStatus(status);
            userResponse = userRepository.save(user);
        }
        if (userResponse != null) {
            return modelMapper.map(userResponse, UserDTO.class);
        }
        return new UserDTO();
    }

    @Override
    public Long countUser() {
        return userRepository.count();
    }


}
