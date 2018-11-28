package com.yuen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.CategoryDAO;
import com.yuen.dao.CategoryDAOImpl;
import com.yuen.dao.ProductDAO;
import com.yuen.dao.ProductDAOImpl;
import com.yuen.domain.Category;
import com.yuen.domain.Product;

public class SearchAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String q;
	private List<Category> categories;
	private List<Product> products;
	
	@Override
	public String execute() throws Exception {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		categories = categoryDAO.findAll();
		
		ProductDAO productDAO = new ProductDAOImpl();
		products = productDAO.search(q);
		
		return SUCCESS;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}
	
}
