package org.hms.api.boundary.web;


import org.hms.api.application.user.UserDetails;
import org.hms.api.application.user.UserServiceClient;
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
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
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
    
    @PutMapping(value = "users")
    public UserDetails update(@RequestBody UserDetails userDetails) {
   	    log.info("start updating user data. User ID: {}", userDetails.getId());
    	
        final UserDetails user = userServiceClient.update(userDetails);;

        log.info("end updating user data. User ID: {}", userDetails.getId());
        
        return user;
    }    

    @PostMapping(value = "users")
    public UserDetails create(@RequestBody UserDetails userDetails) {
   	    log.info("start creating user data. User ID: {}", userDetails.getId());
    	
        final UserDetails user = userServiceClient.create(userDetails);;

        log.info("end creating user data. User ID: {}", userDetails.getId());

        return user;
    }        

    @DeleteMapping(value = "users/{userId}")
    public void create(final @PathVariable int userId) {
   	    log.info("start deleting user. User ID: {}", userId);
    	
        userServiceClient.delete(userId);

        log.info("end deleting user. User ID: {}", userId);
        
    }      
}
