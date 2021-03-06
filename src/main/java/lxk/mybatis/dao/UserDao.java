package lxk.mybatis.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import lxk.mybatis.entity.User;

public interface UserDao  extends BaseMapper<User> {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	User getByUserName(String userName);

	User getByLoginName(String loginName);

	List<User> getAllUser();

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);
}
