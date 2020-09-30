package com.bkap.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerificationTokenDTO {

    private Long id;
    private String token;
    private UserDTO user;
    private Date expiryDate;

}
