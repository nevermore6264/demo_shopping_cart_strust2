package com.yuen.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.CategoryDAO;
import com.yuen.dao.CategoryDAOImpl;
import com.yuen.domain.Category;

public class CategoryAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Category> categories;
	private Category category;
	
	// URL parameter: category ID
	private int id;
	
	@Override
	public String execute() throws Exception {
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		category = categoryDAO.findOne(id);
		
		if (category == null) {
			return ERROR;
		} else {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
