package com.bkap.api;

import com.bkap.dto.APIResponse;
import com.bkap.dto.ProjectDTO;
import com.bkap.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/project")
public class ProjectApi {
    private ProjectService projectService;

    @Autowired
    public ProjectApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PutMapping("/create")
    public ResponseEntity<APIResponse<ProjectDTO>> cresteNews(@RequestBody ProjectDTO projectDTO) {
        ProjectDTO projectDTO1 = projectService.create(projectDTO);
        APIResponse<ProjectDTO> response = new APIResponse<>();
        response.setData(projectDTO1);
        response.setStatus(HttpStatus.OK.value());
        response.setMessage("Message.statusAPI.ok");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable("id") Long id, Locale locale) {
        projectService.deleteProject(id);
    }
}
