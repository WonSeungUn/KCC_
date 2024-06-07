package kosa.shopping;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ShopManager sm = new ShopManager();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("-----------------------------------------------------------------------");
			if(sm.getCurrentCust()==null) {
				System.out.println("000 ���θ��� ���Ű��� ȯ���մϴ�.");
			} else {
				System.out.println(sm.getCurrentCust().getName() + " �� 000 ���θ��� ���Ű��� ȯ���մϴ�.");
				System.out.println("-----------------------------------------------------------------------");
			}
			System.out.println("�޴��� �������ּ���");
			System.out.println("1. ���� ��� 2.���� ���� 3. ��ǰ ��� 4. ��ǰ ī�װ��� ��� ���� 5. ��ǰ �ֹ� 6. ���� �ֹ� ��Ϻ��� 7. ��ǰ ã�� 8. ����");
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