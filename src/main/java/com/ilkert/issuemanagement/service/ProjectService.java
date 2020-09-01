package com.ilkert.issuemanagement.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.entity.Project;

import java.util.List;

public interface ProjectService  {

    Project Save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Project project);
}
