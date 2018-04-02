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
@Table(name = "users_group_roles", schema="public")
public class UserGroupRoles {

    public UserGroupRoles() {

    }

    @Id
    @SequenceGenerator(name="user_group_roles_id_seq", sequenceName="user_group_roles_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_group_roles_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;   

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * @return the user
     */
    public User getUser() {
        return user;
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