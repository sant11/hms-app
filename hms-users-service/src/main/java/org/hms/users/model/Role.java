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

@Entity
@Table(name = "roles", schema="public")
public class Role {

	public Role() {
		
    }

	
    @Id
    @SequenceGenerator(name="roles_id_seq", sequenceName="roles_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roles_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;   

    @Column(name="name", nullable = false, length = 30)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<RolesGroupRole> rolesGroupRole;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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
     * @param rolesGroupRole the rolesGroupRole to set
     */
    public void setRolesGroupRole(List<RolesGroupRole> rolesGroupRole) {
        this.rolesGroupRole = rolesGroupRole;
    }

    /**
     * @return the rolesGroupRole
     */
    public List<RolesGroupRole> getRolesGroupRole() {
        return rolesGroupRole;
    }

}
    