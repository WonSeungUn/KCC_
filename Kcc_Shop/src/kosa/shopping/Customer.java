package kosa.shopping;

import java.util.Date;

public class Customer {
	private String name;
	private int age;
	private Date birth;
	private String id;
	private String sex;
	
	public Customer() {
		
	}
	

	public Customer(String name, int age, Date birth, String id, String sex) {
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.id = id;
		this.sex = sex;
	}



	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getBirth() {
		return birth;
	}

	public String getId() {
		return id;
	}

	public String getSex() {
		return sex;
	}
	
	
}
