package com.jcp.day3;

import java.util.Arrays;
import java.util.Scanner;


// 정수 배열을 테스트 합니다.
public class ArrayTest1 {

	public static void main(String[] args) {
			
		// 선언 방법
		// 1) 정수 데이터 4개를 초기값을 주고 선언
		int[] arr1 = {78, 65, 89, 94};	// 배열 값 초기화
		
		// 2) 정수 데이터 10개를 저장하는 배열 - 배열의 크기 10
		int[] arr2 = new int[7];	// new는 객체를 생성하는 연산자
									// 배열의 크기만 정하고 값은 주지 않는다. - 값은 0으로 초기화
		// 자바에서 배열은 참조타입
		// 베열의 값 출력. - 인덱스(위치를 나타내는 값)
		for(int i = 0; i < arr1.length; i++) {	// 배열의 length 필드값 만큼 반복
			System.out.printf("arr1[%d] = %d\n", i, arr1[i]);
		}
		
		for(int i = 0; i < arr2.length; i++) {
			System.out.printf("arr2[%d] = %d\n", i, arr2[i]);
		}
		
		// arr2 배열에서 사용자가 입력한 값으로 데이터를 저장하고 
		// 1)전체 출력 2)짝수만 출력 3)소수 출력
		Scanner sc = new Scanner(System.in);
		System.out.println("arr2배열의 값, 7개의 정수 입력");
		
		for(int i = 0; i < arr2.length; i++) {
			arr2[i] = sc.nextInt();
		}
		System.out.println("\n전체 출력");
		System.out.print("arr2 = ");
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println("\n짝수만 출력");
		for(int i = 0; i < arr2.length; i++) {
			if(arr2[i] % 2 == 0) System.out.print(arr2[i] + " ");
		}
		System.out.println("\n소수만 출력");
		for(int i = 0; i < arr2.length; i++) {
			boolean odd = true;
			if(arr2[i] == 1) odd = false;
			for(int j = 2; j <= Math.sqrt(arr2[i]); j++) {
				if(arr2[i] % j == 0) {
					odd = false;
					break;
				}
			}
			if(odd) System.out.print(arr2[i] + " ");	
		}
	sc.close();
	System.out.println();
	System.out.printf("%s", Arrays.toString(arr2));	// 배열 전체를 리턴하는 메소드
	}
}
