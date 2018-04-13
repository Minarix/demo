package lxk.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lxk.common.datasource.DataSourceContextHolder;
import lxk.common.datasource.DynamicDataSourceAnnotation;
import lxk.dao.UserDao;
import lxk.entity.User;
import lxk.service.UserService;

@Service()
@DynamicDataSourceAnnotation
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return this.userDao.selectByPrimaryKey(userId);
	}

	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return this.userDao.getByLoginName(loginName);
	}

	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return this.userDao.getByUserName(userName);
	}

	@DynamicDataSourceAnnotation(dataSource = DataSourceContextHolder.DATA_SOURCE_B)
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}