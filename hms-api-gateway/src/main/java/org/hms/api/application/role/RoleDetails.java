package org.hms.api.application.role;

import lombok.Data;

@Data
public class RoleDetails {
	
	public RoleDetails() {
		
	}
	
    private Long id;        
    
    private String name;
    
    private String description;
    
}