package org.hms.api.application.user;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
	
    public UserDetails[] getUsers() {
        
    	
    	ResponseEntity<UserDetails[]> responseEntity = loadBalancedRestTemplate.getForEntity("http://users-service/users/", UserDetails[].class);

    	UserDetails[] objects = responseEntity.getBody();    	
    	
    	return objects;
    	
    }
    
    public UserDetails create(final UserDetails userDetails) {

        HttpEntity<UserDetails> entity = new HttpEntity<UserDetails>(userDetails);
                
        ResponseEntity<UserDetails> response = loadBalancedRestTemplate.exchange("http://users-service/users/", HttpMethod.POST, entity, UserDetails.class);

        return response.getBody();
    }
    
    public UserDetails update(final UserDetails userDetails) {
    	
    	HttpEntity<UserDetails> entity = new HttpEntity<UserDetails>(userDetails);
    	
        ResponseEntity<UserDetails> response = loadBalancedRestTemplate.exchange("http://users-service/users/", HttpMethod.PUT, entity, UserDetails.class);
        
        return response.getBody();
    }
    
    public void delete(final int userId) {
        loadBalancedRestTemplate.delete("http://users-service/users/{userId}", userId);
    }
    
    
}
