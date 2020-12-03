package com.ilkert.issuemanagement.api;

import javax.validation.Valid;

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

import com.ilkert.issuemanagement.dto.IssueDto;
import com.ilkert.issuemanagement.service.Impl.IssueServiceImpl;
import com.ilkert.issuemanagement.util.ApiPaths;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.IssueCtrl.CTRL, description = "Issue APIs")
public class IssueController {

	private final IssueServiceImpl issueServiceImpl;

	public IssueController(IssueServiceImpl issueServiceImpl) {
		this.issueServiceImpl = issueServiceImpl;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {

		return new ResponseEntity<>(issueServiceImpl.getById(id), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto) {

		return new ResponseEntity<>(issueServiceImpl.Save(issueDto), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Update Operation", response = IssueDto.class)
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id,
			@Valid @RequestBody IssueDto issueDto) {

		return new ResponseEntity<>(issueServiceImpl.update(id, issueDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Delete Operation", response = Boolean.class)
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

		return new ResponseEntity<>(issueServiceImpl.delete(id), HttpStatus.OK);
	}

}