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
	
	// 상품 리스트 나열
	public void productShow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String reg = sdf.format(this.reg); 
		System.out.println();
		System.out.println("-------------------------------------");
		System.out.println("상품이름 : " +productName);
		System.out.println("상품가격 : " +price);
		System.out.println("등록날짜 : " +reg);
		System.out.println("남은 수량 : " +totalCount);
		System.out.println("-------------------------------------");
	} // 상품 리스트 나열 end

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
