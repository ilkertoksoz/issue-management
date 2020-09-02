package com.ilkert.issuemanagement.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.dto.ProjectDto;
import com.ilkert.issuemanagement.entity.Project;

import java.util.List;

import javax.validation.Valid;

public interface ProjectService  {

    ProjectDto Save(ProjectDto project);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
    
    ProjectDto update(Long id, ProjectDto project);
}
