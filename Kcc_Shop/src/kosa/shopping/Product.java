package kosa.shopping;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private String productName;
	private int price;
	private Date reg;
	private Category category;
	private int totalCount;
	
	public Product() {
		
	}

	public Product(String productName, int price, Date reg, Category category, int totalCount) {
		this.productName = productName;
		this.price = price;
		this.reg = reg;
		this.category = category;
		this.totalCount = totalCount;
	}
	
	// ��ǰ ����Ʈ ����
	public void productShow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reg = sdf.format(this.reg); 
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("��ǰ�̸� : " +productName);
		System.out.println("��ǰ���� : " +price);
		System.out.println("��ϳ�¥ : " +reg);
		System.out.println("���� ���� : " +totalCount);
		System.out.println("-------------------------------------");
	} // ��ǰ ����Ʈ ���� end

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getProductName() {
		return productName;
	}

	public int getPrice() {
		return price;
	}

	public Date getReg() {
		return reg;
	}

	public Category getCategory() {
		return category;
	}
	
	
	
}