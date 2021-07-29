package com.jcp.day8;

// shap 클래스로부터 상속 받는다. (extends)
public class Triangle extends Shape {
	// 자동으로 기본 생성자 동작 (부모 클래스에 기본 생성자가 없가면 불가능)

	static final int MAX_WIDTH = 90;	// 부모 클래스의 상수 변경 가능
	
	// 삼각형의 특징(직각 여부)
	// 삼갂형 자식 클래스에서 필요에 의해서 필드값 추가
	boolean rightAngle;	// default false
	
	public Triangle(String shapeName, int width, int height) {
		// 부모클래스, 부모클래스 생성자 호출
		super(shapeName, width, height);
	}

	// 삼각형 면적을 구하는 메소드로 getArea() 수정 -> 오버라이드
	// 부모클래스의 메스 동작을 자식 클래스가 수정
	// width, height는 private 이기 때문에 직접 접근 x => get 메소드 이용
	@Override	// 오버라이드라는 것을 알려주는 Annotaion
	int getArea() {
		return this.getWidth() * this.getHeight() / 2;
	}
	
	int getArea(int angle) {
		System.out.println("각도가 " + angle + "입니다.");
		return this.getWidth() * this.getHeight() / 2;
	}
	
	void printName() {
		System.out.println("삼각형 이름 : " + this.getShapeName());
	}
	
	/* final 메소드 오버라이드 불가능
	public final void print() {
		System.out.println("fianl 메소드 오버라이드");
	}
	*/
}
