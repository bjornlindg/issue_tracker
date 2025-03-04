package com.issue_tracker.issue_tracker.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class IssueTest {

    @Test
    void testConstructorAndGetters() {
        String title = "Issue Title";
        String description = "Issue Description";

        Issue issue = new Issue(title, description);

        assertEquals(title, issue.getTitle());
        assertEquals(description, issue.getDescription());
        assertNotNull(issue.getCreatedAt());
    }

    @Test
    void testSetters() {
        Issue issue = new Issue("Initial Title", "Initial Description");

        String newTitle = "Updated Title";
        String newDescription = "Updated Description";
        IssueStatus newStatus = IssueStatus.CLOSED;

        issue.setTitle(newTitle);
        issue.setDescription(newDescription);
        issue.setStatus(newStatus);

        assertEquals(newTitle, issue.getTitle());
        assertEquals(newDescription, issue.getDescription());
        assertEquals(newStatus, issue.getStatus());
    }

    @Test
    void testEqualsAndHashCode() {
        Issue issue1 = new Issue("Same Title", "Same Description");
        Issue issue2 = new Issue("Same Title", "Same Description");

        assertNotEquals(issue1, issue2);
        assertNotEquals(issue1.hashCode(), issue2.hashCode());
    }

    @Test
    void testToString() {
        Issue issue = new Issue("Title", "Description");
        String expectedString = "Issue{title='Title', description='Description', status='Open', createdAt=" + issue.getCreatedAt() + "}";
        assertTrue(issue.toString().contains("title='Title'"));
    }
}
