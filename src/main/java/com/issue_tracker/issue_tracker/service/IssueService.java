package com.issue_tracker.issue_tracker.service;


import com.issue_tracker.issue_tracker.model.Issue;
import com.issue_tracker.issue_tracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public List<Issue> getIssuesByStatus(String status) {
        return issueRepository.findByStatus(status);
    }
}
