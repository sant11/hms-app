package org.hms.users.web;

import java.util.List;

import javax.validation.Valid;

import org.hms.users.model.User;
import org.hms.users.model.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.samples.petclinic.monitoring.Monitored;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserResource {

	private final UserRepository userRepository;
	
	
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Monitored
    public void createUser(@Valid @RequestBody User user) {
        userRepository.save(user);
    }
    
    @GetMapping(value = "/{userId}")
    public User findUser(@PathVariable("userId") Long userId) {
        return userRepository.findOne(userId);
    }
    
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @PutMapping
    @Monitored
    public User updateUser(@Valid @RequestBody User userRequest) {
        final User userModel = userRepository.findOne(userRequest.getId());
        userModel.setFirstName(userRequest.getFirstName());
        userModel.setLastName(userRequest.getLastName());
        log.info("Saving user {}", userModel);
        return userRepository.save(userModel);
    }

    @DeleteMapping
    public void test(@PathVariable("userId") Long userId) {
    	userRepository.delete(userId);
    	
    	log.info("user deleted: {}", userId);
    }
    
}
