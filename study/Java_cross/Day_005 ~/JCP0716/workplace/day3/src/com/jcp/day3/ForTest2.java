package com.jcp.day3;

import java.util.Scanner;

public class ForTest2 {

	public static void main(String[] args) {
		int i, n;
		Scanner sc = new Scanner(System.in);

		System.out.println("마지막 n값을 입력하세요.");
		n = sc.nextInt();
		// 합계(중간 결과 값, 최종 결과 값) 저장할 변수는 반드시 초기 값 필요
		int sum = 0;
		// 1~n까지의 합계 구하기
		for (i = 1; i <= n; i++) {
			sum += i;
			System.out.println("i = " + i + "sum = " + sum);
		}
		System.out.println("1 ~ n까지의 합계 = " + sum + "입니다.");

	}

}
