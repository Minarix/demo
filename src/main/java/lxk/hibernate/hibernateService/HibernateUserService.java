package lxk.hibernate.hibernateService;

import lxk.hibernate.hibernateEntity.HibernateUser;

public interface HibernateUserService {


	public HibernateUser findByName(String name);


}