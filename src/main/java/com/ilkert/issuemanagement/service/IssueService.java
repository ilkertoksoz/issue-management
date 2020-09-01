package com.ilkert.issuemanagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.dto.IssueDto;
import com.ilkert.issuemanagement.entity.Issue;
import com.ilkert.issuemanagement.util.Tpage;


public interface IssueService {

    IssueDto Save(IssueDto issue);

    IssueDto getById(Long id);

    Tpage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete (IssueDto issue);
}
