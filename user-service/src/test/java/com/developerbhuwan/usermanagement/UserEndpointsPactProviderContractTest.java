package com.developerbhuwan.usermanagement;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;

import static org.mockito.Mockito.when;

@RunWith(SpringRestPactRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test")
@PactBroker(host = "localhost", port = "7080")
@Provider("user-service")
public class UserEndpointsPactProviderContractTest {

    @TestTarget
    public final Target target = new HttpTarget(9050);

    @MockBean
    private UserService userService;

    @State(value = "get all billing users")
    public void givenARequestGetAllUsers() {
        UserDTO userDTO = new UserDTO("BHUWAN UPADHYAY", "ADMIN");
        when(userService.getUsers()).thenReturn(Collections.singletonList(userDTO));
    }

}