package com.ilkert.issuemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ilkert.issuemanagement.entity.Issue;

public interface IssueRepository extends JpaRepository<Issue, Long> {
}
