package com.bkap.services.impl;

import com.bkap.dto.ProjectDTO;
import com.bkap.entity.Project;
import com.bkap.repositories.ProjectRepository;
import com.bkap.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Map<Integer, List<Object>> getAllProject() {
        List<Project> projects = projectRepository.findAll();
        Map<Integer, List<Object>> map = new LinkedHashMap<>();
        for (Project project : projects) {
            this.put(map, project.getPublish().getYear() + 1900, modelMapper.map(project, ProjectDTO.class));
        }

        map.forEach((s, strings) -> {
            strings.forEach(System.out::print);
        });
        return map;
    }

    @Override
    public List<ProjectDTO> findAllProject() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for (Project project : projects) {
            projectDTOS.add(modelMapper.map(project, ProjectDTO.class));
        }
        return projectDTOS;
    }

    @Override
    public ProjectDTO findById(Long id) {
        Project project = projectRepository.findById(id).get();
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO create(ProjectDTO projectDTO) {
        Project project = modelMapper.map(projectDTO, Project.class);
        return modelMapper.map(projectRepository.save(project), ProjectDTO.class);
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent())
            projectRepository.delete(project.get());
    }

    private static <KEY, VALUE> void put(Map<KEY, List<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? new ArrayList<>() : strings).add(value);
    }
}
