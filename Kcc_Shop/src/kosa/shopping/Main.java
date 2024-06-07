package kosa.shopping;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ShopManager sm = new ShopManager();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----------------------------------------------------------------------");
			if(sm.getCurrentCust()==null) {
				System.out.println("000 쇼핑몰에 오신것을 환영합니다.");
			} else {
				System.out.println(sm.getCurrentCust().getName() + " 님 000 쇼핑몰에 오신것을 환영합니다.");
				System.out.println("-----------------------------------------------------------------------");
			}
			System.out.println("메뉴를 선택해주세요");
			System.out.println("1. 고객 등록 2.유저 선택 3. 상품 등록 4. 상품 카테고리 목록 보기 5. 상품 주문 6. 개별 주문 목록보기 7. 상품 찾기 8. 종료");
			String startMenu = sc.nextLine();
			switch (startMenu) {
			case "1":
				sm.addCustomer();
				break;
			case "2":
				sm.selectUser();
				break;
			case "3" :
				sm.addProduct();
				break;
			case "4" :
				sm.categoryList();
				break;
			}
			
		}
	}
}
