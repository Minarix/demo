package lxk.hibernate.hibernateEntity;


import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;

import lombok.Data;



@Entity(name = "HibernateUser")
@Table(name="user")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Data
public class HibernateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "login_name")
    private String loginName;

    @Column(name = "user_name")
    private String userName;
  
    @Column(name = "password")
    private String password;
    
    @Column(name = "age")
    private String age;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "create_time")
    private String createTime;
    
    @Column(name = "creator")
    private String creator;
 
    @Column(name = "update_time")
    private String updateTime;
    @NaturalId
    @Column(name = "updator", unique = true)
    private String updator;
    


    public HibernateUser() {}

    public HibernateUser(String userName) {
        this.userName = userName;
    }


}