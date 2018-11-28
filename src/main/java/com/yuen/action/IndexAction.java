package com.yuen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.CategoryDAO;
import com.yuen.dao.CategoryDAOImpl;
import com.yuen.dao.ProductDAO;
import com.yuen.dao.ProductDAOImpl;
import com.yuen.domain.Category;
import com.yuen.domain.Product;

public class IndexAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Category> categories;
	private List<Product> products;
	
	@Override
	public String execute() throws Exception {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		ProductDAO productDAO = new ProductDAOImpl();
		categories = categoryDAO.findAll();
		products = productDAO.findAll(9);
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
	
}