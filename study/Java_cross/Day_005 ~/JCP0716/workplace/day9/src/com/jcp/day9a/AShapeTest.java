package com.jcp.day9a;

public class AShapeTest {
// AShape 추상클래스를 사용해봅시다.
	public static void main(String[] args) {
		// AShape ash = new AShape(); // 추상 클래스 new 연산 불가
	
		AShape tri = new ATriangle();
		AShape rec = new ARectangle();
		
		AShape tri2 = new ATriangle("작은직각 삼각형", 34, 27);
		System.out.println(tri2.getArea());
		
		AShape rec2 = new ARectangle("평행 사변형", 34, 27);
		System.out.println(rec2.getArea());
		
		System.out.println("print 메소드는 ASape 타입의 인자로 실행.");
		// 다형성 - 메소드의 인자가  AShape로 상위 타입 입니다.
		print(tri2);	// main이 static -> static 메소드만 호출 가능
		print(rec2);
		
	} // main end
	
	// main 밖에서 static 메소드 정의
	// 상위 클래스 타입을 인자로하는 메소드
	public static void print(AShape ash) {
		System.out.println("도형의 이름 : " + ash.getShapeName());
		System.out.println("면적 : " + ash.getArea());
	}

}
