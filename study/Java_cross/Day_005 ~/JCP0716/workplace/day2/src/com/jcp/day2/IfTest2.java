package com.jcp.day2;

public class IfTest2 {

	public static void main(String[] args) {
		// 논리 연산 포함하는 조건
		int intValue = 51;
		
		
		char ch = (char)intValue;
		
		// inValue에 저장된 코드 값이 대문자, 소문자, 숫자 인지 검사하는 if문
		// 문자의 종류 알아내기
		System.out.println(ch);
		if(ch >= 'A' &&  ch <= 'Z') {	// 대문자 검사
			System.out.println("대문자");			
		}
		
		if(ch >= 'a' && ch <= 'z') { 	// 소문자 검사
			System.out.println("소문자");
		}
		
		if(ch >= '0' && ch <= '9') {	// 숫자 검사 
			System.out.println("숫자");
		}
		
	
	
		
	}

}
