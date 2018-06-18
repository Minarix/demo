package lxk.hibernate.hibernateService.impl;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lxk.hibernate.hibernateService.HibernateUserService;
import lxk.hibernate.hibernateDao.HibernateUserDao;
import lxk.hibernate.hibernateEntity.HibernateUser;




@Service
@Transactional
public class HibernateUserServiceImpl implements HibernateUserService {
	@Transactional(readOnly = true)
	public HibernateUser findByName(String name){
		return dao.findByName(name);
	}
	
	@Resource
	private HibernateUserDao dao;



}