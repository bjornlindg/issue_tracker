package com.issue_tracker.issue_tracker.repository;

import com.issue_tracker.issue_tracker.model.Issue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
public class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;

    @Test
    public void testSaveAndFind() {
        Issue issue = new Issue();
        issue.setTitle("Sample Issue");
        issue.setStatus("Open");

        Issue savedIssue = issueRepository.save(issue);
        Optional<Issue> retrievedIssue = issueRepository.findById(savedIssue.getId());

        assertTrue(retrievedIssue.isPresent());
        assertEquals("Sample Issue", retrievedIssue.get().getTitle());
    }
}

