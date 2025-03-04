package com.issue_tracker.issue_tracker.service;

import com.issue_tracker.issue_tracker.model.Issue;
import com.issue_tracker.issue_tracker.repository.IssueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class IssueServiceTest {

    @Mock
    private IssueRepository issueRepository;

    @InjectMocks
    private IssueService issueService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllIssues() {
        Issue issue1 = new Issue("Issue 1", "Description 1");
        Issue issue2 = new Issue("Issue 2", "Description 2");

        when(issueRepository.findAll()).thenReturn(Arrays.asList(issue1, issue2));

        List<Issue> issues = issueService.getAllIssues();

        assertEquals(2, issues.size());
        verify(issueRepository, times(1)).findAll();
    }
}
