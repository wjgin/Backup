package com.jcp.day2;

import java.util.Scanner;

public class IfTest1 {

	public static void main(String[] args) {
		// 관계연산자 : 연산결과 값은 boolean 값(true, false)
		// ==, != , >, >=, <, <=, !
		/*
		boolean bval = 3 == 4;
		System.out.println("결과 값 : " + bval);	// false
		bval = (4 == 4);
		System.out.println("결과 값 : " + bval);	// true
		*/
		
		// point 값이 1 ~ 100 : "일반회원", 100초과 : VIP
		int point;
		System.out.println("<===================>");
		System.out.print("점수를 입력하세요 : ");
		Scanner sc = new Scanner(System.in);
		point = sc.nextInt();
		sc.close();
		
		System.out.println();
		if(point >= 1 && point <= 100) {
			System.out.println("일반회원");
		} else if (point > 100) {
			System.out.println("VIP");
		} else System.out.println("잘못된 입력 입니다.");
		
	}

}
