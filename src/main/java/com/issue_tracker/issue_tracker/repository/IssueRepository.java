package com.issue_tracker.issue_tracker.repository;

import com.issue_tracker.issue_tracker.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRepository extends JpaRepository<Issue, Long> {

    // Custom query methods (if needed)
    List<Issue> findByStatus(String status); // Finds issues by their status
}
