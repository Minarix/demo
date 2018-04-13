package lxk.mybatis.service;

import java.util.List;

import lxk.mybatis.entity.User;

public interface UserService {
	User getUserById(int userId);

	User getUserByLoginName(String loginName);

	User getUserByUserName(String userName);

	List<User> getAllUser();
}