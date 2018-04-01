package org.hms.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "roles_group_roles", schema="public")
public class RolesGroupRole {

    public RolesGroupRole() {

    }


    @Id
    @SequenceGenerator(name="roles_group_roles_id_seq", sequenceName="roles_group_roles_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="roles_group_roles_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_role_id", nullable = false)
    private GroupRole groupRole;


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
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param groupRole the groupRole to set
     */
    public void setGroupRole(GroupRole groupRole) {
        this.groupRole = groupRole;
    }

    /**
     * @return the groupRole
     */
    public GroupRole getGroupRole() {
        return groupRole;
    }

}