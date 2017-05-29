package project.entities;

import java.util.Set;

import javax.persistence.*;

import org.springframework.security.access.prepost.PreFilter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String password;
    
    @JsonIgnore
    @OneToMany(mappedBy = "details_usersList")
    Set<Detail> detailsList;

    public Set<Detail> getDetailsList() { 
    	return detailsList; 
    }
    
    public void setDetailsList(Set<Detail> details) {
        this.detailsList = details;
    }
    
    
    
    //----------------------------------------
    @JsonIgnore
    @OneToMany(mappedBy = "shemes_usersList")
    Set<Sheme> shemesList;

    public Set<Sheme> getShemesList() { 
    	return shemesList; 
    }
    
    public void setShemesList(Set<Sheme> shemes) {
        this.shemesList = shemes;
    }
    
    
    
    
    //-------------------------------------------
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    //-------------------------------------------
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    protected User(){}
    public User(String name, String pass) {
        username = name;
        password = pass;
    }
    
    
}