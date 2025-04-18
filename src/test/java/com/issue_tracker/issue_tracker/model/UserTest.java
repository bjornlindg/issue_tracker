package com.issue_tracker.issue_tracker.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testConstructorAndGetters() {
        String firstName = "John";
        String lastName = "Doe";
        String fullName = firstName + " " + lastName;

        User user = new User(firstName, lastName);
        assertEquals(firstName, user.getFirstName());
        assertEquals(lastName, user.getLastName());
        assertEquals(fullName, user.getFullName());
    }

    @Test
    void testSetters() {
        String firstName = "John";
        String lastName = "Doe";
        User user = new User(firstName, lastName);

        String newFirstName = "Peter";
        String newLastName = "Smith";
        String newFullName = newFirstName + " " + newLastName;
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        assertEquals(newFirstName, user.getFirstName());
        assertEquals(newLastName, user.getLastName());
        assertEquals(newFullName, user.getFullName());
    }

    @Test
    void testEqualsAndHashcode() {
        String firstName = "John";
        String lastName = "Doe";
        User user1 = new User(firstName, lastName);
        User user2 = new User(firstName, lastName);

        assertNotEquals(user1, user2);
        assertNotEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    void testToString() {
        String firstName = "John";
        String lastName = "Doe";
        User user = new User(firstName, lastName);
        String expectedFirstName = "firstName=" + firstName;
        String expectedLastName = "lastName=" + lastName;
        assertTrue(user.toString().contains(expectedFirstName));
        assertTrue(user.toString().contains(expectedLastName));
    }
}
