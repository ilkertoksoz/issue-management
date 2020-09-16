package com.ilkert.issuemanagement.service.Impl;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ilkert.issuemanagement.dto.ProjectDto;
import com.ilkert.issuemanagement.entity.Project;
import com.ilkert.issuemanagement.repository.ProjectRepository;
import com.ilkert.issuemanagement.service.ProjectService;
import com.ilkert.issuemanagement.util.Tpage;

@Service
public class ProjectServiceImpl implements ProjectService {

	private final ProjectRepository projectRepository;
	private final ModelMapper modelMapper;

	public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {

		this.projectRepository = projectRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public ProjectDto Save(ProjectDto project) {

		Project projectCheck = projectRepository.getByProjectCode(project.getProjectCode());
		
		if (null != projectCheck) {
			
			throw new IllegalArgumentException("Project Code Already Existed");
		}
		
		Project p = modelMapper.map(project, Project.class);
		p = projectRepository.save(p);
		project.setId(p.getId());
		return project;
	}

	@Override
	public ProjectDto getById(Long id) {

		Project project = projectRepository.getOne(id);

		return modelMapper.map(project, ProjectDto.class);

	}

	@Override
	public  ProjectDto getByProjectCode(String projectCode) {
		return null;
	}

	@Override
	public List<Project> getByProjectCodeContains(String projectCode) {
		return null;
	}

	@Override
	public Tpage<ProjectDto> getAllPageable(Pageable pageable) {

		Page<Project> data = projectRepository.findAll(pageable);
		Tpage<ProjectDto> response = new Tpage<ProjectDto>();
		response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), ProjectDto[].class)));
		return response;
	}

	@Override
	public Boolean delete(Project project) {
		return null;
	}
	
	public Boolean delete(Long id) {
		 projectRepository.deleteById(id);
		 return true;
	}

	@Override
	public ProjectDto update(Long id, ProjectDto project) {
		
		Project projectDb = projectRepository.getOne(id);
		
		if (null == projectDb) {
			
			throw new IllegalArgumentException("Project Does not existed ID : " + id);
		}

		Project projectCheck = projectRepository.getAllByProjectCodeAndIdNot(project.getProjectCode(), project.getId());
		
		if (null != projectCheck && projectCheck.getId() != projectDb.getId()) {
			
			throw new IllegalArgumentException("Project Code Already Existed");
		}
		
		projectDb.setProjectCode(project.getProjectCode());
		projectDb.setProjectName(project.getProjectName());
		
		projectRepository.save(projectDb);
		return modelMapper.map(projectDb, ProjectDto.class);
	}
} 
