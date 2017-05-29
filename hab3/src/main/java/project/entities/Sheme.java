package project.entities;

import java.util.Set;

import javax.persistence.*;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreFilter;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="shemes")

public class Sheme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //private long user_id;
    private String shemename;
    private String information;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "details_shemesList")
    Set<Detail> detailsList;

    public Set<Detail> getDetailsList() { 
    	return detailsList; 
    }
    
    public void setDetailList(Set<Detail> details) {
        this.detailsList = details;
    }
    
    @ManyToOne    
    @JoinColumn(name="user_id")
    private User shemes_usersList;
    
    
    public User getShemes_usersList() {
        return shemes_usersList;
    }

    public void setShemes_usersList(User shemes_users) {
        this.shemes_usersList = shemes_users;
    }
    
    
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
//    public long getUserId() {
//        return user_id;
//    }
//
//    public void setUserId(long userid) {
//        this.user_id = userid;
//    }

    public String getShemename() {
        return shemename;
    }

    public void setShemename(String shemename) {
        this.shemename = shemename;
    }
    
    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
    
    protected Sheme(){}
    public Sheme(String name, String info) {
       // user_id = userid;
    	shemename = name;
        information = info;
    }
    
}