package com.yuen.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Query;
import org.hibernate.Session;

import com.yuen.db.HibernateUtil;
import com.yuen.domain.Product;

public class ProductDAOImpl implements ProductDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAll(int max) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from Product p " +
					 "order by p.id desc";
		
		Query products =  session.createQuery(hql).setMaxResults(max);
		List<Product> productList = products.list();
		session.getTransaction().commit();
		//session.close();
		return productList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> search(String q) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "from Product p " +
					 "where p.name like :q";
		
		List<Product> products = session.createQuery(hql)
									.setParameter("q", "%" + q + "%").list();
		
		session.getTransaction().commit();
		session.close();
		return products;
	}
	
	@Override
	public Product findOne(int id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "select p " +
				 	 "from Product p " +
				 	 "left join fetch p.category " +
				 	 "where p.id = :id";
	
		Product product;
		try {
			product = (Product) session.createQuery(hql).setParameter("id", id);
		} catch (NoResultException e) {
			product = null;
		}
		
		session.getTransaction().commit();
		session.close();
		return product;
	}

}
