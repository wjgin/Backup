package com.jcp.day8;

// 다형성을 확인하는 테스트
public class ShapeTest3 {

	public static void main(String[] args) {
		// 객체 참조 타입이 자기 자신이 아니라 부모(상위)클래스 타입
		// 상위 객체를 참조 타입으로 생성하면 하위 객체의 생성자는 사용 불가능
		Shape sh1 = new Triangle("작은 삼각형", 1, 2);
		Shape sh2 = new Rectangle("작은 사각형", 2, 2);
		
		
		// sh1, sh2 가 Shape 타입이지만, 실제 객체는 자식 클래스 객체(다형성)
		System.out.println(sh1.getArea());	// getArea 오버라이딩 됨.
		System.out.println(sh2.getArea());
		
		//자식 클래스로 타입으로 캐스팅 => (부모 클래스에는 없는)자식 클래스의 필드, 메소드 사용 가능
		Triangle tr = (Triangle)sh1;
		System.out.println("sh1은 직삼각형 ? " + tr.rightAngle);
		
		// 하위 클래스를 모두 Shape 배열에 저장 가능
	}

}
