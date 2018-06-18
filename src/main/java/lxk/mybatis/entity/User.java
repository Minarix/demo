package lxk.mybatis.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=false)
@Data
@TableName("USER")
public class User extends Model<User>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8571665941793918657L;

	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	@TableField("login_name")
	private String loginName;
	@TableField("user_name")
	private String userName;
	@TableField("password")
	private String password;
	@TableField("age")
	private Integer age;
	@TableField("email")
	private String email;
	@TableField("description")
	private String description;
	@TableField("create_time")
	private Date createTime;
	@TableField("creator")
	private String creator;
	@TableField("update_time")
	private Date updateTime;
	@TableField("updator")
	private String updator;

	@Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", userName=" + userName +
        ", password=" + password +
        ", age=" + age +
        ", email=" + email +
        ", description=" + description +
        ", createTime=" + createTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", updator=" + updator +
        "}";
    }

}