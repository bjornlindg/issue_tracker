package com.issue_tracker.issue_tracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    @NotBlank
    private String status; // E.g., "Open", "In Progress", "Closed"

    @NotNull
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Issue() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
}

