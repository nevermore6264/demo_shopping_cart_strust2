package com.yuen.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.yuen.dao.ProductDAO;
import com.yuen.dao.ProductDAOImpl;
import com.yuen.domain.Cart;
import com.yuen.domain.Item;
import com.yuen.domain.Product;

public class CartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	// URL parameter: product ID
	private int id;
	
	// URL parameter: new quantity
	private int quantity;
	
	private SessionMap<String, Object> session;
	
	public String view() throws Exception {
		Cart cart = (Cart) session.get("cart");
		
		if (cart == null || cart.getCount() == 0) {
            session.put("error", "Your cart is empty.");
            return "empty";
        } else {
        	return SUCCESS;
    	}
	}
	
	public String add() throws Exception {
		Cart cart = (Cart) session.get("cart");
		
		if (cart == null) {
    		cart = new Cart();
		}
		
		ProductDAO productDAO = new ProductDAOImpl();
		Product product = productDAO.findOne(id);
		if (product == null) {
			return ERROR;
		} else {
			cart.add(new Item(product, 1));
			session.put("cart", cart);
			return SUCCESS;
		}
	}
	
	public String update() throws Exception {
		Cart cart = (Cart) session.get("cart");
		
		if (cart == null || cart.getCount() == 0) {
            session.put("error", "Your cart is empty");
            return "empty";
        } else {
        	ProductDAO productDAO = new ProductDAOImpl();
    		Product product = productDAO.findOne(id);
    		if (product == null) {
    			return ERROR;
    		} else {
    			cart.update(new Item(product, quantity));
    			session.put("cart", cart);
    			session.put("success", "Update cart successfully.");
    			return SUCCESS;
    		}
        }
	}
	
	public String remove() throws Exception {
		Cart cart = (Cart) session.get("cart");
		
		if (cart == null || cart.getCount() == 0) { // Empty cart
            session.put("error", "Your cart is empty");
            return "empty";
        } else {
			ProductDAO productDAO = new ProductDAOImpl();
			Product product = productDAO.findOne(id);
			if (product == null) { // Product not found
				return ERROR;
			} else {
				cart.remove(id);
				session.put("cart", cart);
				return SUCCESS;
			}
        }
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		session = (SessionMap<String, Object>) map;
	}
	
}
