package com.jcp.day5;

public class StringMethodTest {

	public static void main(String[] args) {
		// 간단한 String method 테스트
		// 인자가 없는 method
		String msg1 = "hello ~ java 하이 자바!*.";
		String msg2 = "HELLO ~ JAVA so INTERESTING.";
		
		System.out.println("msg1을 대문자로 변환");
		System.out.println(msg1.toUpperCase());	// 메소드 실행 결과 값 바로 출력
		
		System.out.println("msg2을 소문자로 변환");
		System.out.println(msg2.toLowerCase());
		
		System.out.println("msg2을 소문자로 변환하고 변수로 참조하면");
		String temp = msg2.toLowerCase();
		System.out.println(temp);
		
		System.out.println("msg1이 참조하는 문자열의 크기(개수)는?");
		System.out.println(msg1.length());
		
		System.out.println("msg2이 참조하는 문자열의 크기(개수)는?");
		int len = msg2.length();	// 메소드 실행 결과 값 변수 저장
		System.out.println(len);	
				
		msg1 = "      공백을 포함한 문자열      ";
		// 사용자가 입력의 공백을 없애야할 때
		System.out.println("[공백 제거 전]");
		System.out.println(msg1);
		
		System.out.println("[앞 뒤 공백 제거 후]");
		System.out.println(msg1.trim());	// 문자열 앞 뒤 공백 모두 제거(중간 공백은 제거하지 않음
	}

}
