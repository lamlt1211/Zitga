package com.bkap.services.impl;

import com.bkap.dto.RoleDTO;
import com.bkap.entity.Role;
import com.bkap.repositories.RoleRepository;
import com.bkap.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * JavaIV
 *
 * @author Huupd
 * @created_at 13/07/2020 - 4:57 PM
 * @created_by Huupd
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<RoleDTO> findByUsersUserName(String userName) {
        List<RoleDTO> roleResponses = new ArrayList<>();
        List<Role> roleList = roleRepository.findAllByUsersUsername(userName);
        for (Role role : roleList) {
            RoleDTO roleResponse = modelMapper.map(role, RoleDTO.class);
            roleResponses.add(roleResponse);
        }
        return roleResponses;
    }
}
