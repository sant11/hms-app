package org.hms.api.boundary.web;

import org.hms.api.application.UserDetails;
import org.hms.api.application.UserServiceClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiGatewayController {

	private final UserServiceClient userServiceClient;
	
	
    @GetMapping(value = "users/{userId}")
    public UserDetails getUserDetails(final @PathVariable int userId) {
        final UserDetails user = userServiceClient.getUser(userId);

        return user;
    }
	
}
