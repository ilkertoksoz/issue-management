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

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

	private final IssueServiceImpl issueServiceImpl;

	public IssueController(IssueServiceImpl issueServiceImpl) {
		this.issueServiceImpl = issueServiceImpl;
	}

	@GetMapping("/{id}")
	public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {

		return new ResponseEntity<>(issueServiceImpl.getById(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<IssueDto> createProject(@Valid @RequestBody IssueDto issueDto) {

		return new ResponseEntity<>(issueServiceImpl.Save(issueDto), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<IssueDto> updateProject(@PathVariable(value = "id", required = true) Long id,
			@Valid @RequestBody IssueDto issueDto) {

		return new ResponseEntity<>(issueServiceImpl.update(id, issueDto), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

		return new ResponseEntity<>(issueServiceImpl.delete(id), HttpStatus.OK);
	}

}