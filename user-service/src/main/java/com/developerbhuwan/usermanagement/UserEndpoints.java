package com.developerbhuwan.usermanagement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserEndpoints {

    @GetMapping("billing/users")
    public List<Object> getBillingUsers() {
        return new ArrayList<>();
    }

}
