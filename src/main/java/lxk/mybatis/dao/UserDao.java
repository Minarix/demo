package lxk.mybatis.dao;

import java.util.List;

import lxk.mybatis.entity.User;

public interface UserDao {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	User getByUserName(String userName);

	User getByLoginName(String loginName);

	List<User> getAllUser();

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
