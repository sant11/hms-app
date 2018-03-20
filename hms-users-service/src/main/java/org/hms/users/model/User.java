package org.hms.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema="public")
public class User {

	public User() {
		
	}
	
	
    @Id
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="users_id_seq")
    @Column(name = "id", updatable=false)
    private Long id;        
    
    @Column(name="login", nullable = false, length = 30)
    private String login;
    
    @Column(name="password", length = 30)
    private String password;
    
    @Column(name="fname", nullable = false, length = 255)
    private String firstName;
    
    @Column(name="lname", nullable = false, length = 255)
    private String lastName;
	
    @Column(name="email", length = 255)
    private String email;

    
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

        
    
}
