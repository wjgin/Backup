package com.jcp.day6;

public class MyClass1Test {

	public static void main(String[] args) {
		// 정의한 MyClass1 클래스를 테스트합니다.

		// 1) MyClass1 객체 생성 : new 연산자
		// 식별자 my1, my2 : 프로그래머가 이름 정의
		// new 뒤MyClass1() 은 생성자 메소드.
		// ㄴ 객체가 생성될 떄(메모리 로드) 실행
		// ㄴ 생성자의 이름은 클래스의 이름과 같다.
		// ㄴ 기본 생성자는 인자가 없음
		MyClass1 my1 = new MyClass1();
		MyClass1 my2 = new MyClass1();

		// 2) MyClass2 타입의 객체 필드 접근(읽기 / 쓰기)
		// 객체 필드에 값 저장
		my2.field1 = "class test";
		my2.field2 = 999;
		my2.field3 = new double[5];	// 객체 생성
		System.out.println(my1.field1); // 참조 타입은 null
		System.out.println(my2.field1);
		System.out.println(my1.field2); // 수치 기본형 타입은 0
		System.out.println(my2.field2);
		System.out.println(my2.field3);	
		System.out.println(my2.field3[2]);	// 실수형은 길이 정의시 0.0 값으로 초기화, 정의하지 않으면 error(객체 미 생성 시)
		
		 System.out.println(my2.field1.length());
		 // System.out.println(my1.field1.length());	// my1이 null 객체이기 때문에 오류

		 // NullPointerException : 널 객체를 대상으로 데이터 접근, 메소드 실행시 오류
		 
		 // final 상수 테스트
		 // System.out.println(my1.field4);
		 // my2.field4 = 9999;	// final 상수는 값 변경 불가 에러
		 System.out.println(MyClass1.FIELD4);  // 공유영역에 저장된 필드. 클래스 이름으로 읽어옴
		 
		 // static final 예시
		 System.out.println(Byte.MAX_VALUE);
		 System.out.println(Integer.MAX_VALUE);
		 
		 MyClass1.field5 = 111;	// static 접근은 class이름으로 접근
		 System.out.println(MyClass1.field5);
		 
	}

}
