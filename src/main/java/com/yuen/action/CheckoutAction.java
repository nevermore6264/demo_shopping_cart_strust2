package com.yuen.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.ItemDAO;
import com.yuen.dao.ItemDAOImpl;
import com.yuen.dao.OrderDAO;
import com.yuen.dao.OrderDAOImpl;
import com.yuen.domain.Cart;
import com.yuen.domain.Item;
import com.yuen.domain.Order;
import com.yuen.domain.User;

public class CheckoutAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String firstname;
	private String lastname;
	private String address;
	private String phone;
	private String email;
	
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		User user = (User) session.get("user");
		
		if (cart == null) {
			session.put("error", "Your cart is empty.");
			return ERROR;
		} else if (user == null) {
			session.put("error", "Please login to checkout.");
			return ERROR;
		} else {
			// Save order
			OrderDAO orderDAO = new OrderDAOImpl();
			Order order = new Order(firstname, lastname, address, phone, email, new Date(), user);
			orderDAO.create(order);
			
			// Save items
			ItemDAO itemDAO = new ItemDAOImpl();
			ArrayList<Item> items = cart.getItems();
			for (Item item : items) {
				item.setOrder(order);
				item.setPrice(item.getProduct().getRegular());
				itemDAO.create(item);
			}
			
			session.remove("cart");
			session.put("success", "Order successfully! We will contact you as soon as possible.");
			
			return SUCCESS;
		}
	}

	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
