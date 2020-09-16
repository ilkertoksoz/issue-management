package com.ilkert.issuemanagement.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.dto.ProjectDto;
import com.ilkert.issuemanagement.entity.Project;
import com.ilkert.issuemanagement.util.Tpage;

public interface ProjectService {

	ProjectDto Save(ProjectDto project);

	ProjectDto getById(Long id);

	ProjectDto getByProjectCode(String projectCode);

	List<Project> getByProjectCodeContains(String projectCode);

	Tpage<ProjectDto> getAllPageable(Pageable pageable);

	Boolean delete(Project project);

	ProjectDto update(Long id, ProjectDto project);
}
