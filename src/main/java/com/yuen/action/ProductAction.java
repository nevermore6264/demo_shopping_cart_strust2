package com.yuen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.CategoryDAO;
import com.yuen.dao.CategoryDAOImpl;
import com.yuen.dao.ProductDAO;
import com.yuen.dao.ProductDAOImpl;
import com.yuen.domain.Category;
import com.yuen.domain.Product;

public class ProductAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
		
	private List<Category> categories;
	private Product product;
	
	// URL parameter: product ID
	private int id;
	
	public String execute() {
		ProductDAO productDAO = new ProductDAOImpl();
		product = productDAO.findOne(id);
		
		if (product == null) {
			return ERROR;
		} else {
			CategoryDAO categoryDAO = new CategoryDAOImpl();
			categories = categoryDAO.findAll();
			return SUCCESS;
		}
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}	
