package com.jcp.day9b;


public class Rabbit extends Animal {
	
	static final String TYPE = "토끼";
	
	@Override
	public void sound() {
		System.out.println(this.getColor() + " 토끼🐇는 조용합니다.");
	}


	public String getType() {
		return TYPE;
	}
	
}
