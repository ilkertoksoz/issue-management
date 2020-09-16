package com.ilkert.issuemanagement.service.Impl;

import java.util.Arrays;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ilkert.issuemanagement.dto.IssueDto;
import com.ilkert.issuemanagement.entity.Issue;
import com.ilkert.issuemanagement.repository.IssueRepository;
import com.ilkert.issuemanagement.service.IssueService;
import com.ilkert.issuemanagement.util.Tpage;

@Service
public class IssueServiceImpl implements IssueService {

    private  final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public  IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

	@Override
	public IssueDto Save(IssueDto issue) {
		
		if (null == issue.getDate()) {
			
			throw new IllegalArgumentException("Issue Date can not be null");
		}
		
		Issue issueDb = modelMapper.map(issue, Issue.class);
		
		issueDb = issueRepository.save(issueDb);
		
		return modelMapper.map(issueDb, IssueDto.class);
	}

	@Override
	public IssueDto getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tpage<IssueDto> getAllPageable(Pageable pageable) {
		
		Page<Issue> data = issueRepository.findAll(pageable);
		
		Tpage<IssueDto> page = new Tpage<IssueDto>();
		
		IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
		
		page.setStat(data, Arrays.asList(dtos));
		
		return page;
	}

	@Override
	public Boolean delete(Long issueId) {
		issueRepository.deleteById(issueId);
		return true;
	}

	@Override
	public IssueDto update(Long id, IssueDto issue) {
		// TODO Auto-generated method stub
		return null;
	} 
} 