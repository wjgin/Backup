package com.jcp.day9b;

public class Puppy extends Animal {

	static final String TYPE = "강아지";
	
	public Puppy() {
		// TODO Auto-generated constructor stub
	}
	
	public Puppy(String color) {
		// 상위 클래스의 커스텀 생성자 상속
		super(color);
	}
	
	@Override
	public void sound() {
		System.out.println(this.getColor() + " 강아지🐶 멍멍하고 짖습니다.");
	}

	public String getType() {
		return TYPE;
	}

}
