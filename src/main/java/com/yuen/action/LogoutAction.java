package com.yuen.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	private SessionMap<String, Object> session;
	
	@Override
	public String execute() throws Exception {
		session.invalidate();
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap<String, Object>) map;
	}
}
