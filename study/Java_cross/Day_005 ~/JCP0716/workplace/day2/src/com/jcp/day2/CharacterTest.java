package com.jcp.day2;

/*
 * 데이터형식 char : 문자1개를 저장하기위해 2바이트를 사용하는 형식
 * 문자는 문자를 식별하기 위한 정수값으로 표현되는 코드를 갖는데 여러종류의 문자코드가 있습니다. 
 * : 아스키코드(기본), 유니코드,.....
 * 자바는 기본적으로 문자값으로 유니코드를 사용.(한글은 유니코드)
 */
public class CharacterTest {
	public static void main(String[] args) {
		char c1 = 'A'; // 문자는 '' 안에 표시
		char c2 = 65; // 65는 문자에 대한 아스키코드 값
		char c3 = '가'; //
		char c4 = '\uac00'; // 16진수 : '\\u' => 16진수 유니코드 표시 문자
		char c5 = 44032; // 10진수
		// 한글 마지막 값 : '\d7a3' '힣'
		char c6 = '\ud7a3';	// 1101 0111 1010 0011 
		char c7 = '힣';
		char c8 = 55203; 
		// 2진수 4자리를 16진수로 더 간단하게 표현
		// 1001 1100 1011 0001 => 9CB1
		
		System.out.println("c1 :" + c1);
		System.out.println("c2 :" + c2);
		System.out.println("c3 :" + c3);
		System.out.println("c4 :" + c4);
		System.out.println("c5 :" + c5);
		System.out.println("c6 :" + c6);
		System.out.println("c7 :" + c7);
		System.out.println("c8 :" + c8);

		// 문자 데이터 형식 연산 : +, -
		c1++;
		System.out.println("c1 1증가 : " + c1);
		
		c2++;
		System.out.println("c2 1증가 : " + c2);
		
		c3++;
		System.out.println("c3 1증가 : " + c3);
		
		c4++;
		System.out.println("c4 1증가 : " + c4);
		
		c5++;
		System.out.println("c5 1증가 : " + c5);
		
		// 16진수(HexaDecimal) 데이터를 사용하는 코드
		int hexa1 = 0xd7a3;		// 16진수는 0x로 시작
		System.out.println("hexa1의 값  = " + hexa1);	// 10진수로 출력
		
		int dec1 = 44032;
		System.out.printf("10진수 %d를 16진수로 0x%x", dec1, dec1);
	}
}
