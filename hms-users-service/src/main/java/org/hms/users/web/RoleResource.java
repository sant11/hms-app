package org.hms.users.web;

import java.util.List;

import javax.validation.Valid;

import org.hms.users.model.Role;
import org.hms.users.dao.RoleRepository;
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

@RequestMapping("/roles")
@RestController
@RequiredArgsConstructor
@Slf4j
public class RoleResource {

    private final RoleRepository roleRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Monitored
    public void createRole(@Valid @RequestBody Role role) {
        roleRepository.save(role);
    }    

    
    @GetMapping(value = "/{roleId}")
    @Monitored
    public Role findRole(@PathVariable("roleId") Long roleId) {
        return roleRepository.findOne(roleId);
    }
    
    @GetMapping
    @Monitored
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    
    @PutMapping
    @Monitored
    public Role updateRole(@Valid @RequestBody Role roleRequest) {
        final Role roleModel = roleRepository.findOne(roleRequest.getId());
        roleModel.setName(roleRequest.getName());
        roleModel.setDescription(roleRequest.getDescription());
        log.info("Saving role {}", roleModel);
        return roleRepository.save(roleModel);
    }

    @DeleteMapping(value = "/{roleId}")
    @Monitored
    public void delete(@PathVariable("roleId") Long roleId) {
    	roleRepository.delete(roleId);
    	
    	log.info("role deleted: {}", roleId);
    }
        
}