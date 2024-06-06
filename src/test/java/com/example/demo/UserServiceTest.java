package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the UserService class.
 * This class uses Mockito to mock dependencies and test the behavior of UserService.
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserService userService;

    private final String apiUrl = "http://example.com";

    /**
     * Setup method to configure the test environment.
     * Uses ReflectionTestUtils to set the apiUrl field in the UserService.
     */
    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(userService, "apiUrl", apiUrl);
    }

    /**
     * Test for the getUsers() method.
     * Simulates a scenario where the external API returns a list of users.
     */
    @Test
    public void testGetUsers() {
        // Sample data for testing
        User[] usersArray = {
                new User(),
                new User()
        };

        usersArray[0].setUserId(1);
        usersArray[0].setId(101);
        usersArray[0].setTitle("Title1");
        usersArray[0].setBody("Body1");

        usersArray[1].setUserId(2);
        usersArray[1].setId(102);
        usersArray[1].setTitle("Title2");
        usersArray[1].setBody("Body2");

        // Mocking the RestTemplate response
        when(restTemplate.getForObject(apiUrl + "/posts", User[].class)).thenReturn(usersArray);

        // Calling the method to be tested
        List<User> users = userService.getUsers();

        // Asserting the results
        assertEquals(2, users.size());
        assertEquals(1, users.get(0).getUserId());
        assertEquals(101, users.get(0).getId());
        assertEquals("Title1", users.get(0).getTitle());
        assertEquals("Body1", users.get(0).getBody());

        assertEquals(2, users.get(1).getUserId());
        assertEquals(102, users.get(1).getId());
        assertEquals("Title2", users.get(1).getTitle());
        assertEquals("Body2", users.get(1).getBody());
    }

    /**
     * Test for the getUsers(int userId) method.
     * Simulates a scenario where the external API returns users filtered by userId.
     */
    @Test
    public void testGetUsersById() {
        // Sample data for testing
        User[] usersArray = {
                new User(),
                new User()
        };

        usersArray[0].setUserId(1);
        usersArray[0].setId(101);
        usersArray[0].setTitle("Title1");
        usersArray[0].setBody("Body1");

        usersArray[1].setUserId(2);
        usersArray[1].setId(102);
        usersArray[1].setTitle("Title2");
        usersArray[1].setBody("Body2");

        // Mocking the RestTemplate response
        when(restTemplate.getForObject(apiUrl + "/posts", User[].class)).thenReturn(usersArray);

        // Calling the method to be tested with a specific userId
        List<User> users = userService.getUsers(1);

        // Asserting the results
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getUserId());
        assertEquals(101, users.get(0).getId());
        assertEquals("Title1", users.get(0).getTitle());
        assertEquals("Body1", users.get(0).getBody());
    }
}
