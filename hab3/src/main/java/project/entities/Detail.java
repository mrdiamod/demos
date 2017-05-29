package project.entities;

import java.util.Set;

import javax.persistence.*;

import org.springframework.security.access.prepost.PreFilter;

@Entity
@Table(name="details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
//    private long user_id;
//    private long sheme_id;
    private String detailname;
    private long power;
    private String units;
    private long price;
    
    
    @ManyToOne    
    @JoinColumn(name="user_id")
    private User details_usersList;

    public User getDetails_usersList() {
        return details_usersList;
    }
    public void setDetails_shemesList(User details_users) {
        this.details_usersList = details_users;
    }
    
    @ManyToOne    
    @JoinColumn(name="sheme_id")
    private Sheme details_shemesList;

    public Sheme getDetails_shemesList() {
        return details_shemesList;
    }
    public void setDetails_shemesList(Sheme details_shemes) {
        this.details_shemesList = details_shemes;
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
//    
//    public long getShemeId() {
//        return sheme_id;
//    }
//
//    public void setShemeId(long shemeid) {
//        this.sheme_id = shemeid;
//    }
    
    public String getDetailname() {
        return detailname;
    }

    public void setDetailname(String detailname) {
        this.detailname = detailname;
    }
    
    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }
    
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
    
    protected Detail(){}
    public Detail(String name, long powerV, String unitsV, long priceB) {
//    	user_id = userid;
//    	sheme_id = shemeid;
    	detailname = name;
    	power = powerV;
    	units = unitsV;
    	price = priceB;
    }
    
    
}