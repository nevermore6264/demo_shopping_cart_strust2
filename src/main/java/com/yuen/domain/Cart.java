package com.yuen.domain;

import java.io.Serializable;
import java.util.ArrayList;

public class Cart implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int LIMIT_ITEMS = 10;
	
	private ArrayList<Item> items;

	public Cart() {
        items = new ArrayList<>();
    }
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void add(Item item) {
		for (Item e : items) {
			if (e.getProduct().getId() == item.getProduct().getId()) {
				if (e.getQuantity() + item.getQuantity() <= LIMIT_ITEMS) {
					e.setQuantity(e.getQuantity() + item.getQuantity());
				} else {
					e.setQuantity(LIMIT_ITEMS);
				}
				return;
			}
		}
		items.add(item);
	}
	
	public void update(Item item) {
		if (item.getQuantity() == 0) {
			remove(item.getProduct().getId());
		} else {
			for (Item e : items) {
				if (e.getProduct().getId() == item.getProduct().getId()) {
					if (item.getQuantity() <= LIMIT_ITEMS) {
						e.setQuantity(item.getQuantity());
					} else {
						e.setQuantity(LIMIT_ITEMS);
					}
					return;
				}
			}
		}
	}
	
	public void remove(int id) {
		for (Item e : items) {
			if (e.getProduct().getId() == id) {
				items.remove(e);
				return;
			}
		}
	}
	
	public int getCount() {
		return items.size();
	}
	
	public int getTotal() {
		int total = 0;
		for (Item e : items) {
			total += e.getSubTotal();
		}
		return total;
	}
	
}