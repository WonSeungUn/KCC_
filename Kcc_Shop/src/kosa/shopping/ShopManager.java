package kosa.shopping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShopManager {
	private List<Order> orders;
	private List<Customer> customers;
	private Customer currentCust;
	private List<Product> products;
	private Scanner sc;

	public ShopManager() {
		sc = new Scanner(System.in);
		customers = new ArrayList<Customer>();
		products = new ArrayList<Product>();
	}
	

	public ShopManager(Customer currentCust) {
		this.currentCust = currentCust;
	}


	// 고객 등록 메소드
	public void addCustomer() {
			System.out.println("고객 등록을 선택하셨습니다.");
			System.out.println("고객님의 이름을 입력해주세요");
			String name = sc.nextLine();
			System.out.println("고객님의 나이를 입력해주세요");
			int age = Integer.parseInt(sc.nextLine());
			String pattern = "yyyy/MM/dd";
			DateFormat df = new SimpleDateFormat(pattern);
			Scanner sc = new Scanner(System.in);
			System.out.println("고객님의 생년월일을 입력해주세요. 단 생년월일의 경우 yyyy/MM/dd 형식으로 입력해주세요.");
			Date birth = null;

			while (sc.hasNextLine()) {
				try {
					birth = df.parse(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("다시 입력하세요");
				}
			}
			System.out.println("고객님의 새로운 ID를 입력해주세요");
			String id = sc.nextLine();
			System.out.println("고객님의 성별을 입력해주세요");
			String sex = sc.nextLine();
			if (!(sex.equals("남") || sex.equals("여"))) {
				System.out.println("다시 입력해주세요");
				return;
			}
			customers.add(new Customer(name, age, birth, id, sex));
	} // 고객 등록 메소드 end
	
	// 유저 선택 메소드
	public void selectUser() {
		System.out.println("유저 선택을 고르셨습니다.");
		for(int i = 0 ; i <customers.size() ; i++) {
			System.out.print(i+1 + "." + customers.get(i).getName() + "\t" +"\n");
		}
		System.out.println("어떤 유저로 선택하시겠습니까?");
		String select = sc.nextLine();
		for(int i =0; i <customers.size() ; i++) {
			this.currentCust = customers.get(Integer.parseInt(select)-1);
		}
		System.out.println(customers.get(Integer.parseInt(select)-1).getName() + "님으로 선택하셨습니다.");
		
	} // 유저 선택 메소드 end

	// 상품 등록
	public void addProduct() {
		System.out.println("상품 등록을 선택하셨습니다.");
		System.out.println("상품의 카테고리를 선택해주세요");
		System.out.println("1. 의류 2. 전자기기 3. 뷰티 4. 주방용품");
		String select = sc.nextLine();
		Calendar gc = Calendar.getInstance();
		switch (select) {
		case "1":
			System.out.println("의류 제품의 이름을 입력해주세요.");
			String cName = sc.nextLine();
			System.out.println(cName + " 의 가격을 입력해주세요");
			int cPrice = Integer.parseInt(sc.nextLine());
			System.out.println(cName + " 의 수량을 입력해주세요");
			int cTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(cName, cPrice, gc.getTime(), new Category("의류"), cTotalCount));
			System.out.println(cName + " 상품이 의류 카테고리에 등록되었습니다.");
			break;
		case "2":
			System.out.println("전자기기 제품의 이름을 입력해주세요.");
			String eName = sc.nextLine();
			System.out.println(eName + " 의 가격을 입력해주세요");
			int ePrice = Integer.parseInt(sc.nextLine());
			System.out.println(eName + " 의 수량을 입력해주세요");
			int eTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(eName, ePrice, gc.getTime(), new Category("전자기기"), eTotalCount));
			System.out.println(eName + " 상품이 전자기기 카테고리에 등록되었습니다.");
			break;
		case "3":
			System.out.println("뷰티 제품의 이름을 입력해주세요.");
			String bName = sc.nextLine();
			System.out.println(bName + " 의 가격을 입력해주세요");
			int bPrice = Integer.parseInt(sc.nextLine());
			System.out.println(bName + " 의 수량을 입력해주세요");
			int bTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(bName, bPrice, gc.getTime(), new Category("뷰티"), bTotalCount));
			System.out.println(bName + " 상품이 뷰티 카테고리에 등록되었습니다.");
			break;
		case "4":
			System.out.println("주방용품 제품의 이름을 입력해주세요.");
			String kName = sc.nextLine();
			System.out.println(kName + " 의 가격을 입력해주세요");
			int kPrice = Integer.parseInt(sc.nextLine());
			System.out.println(kName + " 의 수량을 입력해주세요");
			int kTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(kName, kPrice, gc.getTime(), new Category("주방용품"), kTotalCount));
			System.out.println(kName + " 상품이 주방용품 카테고리에 등록되었습니다.");
			break;
		}
		
	} //  상품 등록 메소드 end
	

	// 상품 카테고리 목록 보기 메소드
	public void categoryList() {
		System.out.println("상품 카테고리 목록 보기를 선택하셨습니다.");
		System.out.println("어떤 카테고리 목록을 보시겠습니까?");
		System.out.println("1. 의류 2. 전자기기 3. 뷰티 4. 주방용품");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			Iterator<Product> cIter = products.iterator();
			while(cIter.hasNext()) {
				Product c = cIter.next();
				if(c.getCategory().getCategoryName().equals("의류")) {
					c.productShow();
				}
			}
			break;
		case "2":
			Iterator<Product> eIter = products.iterator();
			while(eIter.hasNext()) {
				Product e = eIter.next();
				if(e.getCategory().getCategoryName().equals("전자기기")) {
					e.productShow();
				}
			}
			break;
		case "3":
			Iterator<Product> bIter = products.iterator();
			while(bIter.hasNext()) {
				Product b = bIter.next();
				if(b.getCategory().getCategoryName().equals("뷰티")) {
					b.productShow();
				}
			}
			break;
		case "4":
			Iterator<Product> kIter = products.iterator();
			while(kIter.hasNext()) {
				Product k = kIter.next();
				if(k.getCategory().getCategoryName().equals("주방용품")) {
					k.productShow();
				}
			}
			break;

		}
		
	} // 상품 카테고리 목록 메소드 end
	
	
	public Customer getCurrentCust() {
		return currentCust;
	}

	
}
