package com.jcp.day8;

public class UserTest {

	public static void main(String[] args) {
		
		User sana = new User();
		User mina = new User("미나", 23);
		
		sana.setName("사나");
		sana.setAge(20);
		
		System.out.println(sana.getName() + "(" + sana.getAge() + ")");
		
	}

} 
