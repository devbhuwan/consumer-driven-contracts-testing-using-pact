package com.developerbhuwan.billing;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.PactSpecVersion;
import au.com.dius.pact.model.RequestResponsePact;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;


public class UserServiceClientPactConsumerContractTest {

    @Rule
    public PactProviderRuleMk2 mockProvider
            = new PactProviderRuleMk2("user-service", PactSpecVersion.V3, this);
    private RestTemplate restTemplate = new RestTemplate();

    @Pact(provider = "user-service", consumer = "billing-service")
    public RequestResponsePact createPact(PactDslWithProvider provider) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", MediaType.APPLICATION_JSON_UTF8_VALUE);


        return provider
                .given("get all billing users")
                .uponReceiving("a request to get all billing users")
                .path("/billing/users")
                .method(RequestMethod.GET.name())
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(
                        new PactDslJsonArray()
                                .object()
                                .stringType("fullName")
                                .stringType("type")
                                .closeObject())
                .toPact();
    }


    @Test
    @PactVerification
    public void givenGET_whenSendRequest_shouldReturn200() {
        UserServiceClient client = new UserServiceClient(restTemplate, mockProvider.getUrl());
        assertFalse(client.getBillingUsers().isEmpty());
    }
}