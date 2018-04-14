/* 
 * Hibernate, Relational Persistence for Idiomatic Java
 * 
 * JBoss, Home of Professional Open Source
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This copyrighted material is made available to anyone wishing to use,
 * modify, copy, or redistribute it subject to the terms and conditions
 * of the GNU Lesser General Public License, v. 2.1.
 * This program is distributed in the hope that it will be useful, but WITHOUT A
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License,
 * v.2.1 along with this distribution; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA  02110-1301, USA.
 */
package lxk.hibernate.hibernateDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import lxk.hibernate.hibernateEntity.HibernateUser;


public abstract class HibernateBasicDao {
	/*使用Spring自动注入配置*/
	@Autowired
	private SessionFactory sessionFactory;
	/*使用hibernate.cfg.xml配置*/
//	protected HibernateBasicDao() {
//		final Configuration configuration = new Configuration().configure();
//		configuration.addAnnotatedClass( HibernateUser.class );
//		sessionFactory = configuration.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build());
//				
//				configuration.buildSessionFactory(
//				new StandardServiceRegistryBuilder().build() );
//	}
	
	protected Session openSession() {
		return sessionFactory.openSession();
	}
	
	public long persistData() {

		final HibernateUser user = new HibernateUser();
		user.setUserName( "Brett Meyer" );
		final Session s = openSession();
		s.getTransaction().begin();
		s.persist(user);
		s.getTransaction().commit();
		s.close();
	
		return user.getId();
	}
}
