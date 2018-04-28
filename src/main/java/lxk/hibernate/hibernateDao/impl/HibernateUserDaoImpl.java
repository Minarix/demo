package lxk.hibernate.hibernateDao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lxk.hibernate.hibernateDao.HibernateUserDao;
import lxk.hibernate.hibernateEntity.HibernateUser;


@Repository
public class HibernateUserDaoImpl implements HibernateUserDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public HibernateUser findByName(String name) {
		final Session s = sessionFactory.openSession();
		s.getTransaction().begin();
		final Query<HibernateUser> q = s.createQuery( "FROM HibernateUser WHERE userName = :name" );
		q.setParameter( "name", name );
		q.setCacheable( true );
		final HibernateUser user = q.uniqueResult();
		s.getTransaction().commit();
		return user;
	}


}