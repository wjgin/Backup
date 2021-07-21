package com.jcp.day3;

import java.util.Scanner;

public class WhileTest2 {

	public static void main(String[] args) {
		int intValue;
		char charValue;
		Scanner sc = new Scanner(System.in);

		while (true) { // 종료조건: inValue 입력값이 999
			System.out.print("아스키코드 정수 값 입력하세요.(32~126) >>> ");
			intValue = sc.nextInt();
			if (intValue == 999)
				break; // while문 탈출
			else if (intValue < 32 || intValue > 126) {
				System.out.println("다시 입력하세요");
				continue; // while문 처음으로 돌아감
			}
			charValue = (char) intValue;
			System.out.println("아스키 코드 : " + intValue + ", 문자 " + charValue);

		}
		sc.close();
		System.out.println("프로그램을 종료 합니다.");
		/*
		 * 요구사항 while, switch문 은행 계좌 잔고 balance 초기값 0 메뉴 출력
		 */

		
	}
}

