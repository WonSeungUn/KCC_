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


	// ���� ��� �޼ҵ�
	public void addCustomer() {
			System.out.println("���� ����� �����ϼ̽��ϴ�.");
			System.out.println("�������� �̸��� �Է����ּ���");
			String name = sc.nextLine();
			System.out.println("�������� ���̸� �Է����ּ���");
			int age = Integer.parseInt(sc.nextLine());
			String pattern = "yyyy/MM/dd";
			DateFormat df = new SimpleDateFormat(pattern);
			Scanner sc = new Scanner(System.in);
			System.out.println("�������� ��������� �Է����ּ���. �� ��������� ��� yyyy/MM/dd �������� �Է����ּ���.");
			Date birth = null;

			while (sc.hasNextLine()) {
				try {
					birth = df.parse(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("�ٽ� �Է��ϼ���");
				}
			}
			System.out.println("�������� ���ο� ID�� �Է����ּ���");
			String id = sc.nextLine();
			System.out.println("�������� ������ �Է����ּ���");
			String sex = sc.nextLine();
			if (!(sex.equals("��") || sex.equals("��"))) {
				System.out.println("�ٽ� �Է����ּ���");
				return;
			}
			customers.add(new Customer(name, age, birth, id, sex));
	} // ���� ��� �޼ҵ� end
	
	// ���� ���� �޼ҵ�
	public void selectUser() {
		System.out.println("���� ������ �����̽��ϴ�.");
		for(int i = 0 ; i <customers.size() ; i++) {
			System.out.print(i+1 + "." + customers.get(i).getName() + "\t" +"\n");
		}
		System.out.println("� ������ �����Ͻðڽ��ϱ�?");
		String select = sc.nextLine();
		for(int i =0; i <customers.size() ; i++) {
			this.currentCust = customers.get(Integer.parseInt(select)-1);
		}
		System.out.println(customers.get(Integer.parseInt(select)-1).getName() + "������ �����ϼ̽��ϴ�.");
		
	} // ���� ���� �޼ҵ� end

	// ��ǰ ���
	public void addProduct() {
		System.out.println("��ǰ ����� �����ϼ̽��ϴ�.");
		System.out.println("��ǰ�� ī�װ����� �������ּ���");
		System.out.println("1. �Ƿ� 2. ���ڱ�� 3. ��Ƽ 4. �ֹ��ǰ");
		String select = sc.nextLine();
		Calendar gc = Calendar.getInstance();
		switch (select) {
		case "1":
			System.out.println("�Ƿ� ��ǰ�� �̸��� �Է����ּ���.");
			String cName = sc.nextLine();
			System.out.println(cName + " �� ������ �Է����ּ���");
			int cPrice = Integer.parseInt(sc.nextLine());
			System.out.println(cName + " �� ������ �Է����ּ���");
			int cTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(cName, cPrice, gc.getTime(), new Category("�Ƿ�"), cTotalCount));
			System.out.println(cName + " ��ǰ�� �Ƿ� ī�װ����� ��ϵǾ����ϴ�.");
			break;
		case "2":
			System.out.println("���ڱ�� ��ǰ�� �̸��� �Է����ּ���.");
			String eName = sc.nextLine();
			System.out.println(eName + " �� ������ �Է����ּ���");
			int ePrice = Integer.parseInt(sc.nextLine());
			System.out.println(eName + " �� ������ �Է����ּ���");
			int eTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(eName, ePrice, gc.getTime(), new Category("���ڱ��"), eTotalCount));
			System.out.println(eName + " ��ǰ�� ���ڱ�� ī�װ����� ��ϵǾ����ϴ�.");
			break;
		case "3":
			System.out.println("��Ƽ ��ǰ�� �̸��� �Է����ּ���.");
			String bName = sc.nextLine();
			System.out.println(bName + " �� ������ �Է����ּ���");
			int bPrice = Integer.parseInt(sc.nextLine());
			System.out.println(bName + " �� ������ �Է����ּ���");
			int bTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(bName, bPrice, gc.getTime(), new Category("��Ƽ"), bTotalCount));
			System.out.println(bName + " ��ǰ�� ��Ƽ ī�װ����� ��ϵǾ����ϴ�.");
			break;
		case "4":
			System.out.println("�ֹ��ǰ ��ǰ�� �̸��� �Է����ּ���.");
			String kName = sc.nextLine();
			System.out.println(kName + " �� ������ �Է����ּ���");
			int kPrice = Integer.parseInt(sc.nextLine());
			System.out.println(kName + " �� ������ �Է����ּ���");
			int kTotalCount = Integer.parseInt(sc.nextLine());
			
			products.add(new Product(kName, kPrice, gc.getTime(), new Category("�ֹ��ǰ"), kTotalCount));
			System.out.println(kName + " ��ǰ�� �ֹ��ǰ ī�װ����� ��ϵǾ����ϴ�.");
			break;
		}
		
	} //  ��ǰ ��� �޼ҵ� end
	

	// ��ǰ ī�װ��� ��� ���� �޼ҵ�
	public void categoryList() {
		System.out.println("��ǰ ī�װ��� ��� ���⸦ �����ϼ̽��ϴ�.");
		System.out.println("� ī�װ��� ����� ���ðڽ��ϱ�?");
		System.out.println("1. �Ƿ� 2. ���ڱ�� 3. ��Ƽ 4. �ֹ��ǰ");
		String select = sc.nextLine();
		switch (select) {
		case "1":
			Iterator<Product> cIter = products.iterator();
			while(cIter.hasNext()) {
				Product c = cIter.next();
				if(c.getCategory().getCategoryName().equals("�Ƿ�")) {
					c.productShow();
				}
			}
			break;
		case "2":
			Iterator<Product> eIter = products.iterator();
			while(eIter.hasNext()) {
				Product e = eIter.next();
				if(e.getCategory().getCategoryName().equals("���ڱ��")) {
					e.productShow();
				}
			}
			break;
		case "3":
			Iterator<Product> bIter = products.iterator();
			while(bIter.hasNext()) {
				Product b = bIter.next();
				if(b.getCategory().getCategoryName().equals("��Ƽ")) {
					b.productShow();
				}
			}
			break;
		case "4":
			Iterator<Product> kIter = products.iterator();
			while(kIter.hasNext()) {
				Product k = kIter.next();
				if(k.getCategory().getCategoryName().equals("�ֹ��ǰ")) {
					k.productShow();
				}
			}
			break;

		}
		
	} // ��ǰ ī�װ��� ��� �޼ҵ� end
	
	
	public Customer getCurrentCust() {
		return currentCust;
	}

	
}