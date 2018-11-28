package com.yuen.dao;

import org.hibernate.Session;

import com.yuen.db.HibernateUtil;
import com.yuen.domain.Order;

public class OrderDAOImpl implements OrderDAO {

	@Override
	public void create(Order order) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.persist(order);
		session.getTransaction().commit();
		session.close();
	}

}
