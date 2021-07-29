package com.jcp.day8;

// 클래스의 상속(다 형성)
// shape 클래스는 추장적인 상태 (구체적인 모양 없음)
//    						ㄴ 구체화된 도형 클래스 : 삼각형, 사각형, 사다리꼴 ...
// 	ㄴ 상속하는 부모 클래스는 기본생성자가 동작해야함 
//	ㄴ 기본 생성자가 없을 경우 자식 클래스는 부모클래스의 커스텀 생성자를 직접 실행해야함
public class Shape {
	
	static final int MAX_WIDTH = 100;
	
	// 필드 private 접근
	private String shapeName;
	private int width;			// 도형의 너비
	private int height;			// 도형의 높이
	
	// protected : default(같은 패키지 내에서  접근 가능) / 상속한 자식 클래스 접근 가능(다른 패키지에서도)
	/*
	protected String shapeName;
	protected int width;			// 도형의 너비
	protected int height;			// 도형의 높이
	*/
	
	//public Shape() {}	
	
	// 1) 필드값 3개 초기화 하는 생성자
	public Shape(String shapeName, int width, int height) {
		this.shapeName = shapeName;
		this.width = width;
		this.height = height;
	}
	
	// 2) 필드값 3개를 가져올 수 있는 메소드 getXXX
	String getShapeName() {
		return shapeName;
	}
	int getWidth() {
		return width;
	}
	int getHeight() {
		return height;
	}
	
	// 3) setXXX 메소드는 없음 -> 초기값을 변경할 수 없음(요구 조건이 있다면)
	
	// 4) 도형의 면적을 구하는 메소드 (계산식 : 너비 x 높이)
	int getArea() {
		return width * height;
	}
	
	// 오버라이드할 수 없는 메소드 final
	public final void print() {
		System.out.println("오버라이드할 수 없는 메소드 입니다.");
	}
	
}
