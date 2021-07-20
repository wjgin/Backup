package com.jcp.day2;

import java.util.Scanner;

// IfTest2.java 소스를 String 클래를 이용해서 만들어봅시다
public class StringTest2 {

	public static void main(String[] args) {
		// 논리 연산 포함하는 조건
		int intValue;
		System.out.print("값을 입력하세요.");
		Scanner sc = new Scanner(System.in);
		intValue = sc.nextInt();
		char ch = (char) intValue;
		sc.close();

		// inValue에 저장된 코드 값이 대문자, 소문자, 숫자 인지 검사하는 if문
		// 문자의 종류 알아내기
		System.out.println(ch);

		String result;
		if (ch >= 'A' && ch <= 'Z') { // 대문자 검사
			result = "대문자";
		} else if (ch >= 'a' && ch <= 'z') { // 소문자 검사
			result = "소문자";
		} else if (ch >= '0' && ch <= '9') { // 숫자 검사
			result = "숫자";
		} else {	// 그 외의 값
			result = "unknown";
		}

		System.out.println("입력한 아스키코드 값 : " + intValue + ",분류 : " + result);

	}

}
