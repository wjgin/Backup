package com.jcp.day8a;

/*
 * 접근 제어(접근 권한)
 * public : 모든 클래스에서 사용 가능
 * private : 현재 클래스에서만 사용가능
 * default : 같은 패키지이면 사용 가능, 다른 패키지 접근 금지
 */

public class User1 {
	// 테스트 필드
	String name;
	int age;
	
	public static int st;
	
	User1() {
		// 생성자 : 접근 제어자 default
	}
	
}
