package com.jcp.day6;

public class MyClass2Test {

	public static void main(String[] args) {
		MyClass2 mc = new MyClass2();
		
		// mc객체의 메소드 실행
		mc.methodA("이이름");
		mc.methodB("이이름", 7);
		
		int result = mc.methodC();
		System.out.println("methodC 결과 : " + result);
		
		//  num1 필드에 값을 저장하는 방법
		//	1) mc.num1 = 값;
		//	2) 메소드로 저장
		
		mc.setNum1(123);
		mc.setNum2(456);
		result = mc.methodC();	// 인스턴스 메소드(객체 실행)
		System.out.println("mc.num1 = " + mc.num1 + "   mc.num2 = " + mc.num2);
		System.out.println("methodC 결과 : " + result);
	
		MyClass2.print();	//static 접근, 클래스 메소드
	}	

}
