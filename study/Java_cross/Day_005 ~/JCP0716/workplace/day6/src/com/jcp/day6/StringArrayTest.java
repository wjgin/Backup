package com.jcp.day6;
import java.util.Scanner;

/*
 * String 타입 배열
 * 1) String 타입 변수는 참조형 변수
 * 2) String[] , String 배열도 index로 접근한 메모리의 값은 문자열의 참조값
 * 
 * */

public class StringArrayTest {

	public static void main(String[] args) {
		// String 배열 테스트
		String[] strArr = {"continue", "break", "switch", "constant", "identifier", "array", "print" };
		
		for(int i = 0; i < strArr.length; i++)
			System.out.println("i = " + i + " 문자열 = " + strArr[i]);
		
		// 배열 요소의 문자열 입력, 먼저 new 연산으로 참조값을 젖아할 메모리 공간을 확보
		String[] arr = new String[4];
		Scanner sc = new Scanner(System.in);
		
		// 문자열 입력 받기
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print("문자열 입력 >>> ");
			arr[i] = sc.nextLine();
		}
		
		// 입력한 문자열 확인
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
		sc.close();
	}

	
	
}
