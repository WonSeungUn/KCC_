package kosa.shopping;

public class OrderItem {
	private int orderItemNum;
	private Product product;
	private Order order;
	private int orderPrice;
	private int count;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderItemNum, Product product, Order order, int orderPrice, int count) {
		this.orderItemNum = orderItemNum;
		this.product = product;
		this.order = order;
		this.orderPrice = orderPrice;
		this.count = count;
	}

	public int getOrderItemNum() {
		return orderItemNum;
	}

	public Product getProduct() {
		return product;
	}

	public Order getOrder() {
		return order;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public int getCount() {
		return count;
	}
	
	
	
}
