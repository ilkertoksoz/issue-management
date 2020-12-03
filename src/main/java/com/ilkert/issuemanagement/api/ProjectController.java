package com.ilkert.issuemanagement.api;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ilkert.issuemanagement.dto.ProjectDto;
import com.ilkert.issuemanagement.service.Impl.ProjectServiceImpl;
import com.ilkert.issuemanagement.util.ApiPaths;
import com.ilkert.issuemanagement.util.Tpage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@Slf4j
public class ProjectController {

	private final ProjectServiceImpl projectServiceImpl;

	public ProjectController(ProjectServiceImpl projectServiceImpl) {
		this.projectServiceImpl = projectServiceImpl;
	}

	@GetMapping("/pagination")
	@ApiOperation(value = "Get By Pagination", response = ProjectDto.class)
	public ResponseEntity<Tpage<ProjectDto>> getAllByPagination(Pageable pageable) {

		return new ResponseEntity<>(projectServiceImpl.getAllPageable(pageable), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {

		log.info("ProjectController-> GETBYID ");
		log.debug("ProjectController-> GETBYID->PARAM:" + id);

		return new ResponseEntity<>(projectServiceImpl.getById(id), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {

		return new ResponseEntity<>(projectServiceImpl.Save(projectDto), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation", response = ProjectDto.class)
	public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id,
			@Valid @RequestBody ProjectDto projectDto) {

		return new ResponseEntity<>(projectServiceImpl.update(id, projectDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

		return new ResponseEntity<>(projectServiceImpl.delete(id), HttpStatus.OK);
	}
}