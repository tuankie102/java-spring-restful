package vn.hoidanit.jobhunter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class HelloController {

    private final UserService userService;

    public HelloController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public User CreateNewUser(@RequestBody User user) {
        User postmanUser = this.userService.handleCreateUser(user);
        return postmanUser;
    }

    @DeleteMapping("/user/{id}")
    public String DeleteUser(@PathVariable("id") long id) {
        this.userService.handleDeleteUser(id);
        return "Delete a user successful!";
    }

    @GetMapping("user")
    public List<User> getAllUsers() {

        return userService.fetchAllUsers();
    }

    @GetMapping("user/{id}")
    public User getUserById(@PathVariable("id") long id) {

        return this.userService.fetchUserById(id);
    }

    @PutMapping("user")
    public User updateUser(@RequestBody User user) {

        return this.userService.handleCreateUser(user);
    }

}
