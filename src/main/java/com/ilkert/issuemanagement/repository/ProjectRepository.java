package com.ilkert.issuemanagement.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ilkert.issuemanagement.entity.Project;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project,Long> {

    Project getByProjectCode(String projectCode);

    Project getAllByProjectCodeAndIdNot(String projectCode, Long id);

    List<Project> getAllByProjectCodeAndProjectNameContains(String projectCode, String name);

    Page<Project> findAll(Pageable pageable);

    List<Project> findAll(Sort sort);
}
