package com.developerbhuwan.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserEndpoints {

    private final UserService userService;

    public UserEndpoints(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("billing/users")
    public List<UserDTO> getBillingUsers() {
        return userService.getUsers();
    }

}
