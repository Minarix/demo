package lxk.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lxk.entity.User;
import lxk.service.UserService;

@Controller
@RequestMapping("/user")
public class RESTfulJSONController {
	@Autowired
	private UserService userService;

	// 访问路径 http://localhost:8080/portal/user/view/long
	/** Spring MVC RESTful JSON **/
	@RequestMapping(value = "/view/{userName}", method = RequestMethod.GET)
	@ResponseBody
	public User view(@PathVariable String userName) {

		User user = userService.getUserByUserName(userName);
		return user;
	}

	// 访问路径 http://localhost:8080/portal/user/query?username=long
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

}