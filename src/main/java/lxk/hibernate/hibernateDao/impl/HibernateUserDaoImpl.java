package lxk.hibernate.hibernateDao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import lxk.hibernate.hibernateDao.HibernateBasicDao;
import lxk.hibernate.hibernateDao.HibernateUserDao;
import lxk.hibernate.hibernateEntity.HibernateUser;



@Repository("hibernateUserDao")
public class HibernateUserDaoImpl extends HibernateBasicDao implements HibernateUserDao {
	

	public HibernateUser findByName(String name) {
		final Session s = openSession();
		s.getTransaction().begin();
		final Query q = s.createQuery( "FROM HibernateUser WHERE userName = :name" );
		q.setParameter( "name", name );
		q.setCacheable( true );
		final HibernateUser user = (HibernateUser) q.uniqueResult();
		s.getTransaction().commit();
		return user;
	}


}