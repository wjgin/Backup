package com.jcp.day8a;

/*
 * 접근 제어(접근 권한)
 * public : 모든 클래스에서 사용 가능
 * private : 현재 클래스에서만 사용가능
 * default : 같은 패키지이면 사용 가능, 다른 패키지 접근 금지
 */

public class User3 {
	// 테스트 필드
	// 다른 클래스에서 필드에 직접 접근하지 못하도록 사용 됨.
	// 일반적으로 setXXX 등의 필드 생성자 메소드를 만들어서 사용함
	// 주로 필드 영역 혹은 메소드에서만 사용
	private String name;
	private int age;

	public User3() {
		// 생성자 : 접근 제어자 default
	}
	
}
