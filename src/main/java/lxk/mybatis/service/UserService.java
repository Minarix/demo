package lxk.mybatis.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import lxk.mybatis.entity.User;

public interface UserService extends IService<User>{
	User getUserById(int userId);

	User getUserByLoginName(String loginName);

	User getUserByUserName(String userName);

	List<User> getAllUser();
}