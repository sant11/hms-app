package org.hms.users.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "group_roles", schema="public")
public class GroupRole {

    public GroupRole() {

    }

    @Id
    @SequenceGenerator(name="group_roles_id_seq", sequenceName="group_roles_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="group_roles_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;   

    @Column(name="name", nullable = false, length = 30)
    private String name;

    @Column(name="description", nullable = false)
    private String description;
    
    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupRole")
    private List<RolesGroupRole> rolesGroupRoles;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groupRole")
    private List<UserGroupRoles> userGroupRoles;

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param rolesGroupRoles the rolesGroupRoles to set
     */
    public void setRolesGroupRoles(List<RolesGroupRole> rolesGroupRoles) {
        this.rolesGroupRoles = rolesGroupRoles;
    }

    /**
     * @return the rolesGroupRoles
     */
    public List<RolesGroupRole> getRolesGroupRoles() {
        return rolesGroupRoles;
    }

    /**
     * @param userGroupRoles the userGroupRoles to set
     */
    public void setUserGroupRoles(List<UserGroupRoles> userGroupRoles) {
        this.userGroupRoles = userGroupRoles;
    }

    /**
     * @return the userGroupRoles
     */
    public List<UserGroupRoles> getUserGroupRoles() {
        return userGroupRoles;
    }
}