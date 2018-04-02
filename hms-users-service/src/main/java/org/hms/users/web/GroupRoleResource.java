package org.hms.users.web;

import java.util.List;

import javax.validation.Valid;

import org.hms.users.dao.GroupRoleRepository;
import org.hms.users.model.GroupRole;
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

@RequestMapping("/groupRoles")
@RestController
@RequiredArgsConstructor
@Slf4j
public class GroupRoleResource {

    private final GroupRoleRepository groupRoleRepository;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Monitored
    public void createGroupRole(@Valid @RequestBody GroupRole groupRole) {
        groupRoleRepository.save(groupRole);
    }    

    
    @GetMapping(value = "/{groupRoleId}")
    @Monitored
    public GroupRole findGroupRole(@PathVariable("groupRoleId") Long groupRoleId) {
        return groupRoleRepository.findOne(groupRoleId);
    }
    
    @GetMapping
    @Monitored
    public List<GroupRole> findAll() {
        return groupRoleRepository.findAll();
    }
    
    @PutMapping
    @Monitored
    public GroupRole updateRole(@Valid @RequestBody GroupRole groupRoleRequest) {
        final GroupRole groupRoleModel = groupRoleRepository.findOne(groupRoleRequest.getId());
        groupRoleModel.setName(groupRoleRequest.getName());
        groupRoleModel.setDescription(groupRoleRequest.getDescription());
        log.info("Saving group role {}", groupRoleModel);
        return groupRoleRepository.save(groupRoleModel);
    }

    @DeleteMapping(value = "/{groupRoleId}")
    @Monitored
    public void delete(@PathVariable("groupRoleId") Long groupRoleId) {
    	groupRoleRepository.delete(groupRoleId);
    	
    	log.info("group role deleted: {}", groupRoleId);
    }
        
}