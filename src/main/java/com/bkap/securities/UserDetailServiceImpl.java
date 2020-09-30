package com.bkap.securities;

import com.bkap.dto.RoleDTO;
import com.bkap.dto.UserDTO;
import com.bkap.exceptions.LockedException;
import com.bkap.exceptions.NotFoundException;
import com.bkap.services.RoleService;
import com.bkap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:56
 * @created_by Tung lam
 * @since 22/07/2020
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        UserDTO users = userService.getUserByUserName(userName);
        if (users == null ) {
            throw new NotFoundException("Authenticate.locked.account");
        }
        if ( users.getStatus() == 0){
            throw new LockedException("User " + userName + " was looked");

        }
        List<GrantedAuthority> grantList = new ArrayList<>();
        List<RoleDTO> roleNames = this.roleService.findByUsersUserName(userName);
        if (roleNames != null) {
            for (RoleDTO role : roleNames) {
                grantList.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
        return new User(users.getUsername(), users.getPassword(), grantList);
    }
}
