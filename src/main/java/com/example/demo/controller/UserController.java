package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController handles HTTP requests related to User operations.
 * It provides endpoints to fetch all users or fetch users by a specific userId.
 */

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Handles GET requests to /posts.
     * Fetches and returns a list of all users.
     *
     * @return a list of User objects.
     */
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    /**
     * Handles GET requests to /posts/{userId}.
     * Fetches and returns a list of users with the specified userId.
     *
     * @param userId the ID of the user to be fetched.
     * @return a list of User objects that match the specified userId.
     */
    @GetMapping("/{userId}")
    public List<User> getUsers(@PathVariable int userId) {
        return userService.getUsers(userId);
    }
}



