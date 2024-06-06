package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * UserService is a service class that handles business logic related to User operations.
 * It interacts with an external API to fetch user data.
 */
@Service
public class UserService {

    /**
     * The base URL of the external API from which user data is fetched.
     * This value is injected from the application properties.
     */
    @Value("${external.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    /**
     * Constructor for UserService.
     *
     * @param restTemplate the RestTemplate used to make HTTP requests to the external API.
     */
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches and returns a list of all users from the external API.
     *
     * @return a list of User objects.
     */
    public List<User> getUsers() {
        String url = apiUrl + "/posts";
        User[] usersArray = restTemplate.getForObject(url, User[].class);
        return Arrays.stream(usersArray).collect(Collectors.toList());
    }

    /**
     * Fetches and returns a list of users with the specified userId from the external API.
     *
     * @param userId the ID of the user to be fetched.
     * @return a list of User objects that match the specified userId.
     */
    public List<User> getUsers(int userId) {
        String url = apiUrl + "/posts";
        User[] usersArray = restTemplate.getForObject(url, User[].class);
        return Arrays.stream(usersArray)
                .filter(user -> user.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
