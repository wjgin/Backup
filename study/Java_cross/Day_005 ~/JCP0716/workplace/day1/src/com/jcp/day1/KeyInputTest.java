package com.jcp.day1;

import java.util.Scanner;	// Scanner class는 기본 class가 아니라서  import 사용
							// java.lang 패키지에 있는 기본 클래스는 import 불 필요
			
public class KeyInputTest {

	public static void main(String[] args) {
		// 키보드 입력은 표준 입력 : System class에 in필드를 사용
		// 다양한 데이터 입력을 처리하기 위해 Scanner class를 사용
		Scanner sc = new Scanner(System.in);	// 키보드 입력 준비 / Scanner 타입의 sc 생성
		int num1;
		double num2;
		System.out.println("정수 값 1개를 입력하세요. >>> ");
		num1 = sc.nextInt();		// 키보드 입력 내용 정수처리
		System.out.println("실수 값 1개를 입력하세요. >>> ");
		num2 = sc.nextDouble();	// 키보드 입력 내용 실수처리
		sc.close();		// 입력 받기 종료
		System.out.printf("입력 값 = %d, %.1f", num1, num2);
		
	}

}
