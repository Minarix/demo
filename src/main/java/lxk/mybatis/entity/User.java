package lxk.mybatis.entity;

import java.util.Date;

import lombok.Data;

@Data
public class User {
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