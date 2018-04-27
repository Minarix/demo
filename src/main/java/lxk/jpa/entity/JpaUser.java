package lxk.jpa.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="user")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"}) 
public class JpaUser implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1130008604562314848L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="user_name",nullable=true)
	private String userName;
	@Column(name="login_name",nullable=true)
	private String loginName;
	@Column(name="password",nullable=true)
    private String password;
	@Column(name="age",nullable=true)
    private Integer age;
	@Column(name="email",nullable=true)
    private String email;
	@Column(name="description",nullable=true)
    private String description;
	@Column(name="create_time",nullable=true)
    private Date createTime;
	@Column(name="creator",nullable=true)
    private String creator;
	@Column(name="update_time",nullable=true)
    private Date updateTime;
	@Column(name="updator",nullable=true)
    private String updator;


	

    @Override
	public String toString()
	{
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				'}';
	}
}
