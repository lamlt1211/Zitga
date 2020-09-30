package com.bkap.api;

import com.bkap.dto.APIResponse;
import com.bkap.dto.RoleDTO;
import com.bkap.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 31/07/2020 - 16:23
 * @created_by Tung lam
 * @since 31/07/2020
 */
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/username/{username}")
    public ResponseEntity<APIResponse<List<RoleDTO>>> findUserByUserName(@PathVariable("username") String username, Locale locale) {
        List<RoleDTO> roleDTOS = roleService.findByUsersUserName(username);
        APIResponse<List<RoleDTO>> response = new APIResponse<>();
        response.setMessage(messageSource.getMessage("Message.statusAPI.ok", null, locale));
        response.setStatus(HttpStatus.OK.value());
        response.setData(roleDTOS);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
