package com.yuen.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.UserDAO;
import com.yuen.dao.UserDAOImpl;
import com.yuen.domain.User;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	private SessionMap<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		UserDAO userDAO = new UserDAOImpl();
		User dbUser = userDAO.findOne(email, password);

		if (dbUser == null) {
			addActionError("Invalid email or password");
			return INPUT;
		} else {
			session.put("user", dbUser);
			session.put("success", "You have logged in successfully!");
			return SUCCESS;
		}
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

	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap<String, Object>) map;
	}
	
}
