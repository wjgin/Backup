package com.jcp.day2;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// 세걔의 정수값을 입력받아 최대값과 최솟값을 구합니다.

		/*
		 * [입력화면] n1 >>> n2 >>> n3 >>>
		 * 
		 * [출력화면] n1 = , n2 = , n3 = 최댓값 : , 최솟값 :
		 */
//		int n1, n2, n3;
//		System.out.println("[정수 값 세 개를 입력하세요.]");
//		Scanner sc = new Scanner(System.in);
//		System.out.print("n1 >>> ");
//		n1 = sc.nextInt();
//		System.out.print("n2 >>> ");
//		n2 = sc.nextInt();
//		System.out.print("n3 >>> ");
//		n3 = sc.nextInt();
//		sc.close();

//		int max = n1 > n2 ? n1 : n2;
//		int min = n1 < n2 ? n1 : n2;
//		max = n3 > max ? n3 : max;
//		min = n3 < max ? n3 : max;

//		System.out.printf("n1 = %d, n2 = %d, n3 = %d\n", n1, n2, n3);
//		System.out.println("최댓값 : " + max + "\t" + "최솟값 : " + min);

		// 확장성 풀이
		System.out.println("[저장할 정수의 개수를 입력하세요.]");
		Scanner sc = new Scanner(System.in);
		int numCnt = sc.nextInt();	// 총 저장할 정수의 개수
		
		System.out.println("[저장할 정수를 입력하세요.]");
		int[] nums = new int[numCnt];
		int num, cnt = 0;
		for (int i = 0; i < numCnt; i++) {
			System.out.printf("n%d >>> ", i + 1);
			num = sc.nextInt();
			nums[cnt] = num;
			cnt++;
		}
		sc.close();
		
		// 최댓값과 최솟값 구하기
		int max = -1000000;
		int min = 1000000;
		for (int i = 0; i < numCnt; i++) {
			if (nums[i] > max)
				max = nums[i];
			if (nums[i] < min)
				min = nums[i];
		}

		// 출력창
		for (int i = 0; i < numCnt; i++) {
			System.out.printf("n%d = %d  ", i + 1, nums[i]);
		}
		System.out.println();
		System.out.println("최댓값 : " + max + "   " + "최솟값 : " + min);
	}

}
