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

    public Issue getIssueById(Long id) {
        return issueRepository.findById(id).orElseThrow(() -> new RuntimeException("Issue not found"));
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

    public Issue updateIssue(Long id, Issue updatedIssue) {
        return issueRepository.findById(id)
                .map(issue -> {
                    issue.setTitle(updatedIssue.getTitle());
                    issue.setDescription(updatedIssue.getDescription());
                    issue.setStatus(updatedIssue.getStatus());
                    issue.setAssignedUser(updatedIssue.getAssignedUser());
                    return issueRepository.save(issue);
                })
                .orElseThrow(() -> new RuntimeException("Issue not found"));
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }
}
