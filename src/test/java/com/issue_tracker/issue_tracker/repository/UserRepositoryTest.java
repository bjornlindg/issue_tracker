package com.issue_tracker.issue_tracker.repository;

import com.issue_tracker.issue_tracker.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

@SpringBootTest
@Transactional
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFind() {
        String firstName = "John";
        String lastName = "Doe";
        User user = new User(firstName, lastName);

        User savedUser = userRepository.save(user);
        Optional<User> retrievedUser = userRepository.findById(savedUser.getId());

        assertTrue(retrievedUser.isPresent());
        assertEquals(user.getFullName(), retrievedUser.get().getFullName());
    }

}
