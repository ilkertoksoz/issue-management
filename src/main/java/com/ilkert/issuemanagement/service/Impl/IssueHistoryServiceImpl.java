package com.ilkert.issuemanagement.service.Impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ilkert.issuemanagement.entity.IssueHistory;
import com.ilkert.issuemanagement.repository.IssueHistoryRepository;
import com.ilkert.issuemanagement.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

	private final IssueHistoryRepository issueHistoryRepository;

	public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {

		this.issueHistoryRepository = issueHistoryRepository;
	}

	@Override
	public IssueHistory Save(IssueHistory issueHistory) {

		if (null == issueHistory.getDate()) {
			
			throw new IllegalArgumentException("Issue can not be null !");
		}
		
		 issueHistory = issueHistoryRepository.save(issueHistory);
		 
		 return issueHistory;
	}

	@Override
	public IssueHistory getById(Long id) {
		
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {

		issueHistoryRepository.delete(issueHistory);
		
		return Boolean.TRUE;
	}

} 
