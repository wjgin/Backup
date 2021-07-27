package com.jcp.day7;

public class MyClass5 {
	
	// 테스트 필드
	int num;
	int age;
	
	// 기본 생성자
	// 별도의 실행 코드가 없다면 생략 가능
	// 커스텀 생성자 생성시 기본 생성자 생략 불가능 -> 정의 필요
	public MyClass5() {}
	
	// 커스텀 생성자
	public MyClass5(int num, int age) {
		this.num = num;
		this.age = age;
	}
	
	
} // MyClass5 end
