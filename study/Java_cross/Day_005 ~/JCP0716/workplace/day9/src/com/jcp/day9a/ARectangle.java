package com.jcp.day9a;

public class ARectangle extends AShape {
	
	// 기본 생성자, 커스텀 생성자 정의
	public ARectangle() {}
	
	public ARectangle(String shapeName, int width, int height) {
		// 부모생성자 호출
		super(shapeName, width, height);
	}
	
	@Override
	public int getArea() {
		int result = this.getHeight() * this.getWidth();
		return result;
	}

}
