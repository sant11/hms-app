package org.hms.api.application;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserServiceClient {

    private final RestTemplate loadBalancedRestTemplate;
	
    public UserDetails getUser(final int userId) {
        return loadBalancedRestTemplate.getForObject("http://users-service/users/{userId}", UserDetails.class, userId);
    }
	
}
