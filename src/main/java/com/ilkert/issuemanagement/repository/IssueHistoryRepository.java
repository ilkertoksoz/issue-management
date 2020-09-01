package com.ilkert.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilkert.issuemanagement.entity.IssueHistory;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
}
