package com.ilkert.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkert.issuemanagement.dto.ProjectDto;
import com.ilkert.issuemanagement.service.Impl.ProjectServiceImpl;

@RestController
@RequestMapping("/project")
public class ProjectController {

	private final ProjectServiceImpl projectServiceImpl;
	
	 public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
				
		return new ResponseEntity<>(projectServiceImpl.getById(id), HttpStatus.OK);	
	}
	
	@PostMapping
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
		
		return new ResponseEntity<>(projectServiceImpl.Save(projectDto), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<ProjectDto> updateProject(@PathVariable("id") Long id,  @Valid @RequestBody ProjectDto projectDto) {
		
		return new ResponseEntity<>(projectServiceImpl.update(id,projectDto), HttpStatus.OK);
	}
}



