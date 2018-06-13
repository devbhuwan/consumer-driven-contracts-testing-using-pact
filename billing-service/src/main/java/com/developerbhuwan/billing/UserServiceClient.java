package com.developerbhuwan.billing;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.emptyList;

@Component
public class UserServiceClient {

    private final RestTemplate restTemplate;
    private final String uri;

    public UserServiceClient(RestTemplate restTemplate, String uri) {
        this.restTemplate = restTemplate;
        this.uri = uri;
    }

    public List<BillingUser> getBillingUsers() {
        return Optional.ofNullable(restTemplate.getForObject(uri + "/billing/users", BillingUser[].class))
                .map(Arrays::asList)
                .map(Collections::unmodifiableList)
                .orElse(emptyList());
    }
}
