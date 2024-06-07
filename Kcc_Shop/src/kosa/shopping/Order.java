package kosa.shopping;

import java.util.List;

public class Order {
	private int orderNum;
	private List<OrderItem> items;
	private Customer customer;
	
	public Order() {
		
	}

	public Order(int orderNum, List<OrderItem> items, Customer customer) {
		this.orderNum = orderNum;
		this.items = items;
		this.customer = customer;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public List<OrderItem> getItems() {
		return items;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	
	
	
}
