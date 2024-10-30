package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

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

}
