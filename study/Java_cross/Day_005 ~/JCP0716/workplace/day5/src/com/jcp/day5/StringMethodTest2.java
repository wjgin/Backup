package com.jcp.day5;

public class StringMethodTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String msg1 = "test";
		String msg2 = "java";

		System.out.println("msg1==msg2 : " + (msg1 == msg2));
		
		System.out.println();
		String msg3 = "test";	// 변수명이 달라도 가르키는 문자열이 같으면 참조 값은 동일(리터럴 문자일 경우)
								// 자바는 문자열이 같은 것이 있으면 메모리에 또 저장하지 않음
		System.out.println("리터럴로 생성한 문자열 비교");
		System.out.println("msg1 == msg3 : " + (msg1 == msg3));	// 참조 값 비교
		System.out.println("msg1과 msg3 문자열 내용 비교 : " + msg1.equals(msg3));	// 문자열 비교
		// equals 메소드 분석 : 인자	Object(모든 클래스의 상위),	리턴 boolean
		
		System.out.println();
		String msg4 = new String("test");	// 같은 문자열이 있어도 별도의 메모리에 생성
		System.out.println("new 연산으로 생선된 객체의 문자열 비교");
		System.out.println("msg1 == msg4 : " + (msg1 == msg4));	// 참조 값이 다르기 때문에 flase
		System.out.println("msg1과 msg4 문자열 비교 : " + msg1.equals(msg4));	// 같은 내용이기에 true
	
	}

}
