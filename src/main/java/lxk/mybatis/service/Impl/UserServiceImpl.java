package lxk.mybatis.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lxk.common.datasource.DataSourceContextHolder;
import lxk.common.datasource.DynamicDataSourceAnnotation;
import lxk.mybatis.dao.UserDao;
import lxk.mybatis.entity.User;
import lxk.mybatis.service.UserService;

@Service()
@DynamicDataSourceAnnotation
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
	@Autowired
	private UserDao userDao;

	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(userId);
	}

	public User getUserByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return userDao.getByLoginName(loginName);
	}
	@Cacheable("default")
	public User getUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(userName);
	}

	@DynamicDataSourceAnnotation(dataSource = DataSourceContextHolder.DATA_SOURCE_B)
/*	按您的方法做了，但是service层加了@Transactional事务注解后，就无效了，@Transactional先执行，获取connection，切换就没用了。

	赞  回复
	suroot：  @Glory_United 是的 这种方法不能在事务里面切换数据源操作多个数据库，你也可以试试将业务往上提或者是将事务往下放。*/
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

}