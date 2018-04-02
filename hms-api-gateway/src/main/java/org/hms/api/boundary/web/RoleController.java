package org.hms.api.boundary.web;

import org.hms.api.application.role.RoleDetails;
import org.hms.api.application.role.RoleServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RoleController {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private final RoleServiceClient roleServiceClient;

    @GetMapping(value = "roles/{roleId}")
    public RoleDetails getRoleDetails(final @PathVariable int roleId) {
    	log.info("start getting role data. Role ID: {}", roleId);
    	
        final RoleDetails role = roleServiceClient.getRole(roleId);

        log.info("end getting role data. Role ID: {}", roleId);
        
        return role;
    }


    @GetMapping(value = "roles")
    public RoleDetails[] getRoles() {
    	log.info("start getting roles data");
    	
        final RoleDetails[] roles = roleServiceClient.getRoles();

        log.info("end getting role data - roles fetched: {}", roles.length);
        
        return roles;
    }


    @PutMapping(value = "roles")
    public RoleDetails update(@RequestBody RoleDetails roleDetails) {
   	    log.info("start updating user data. User ID: {}", roleDetails.getId());
    	
        final RoleDetails role = roleServiceClient.update(roleDetails);;

        log.info("end updating user data. User ID: {}", roleDetails.getId());
        
        return role;
    }    

    @PostMapping(value = "roles")
    public RoleDetails create(@RequestBody RoleDetails roleDetails) {
   	    log.info("start creating role data. Role ID: {}", roleDetails.getId());
    	
        final RoleDetails role = roleServiceClient.create(roleDetails);;

        log.info("end creating role data. Role ID: {}", roleDetails.getId());

        return role;
    }   
    

    @DeleteMapping(value = "roles/{roleId}")
    public void create(final @PathVariable int roleId) {
   	    log.info("start deleting role. Role ID: {}", roleId);
    	
        roleServiceClient.delete(roleId);

        log.info("end deleting role. Role ID: {}", roleId);
        
    }      

    
}