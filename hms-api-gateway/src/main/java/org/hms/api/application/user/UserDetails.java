package org.hms.api.application.user;

import lombok.Data;

@Data
public class UserDetails {
	
	public UserDetails() {
		
	}
	
    private Long id;        
    
    private String login;
    
    private String password;
    
    private String firstName;
    
    private String lastName;
	
    private String email;
}
