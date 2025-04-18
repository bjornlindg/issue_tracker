package com.issue_tracker.issue_tracker.repository;

import com.issue_tracker.issue_tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
