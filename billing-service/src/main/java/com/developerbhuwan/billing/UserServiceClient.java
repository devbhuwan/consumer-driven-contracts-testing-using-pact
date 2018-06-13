package com.developerbhuwan.billing;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class UserServiceClient {

    private final RestTemplate rest;

    public UserServiceClient(RestTemplate rest) {
        this.rest = rest;
    }

    public List<BillingUser> getBillingUsers() {
        return null;
    }
}
