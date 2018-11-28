package com.yuen.dao;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.yuen.db.HibernateUtil;
import com.yuen.domain.User;

public class UserDAOImpl implements UserDAO {
	
	@Override
	public User findOne(String email, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from User u " +
					 "where u.email = :email " +
					 "and u.password = :password";
		
		User user;
		try {
			user = (User) session.createQuery(hql)
							.setParameter("email", email)
							.setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}

		session.getTransaction().commit();
		session.close();
		return user;
	}
	
	
	@Override
	public void create(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public User findOne(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from User u " +
			 		 "where u.email = :email";
	
		User user;
		try {
			user = (User) session.createQuery(hql).setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}
	
		session.getTransaction().commit();
		session.close();
		return user;
	}

}
