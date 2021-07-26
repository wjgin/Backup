package com.jcp.day6;

public class MyClass1 {
	// 이 클래스는 객체를 생성할 때 사용할 원본(정의)
	// 구성요소 : 필드, 메소드
	
	// 필드 선언
	String field1;		// 참조 타입은 null으로 초기화
	int field2;			// 수치 기본형은 0으로 초기화
	double[] field3;	// 배열의 경우 참조 타입이므로 선언만한 상태
						// 객체 생성은 되지 않음.
	
	// 클래스 안에서 선언된 변수는 전역변수(사용범위)
	// 전역 변수는 기본 값으로 초기화 됨
	
	// 상수: 값을 바꿀수 없는 상태의 데이터(리터럴 상수, 기호상수)
	
	// final int field4 = 999;	// final : 값을 변경할 수 없음 -> 반드시 초기화 필요
	// 상수는 모든 객체가 같은 값이므로 공유영역(static)에 한번만 저장(효율성, 객체 생성시마다 메모리 차지 x)
	// 클래스 이름으로 접근, 식별자를 대문자
	// 클래스의 성질을 나타내는 고정된 값(final)
	static final int FIELD4 = 999;
	
	// static : class에 속하고 공유영역에 저장
	// final : 변경할 수 없는 변수
	// static final : 자바의 상수 선언
	
	static int field5;
}
