package lxk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;

import lxk.hibernate.hibernateEntity.HibernateUser;
import lxk.hibernate.hibernateService.HibernateUserService;
import lxk.jpa.entity.JpaUser;
import lxk.jpa.jpaService.JpaUserService;
import lxk.mybatis.entity.User;
import lxk.mybatis.service.UserService;



@Controller
@RequestMapping("/user")
public class RESTfulJSONController {
	@Autowired
	private UserService userService;
	@Autowired
	private HibernateUserService hibernateUserService;
	@Autowired
	private JpaUserService jpaUserService;
	@Autowired
	private CacheManager cacheManager;
	// 访问路径 http://localhost:8080/portal/user/view/long
	/** Spring MVC RESTful JSON **/
	@RequestMapping(value = "/view/{userName}", method = RequestMethod.GET)
	@ResponseBody
	public User view(@PathVariable String userName) {

//		User user = userService.getUserByUserName(userName);
		User user=userService.selectOne(new EntityWrapper<User>().eq("user_name",userName));
		return user;
	}

	// 访问路径 http://localhost:8080/portal/user/query?userName=long
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public User query(@RequestParam(value = "userName", required = true) String userName) {
		User user = userService.getUserByUserName(userName);
		System.out.println("view username:" + userName);

		return user;
	}

	// 访问路径 http://localhost:8080/portal/user/list
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<User> listPerson() {

		List<User> listUser = userService.getAllUser();

		return listUser;
	}
	// 访问路径 http://localhost:8080/portal/user/jpaquery?userName=long
	@RequestMapping(value = "/jpaquery", method = RequestMethod.GET)
	@ResponseBody
	public Page<JpaUser> jpaquery(@RequestParam(value = "userName", required = true) String userName,Pageable pageable) {
		
		Page<JpaUser> user = jpaUserService.findByUserName(userName, pageable);
		System.out.println("view username:" + userName);

		return user;
	}
	// 访问路径 http://localhost:8080/portal/user/jpaqueryid?id=1
	@RequestMapping(value = "/jpaqueryid", method = RequestMethod.GET)
	@ResponseBody
	public JpaUser jpaqueryId(@RequestParam(value = "id", required = true) Long id) {
		
		JpaUser user = jpaUserService.findAccountInfoById(id);

		return user;
	}
	// 访问路径 http://localhost:8080/portal/user/hibernatequery?userName=long
		@RequestMapping(value = "/hibernatequery", method = RequestMethod.GET)
		@ResponseBody
		public HibernateUser hibernatequery(@RequestParam(value = "userName", required = true) String userName) {
			HibernateUser user = hibernateUserService.findByName(userName);
			System.out.println("view username:" + userName);
			Cache cache=cacheManager.getCache("default");
			cache.get("ssss");
			return user;
		}
}