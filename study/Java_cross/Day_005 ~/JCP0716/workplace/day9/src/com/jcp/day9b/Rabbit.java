package com.jcp.day9b;


public class Rabbit extends Animal {
	
	static final String TYPE = "ν λΌ";
	
	@Override
	public void sound() {
		System.out.println(this.getColor() + " ν λΌπλ μ‘°μ©ν©λλ€.");
	}


	public String getType() {
		return TYPE;
	}
	
}
