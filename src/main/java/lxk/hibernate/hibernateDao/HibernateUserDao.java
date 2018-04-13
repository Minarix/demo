package lxk.hibernate.hibernateDao;

import lxk.hibernate.hibernateEntity.HibernateUser;

public interface HibernateUserDao {
	public HibernateUser findByName(String name);


}