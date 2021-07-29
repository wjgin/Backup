package com.jcp.day9b;

public abstract class Animal {
	
	static final String TYPE = "동물";
	
	private String name;	// 회원 이름
	private String color;	// 동물 색깔
	private int age;
	
	public Animal() {
		//System.out.println("새로운 반려동물이 나타났다!");
	}
	
	public Animal(String color) {
		this();	// 기본 생성자 메소드 호출
		this.color = color;
	}
	
	// 추상메소드 (공통적인 기능)
	public abstract void sound();	// 동물의 소리

	// 인스턴스 메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public abstract String getType();
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
