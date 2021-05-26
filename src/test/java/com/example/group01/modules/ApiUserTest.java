package com.example.group01.modules;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiUserTest {

    @Test
    void getEmail() {
        String email = "email";
        ApiUser apiUser = new ApiUser("email", "test", "test", "test");
        assertNotNull(apiUser);
        assertEquals(email, apiUser.getUsername());
    }

    @Test
    void setEmail() {
        ApiUser apiUser = new ApiUser("email", "test", "test", "test");
        apiUser.setUsername("email2");
        assertNotNull(apiUser);
        assertEquals("email2", apiUser.getUsername());
    }

    @Test
    void getId() {
        long id = 1;
        ApiUser apiUser = new ApiUser();
        apiUser.setId(id);
        assertEquals(id, apiUser.getId());
    }

    @Test
    void createUser() {
        new ApiUser();
    }

    @Test
    void setId() {
        long id = 1;
        ApiUser apiUser = new ApiUser();
        apiUser.setId(id);
        assertEquals(id, apiUser.getId());
    }

    @Test
    void getPassword() {
        String password = "password";
        ApiUser apiUser = new ApiUser("email", "password", "test", "test");
        assertNotNull(apiUser);
        assertEquals(password, apiUser.getPassword());

    }

    @Test
    void setPassword() {
        ApiUser apiUser = new ApiUser("email", "test", "test", "test");
        apiUser.setPassword("password");
        assertNotNull(apiUser);
        assertEquals("password", apiUser.getPassword());
    }

    @Test
    void getFirstName() {
        String firstName = "alex";
        ApiUser apiUser = new ApiUser("email", "test", "alex", "test");
        assertNotNull(apiUser);
        assertEquals(firstName, apiUser.getFirstName());
    }

    @Test
    void setFirstName() {
        ApiUser apiUser = new ApiUser("email", "test", "alex", "test");
        apiUser.setFirstName("george");
        assertNotNull(apiUser);
        assertEquals("george", apiUser.getFirstName());
    }

    @Test
    void getLastName() {
        String secondName = "petrov";
        ApiUser apiUser = new ApiUser("email", "test", "alex", "petrov");
        assertNotNull(apiUser);
        assertEquals(secondName, apiUser.getLastName());

    }

    @Test
    void setLastName() {
        ApiUser apiUser = new ApiUser("email", "test", "alex", "test");
        apiUser.setLastName("petrov");
        assertNotNull(apiUser);
        assertEquals("petrov", apiUser.getLastName());

    }
}