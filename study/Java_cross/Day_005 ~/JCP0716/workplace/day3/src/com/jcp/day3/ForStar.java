package com.jcp.day3;

import java.util.Scanner;

public class ForStar {

	public static void main(String[] args) {
		System.out.println("[영화감상 후기]");
		System.out.println("평점을 몇 점 주시겠습니까?(1~5)");
		Scanner sc = new Scanner(System.in);
		int point;
		while (true) {
			point = sc.nextInt();
			if (point > 5 || point < 0)
				System.out.println("다시 입력해주세요.");
			else
				break;

		}
		sc.close();

		System.out.print("점수 : ");

		for (int i = 0; i < point; i++) {
			System.out.print("★");
		}
		for (int i = point; i < 5; i++) {
			System.out.print("☆");
		}
		/*// 다양한 for 문 사용법
		 * int i = 0; 
		 * for (i = 0; i < point; i++) {
		 *  	System.out.print("★"); } 
		 * for (; i < 5; i++) {		// i를 for문 밖에서 지역변수로 선언, 시작점 생략
		 * 		System.out.print("☆"); }
		 *
		 *for (i = 0; i < 5; i++) {
		 *  	if(i < point) {
		 *  		System.out.print("★"); }
		 *  	else {
		 *  		System.out.print("☆"); }
		 *
		 */

		
		if (point >= 3)
			System.out.println("\n감사합니다.");
		else
			System.out.println("\n아쉽군요!!");
	}

}
