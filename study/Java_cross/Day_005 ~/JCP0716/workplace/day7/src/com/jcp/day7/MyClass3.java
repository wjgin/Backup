package com.jcp.day7;

public class MyClass3 {
	// 필드 선언
	String name;	// 참조 타입 변수
	int level;
	double[] point;	// 참조 타입 변수
	
	// 객체 생성 후 필드 값을 설정하는 메소드를 만들어 봅시다.(**)
	// name 필드 값 저장하기
	void setName(String name) {
		this.name = name;
	}
	
	// level 필드 값을 저장
	void setLevel(int level) {
		this.level = level;
	}
	
	// point 필드 값(참조 값) 저장
	void setPoint(double[] point) {
		this.point = point;
	}
	
}
