package com.jcp.day6;

// 클래스의 구성요소인 메소드에 대해서 정리합니다.
public class MyClass2 {

	// 필드선언. 전역변수
	int num1;
	int num2;

	// 매소드 형식
	// 리턴형식 메소드 이름(인자 형식과 개수 {실행할 코드...}

	// 1) void는 리턴 값이 없음. 2)인자는 String 타입 1개
	void methodA(String name) { // name은 지역변수 - methodA에서만 사용
		System.out.println("이름 : " + name);
	}

	void methodB(String name, int cnt) { // name은 지역변수 - methodA에서만 사용
		System.out.println("이름 : " + name + "  숫자  : " + cnt);
	}

	int methodC() {
		return num1 + num2;
	}

	void setNum1(int num1) {
		this.num1 = num1; // this는 지역변수와 전역변수를 구별하기 위한 키워드
							// ㄴ 자기자신 객체를 지정

	}

	void setNum2(int num2) {
		this.num2 = num2;
	}

	static void print() {
		System.out.println("MyClass2 입니다.");
		
		// 공유영역은 공유영역에 저장된 필드와 메소드만 사용 가능 (static)
		// System.out.println(this.num1);	// 불가
		// System.out.println(num2);		// 불가
		// methodC();						// 불가
		// test();							// 불가
	}
	
	static void testMethod() {
		System.out.println("테스트 중 입니다.");
	}
	
}
