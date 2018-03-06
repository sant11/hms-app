package org.hms.api.boundary.web;

import java.util.Collection;

import org.hms.api.application.UserDetails;
import org.hms.api.application.UserServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiGatewayController {

	private static final Logger log = LoggerFactory.getLogger(ApiGatewayController.class);
	
	private final UserServiceClient userServiceClient;
	
	
    @GetMapping(value = "users/{userId}")
    public UserDetails getUserDetails(final @PathVariable int userId) {
    	log.info("start getting user data. User ID: {}", userId);
    	
        final UserDetails user = userServiceClient.getUser(userId);

        log.info("end getting user data. User ID: {}", userId);
        
        return user;
    }

    @GetMapping(value = "users")
    public UserDetails[] getUsers() {
    	log.info("start getting users data");
    	
        final UserDetails[] users = userServiceClient.getUsers();

        log.info("end getting user data - users fetched: {}", users.length);
        
        return users;
    }
}
