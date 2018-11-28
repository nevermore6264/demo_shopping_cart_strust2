package com.yuen.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yuen.db.HibernateUtil;
import com.yuen.domain.Category;

public class CategoryDAOImpl implements CategoryDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from Category";
		
		Query categories = session.createQuery(hql);
		List<Category> categoryList = categories.list();
		
		session.getTransaction().commit();
//		session.close();
		return categoryList;
	}
	
	@Override
	public Category findOne(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		String hql = "select c " +
					 "from Category c " +
					 "left join fetch c.products " +
					 "where c.id = :id";
		
		Category category;
		try {
			category = (Category) session.createQuery(hql).setParameter("id", id);
		} catch (NoResultException e) {
			category = null;
		}
		
		session.getTransaction().commit();
		session.close();
		return category;
	}

}
