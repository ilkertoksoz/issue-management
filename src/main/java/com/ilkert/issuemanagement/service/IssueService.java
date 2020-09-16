package com.ilkert.issuemanagement.service;

import org.springframework.data.domain.Pageable;

import com.ilkert.issuemanagement.dto.IssueDto;
import com.ilkert.issuemanagement.util.Tpage;


public interface IssueService {

    IssueDto Save(IssueDto issue);

    IssueDto getById(Long id);

    Tpage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete (Long issue);
    
    IssueDto update(Long id, IssueDto issue);
}
