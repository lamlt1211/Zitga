package com.bkap.services;

import com.bkap.dto.ProjectDTO;

import java.util.List;
import java.util.Map;

/**
 * Project-SemIV
 *
 * @author Tung lam
 * @created_at 22/07/2020 - 17:59
 * @created_by Tung lam
 * @since 22/07/2020
 */
public interface ProjectService {
    Map<Integer, List<Object>> getAllProject();

    List<ProjectDTO> findAllProject();

    ProjectDTO findById(Long id);

    ProjectDTO create(ProjectDTO projectDTO);

    void deleteProject(Long id);
}
