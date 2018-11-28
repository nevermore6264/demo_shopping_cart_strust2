package com.yuen.dao;

import org.hibernate.Session;

import com.yuen.db.HibernateUtil;
import com.yuen.domain.Item;

public class ItemDAOImpl implements ItemDAO {

	@Override
	public void create(Item item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.persist(item);
		session.getTransaction().commit();
		session.close();
	}

}
