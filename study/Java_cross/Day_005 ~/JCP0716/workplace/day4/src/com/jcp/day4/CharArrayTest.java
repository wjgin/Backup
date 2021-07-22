package com.jcp.day4;

public class CharArrayTest {

	public static void main(String[] args) {
		
		// char 데이터는 문자('')를 2byte 크기로 저장
		char[] charArr = {'하', '이', '~', '자', '바', '!', '재', '밌', '다', '.'} ;
		
		System.out.println("--- char 배열의 값을 출력 ---");
		for(int i = 0; i < charArr.length; i++) 
			System.out.print(charArr[i]);
			
		System.out.println("\n--- char 배열의 인덱스 2 값을 변경 후 출력 ---");
		charArr[2] = '*';
		System.out.println(charArr);	// 참조변수를 이용하여 출력 -> 문자 배열은 string 형태로 출력 
		
		System.out.println("\n--- char 배열과 String 타입과의 변환 ---");
		System.out.println("1. String 타입을 char 배열로 변환");
		String temp = "헬로우!! 자바**";
		char[] tempArr = temp.toCharArray();
		for(int i = 0; i < tempArr.length; i++)
			System.out.print(tempArr[i]);
		System.out.println();
		
		System.out.println("2. char 배열을 String으로 변환");
		String chString = String.valueOf(tempArr);	// arr -> String
		System.out.println(chString);
	}

}
