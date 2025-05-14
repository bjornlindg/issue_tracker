package com.issue_tracker.issue_tracker.service;

import com.issue_tracker.issue_tracker.model.User;
import com.issue_tracker.issue_tracker.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUserById() {
        User user = new User("John", "Doe");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(userRepository.save(user)).thenReturn(user);

        assertEquals(user, userService.createUser(user));
        assertEquals(user, userService.getUserById(user.getId()));
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User("John", "Doe");
        User user2 = new User("John", "Doe");

        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();

        assertEquals(2, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testUpdateUser_Success() {
        User existingUser = new User("Alice", "Smith");
        User updatedInfo = new User("Alicia", "Johnson");

        when(userRepository.findById(existingUser.getId())).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(updatedInfo);

        User result = userService.updateUser(existingUser.getId(), updatedInfo);

        assertEquals("Alicia", result.getFirstName());
        assertEquals("Johnson", result.getLastName());

        verify(userRepository).findById(existingUser.getId());
        verify(userRepository).save(existingUser);
    }

    @Test
    public void testUpdateUser_UserNotFound() {
        Long userId = 1L;
        User updatedInfo = new User("Alicia", "Johnson");

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> userService.updateUser(userId, updatedInfo));

        verify(userRepository).findById(userId);
        verify(userRepository, never()).save(any());
    }

    @Test
    public void testDeleteUser_Success() {
        Long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(true);

        userService.deleteUser(userId);

        verify(userRepository).existsById(userId);
        verify(userRepository).deleteById(userId);
    }

    @Test
    public void testDeleteUser_UserNotFound() {
        Long userId = 2L;

        when(userRepository.existsById(userId)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            userService.deleteUser(userId);
        });

        assertEquals("User not found", exception.getMessage());

        verify(userRepository, never()).deleteById(anyLong());
    }


}
