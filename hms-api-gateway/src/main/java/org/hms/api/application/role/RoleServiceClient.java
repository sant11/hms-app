package org.hms.api.application.role;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RoleServiceClient {

    private final RestTemplate loadBalancedRestTemplate;

    public RoleDetails getRole(final int roleId) {
        return loadBalancedRestTemplate.getForObject("http://users-service/roles/{roleId}", RoleDetails.class, roleId);
    }
	
    public RoleDetails[] getRoles() {
        
    	
    	ResponseEntity<RoleDetails[]> responseEntity = loadBalancedRestTemplate.getForEntity("http://users-service/roles/", RoleDetails[].class);

    	RoleDetails[] objects = responseEntity.getBody();    	
    	
    	return objects;
    	
    }
    
    public RoleDetails create(final RoleDetails roleDetails) {

        HttpEntity<RoleDetails> entity = new HttpEntity<RoleDetails>(roleDetails);
                
        ResponseEntity<RoleDetails> response = loadBalancedRestTemplate.exchange("http://users-service/roles/", HttpMethod.POST, entity, RoleDetails.class);

        return response.getBody();
    }
    
    public RoleDetails update(final RoleDetails roleDetails) {
    	
    	HttpEntity<RoleDetails> entity = new HttpEntity<RoleDetails>(roleDetails);
    	
        ResponseEntity<RoleDetails> response = loadBalancedRestTemplate.exchange("http://users-service/roles/", HttpMethod.PUT, entity, RoleDetails.class);
        
        return response.getBody();
    }
    
    public void delete(final int roleId) {
        loadBalancedRestTemplate.delete("http://users-service/roles/{roleId}", roleId);
    }
        

}