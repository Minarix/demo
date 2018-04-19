package lxk.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3178930180534881346L;

	private Integer id;

	private String loginName;

	private String userName;

	private String password;

	private Integer age;

	private String email;

	private String description;

	private Date createTime;

	private String creator;

	private Date updateTime;

	private String updator;

}