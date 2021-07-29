package com.jcp.day9a;

public class ATriangle extends AShape {
	
	// 기본 생성자
	public ATriangle() {
	}
	
	public ATriangle(String shapeName, int width, int heigtht) {
		// 부모 생성자 호출
		super(shapeName, width, heigtht);
	}
	
	// 추상메소드는 반드시 정의해줘야함
	// implements(구현) : 정의가 되지 않은 메소드를 구현
	@Override
	public int getArea() {
		int result = this.getHeight() * this.getWidth() / 2;
		return result;
	}
}
