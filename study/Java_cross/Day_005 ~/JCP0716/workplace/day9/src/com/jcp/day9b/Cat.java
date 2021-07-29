package com.jcp.day9b;

public class Cat extends Animal {

	static final String TYPE = "고양이";
	
	@Override
	public void sound() {
		System.out.println(this.getColor() + " 고양이😺는 야옹하고 소리를 냅니다.");
	}

	
	public String getType() {
		return TYPE;
	}

}
