package com.jcp.day8;

// 필드에 private 접근 권한 = setXXX(setter), getXXX(getter) 메소드로 필드에 접근하는 클래스

public class User {
	
	private String name;
	private int age;

	
	public User() {}
	
	// 필드 초기화를 하는 커스텀 생성자 자동 생성
	// Source 탭 Generate constructor
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	// getter setter 자동생성
	// Source 탭 Generate getter setter
	public String getName() {	// name 필드의 리턴형식과 같은 리턴형식
		return name;
	}
	
	public void setName(String name) {	// name 필드와 형식이 같은 인자
		this.name = name;
	}
	
	public int getAge() {	// age 필드와 형식이 같은 리턴 형식
		return age;
	}
	
	public void setAge(int age) {	// age 필드와 같은 인자
		this.age = age;
	}
	
}
