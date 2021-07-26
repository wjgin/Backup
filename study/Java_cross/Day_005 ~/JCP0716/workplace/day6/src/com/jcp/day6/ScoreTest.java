package com.jcp.day6;

import java.util.Scanner;

public class ScoreTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Score hong = new Score();
		
		hong.name = "홍길동";
		hong.kor = 92;
		hong.eng = 88;
		hong.math = 64;
		
		hong.print();
		
		// 사용자 입력 받기
		System.out.print("이름을 입력 하세요. >>> ");
		hong.name = sc.nextLine();
		System.out.print("국어점수를 입력 하세요. >>> ");
		hong.kor = sc.nextInt();
		System.out.print("영어점수를 입력 하세요. >>> ");
		hong.eng = sc.nextInt();
		System.out.print("수학점수를 입력 하세요. >>> ");
		hong.math = sc.nextInt();
		sc.nextLine();
		sc.close();
		hong.print();
	
	}

}
