package com.yuen.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.UserDAO;
import com.yuen.dao.UserDAOImpl;
import com.yuen.domain.User;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String password;
	private String confirmPassword;
	
	public String execute() {
		UserDAO userDAO = new UserDAOImpl();
		
		if (userDAO.findOne(email) != null) {
			addFieldError("email", "Email already exists");
			return INPUT;
		} else {
			userDAO.create(new User(name, email, password));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("success", "You registered successfully!");
			return SUCCESS;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

}
