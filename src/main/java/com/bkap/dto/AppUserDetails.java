package com.bkap.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 28/07/2020 - 10:54
 * @created_by Tung lam
 * @since 28/07/2020
 */
public class AppUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private String fullname;
    @JsonIgnore
    private String password;
    private String jwtToken;
    private List<GrantedAuthority> authorities;

    public AppUserDetails(String username, String password, String fullname, String jwtToken, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.jwtToken = jwtToken;
        this.authorities = authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
