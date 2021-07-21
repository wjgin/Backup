package com.jcp.day1;

// 정수 데이터를 저장하는 변수를 연습합니다.
public class DataTest1 {

	public static void main(String[] args) {
		// 변수의 선언(이름, 크기,- 형식을 지정합니다.)
		// 정수 기본 데이터형
		byte num0 = 127; // 1byte, -128 ~ 127
		short num1 = 23; // 2byte, -32768 ~ 32767
		int num2 = 23; // 4byte, -2147483648 ~ 2147483647
		long num3 = 23; // 8byte, 대충 -9백경 ~
		System.out.println("num0 :" + num0); // 한줄 복사 ctr + alt + ↓
		System.out.println("num1 :" + num1);
		System.out.println("num2 :" + num2);
		System.out.println("num3 :" + num3);

		System.out.println(":::Byte 클래스로 데이터타입 정보확인-byte :::");
		System.out.println("byte 변수의 크기 : " + Byte.BYTES + " 바이트"); // Byte 클랫의 BYTES 필드
		System.out.println("byte 변수의 최대값 : " + Byte.MAX_VALUE);
		System.out.println("byte 변수의 최소값 : " + Byte.MIN_VALUE);
		System.out.println();

		// 기본형 데이터가 필요에 따라 클래스로 변환되어야 할때 각 기본형에 대한 Wrapper 클래스를 사용합니다. -> 기본형 데이터를 클래스로
		// 덮어쓰기
		// ---> Integer, Byte, Short, Long, Character 등
		// Integer 클래스로 int 데이터형의 크기 / 최댓값 / 최솟값도 확인
		System.out.println(":::Integer 클래스로 데이터타입 정보확인-int :::");
		System.out.println("int 변수의 크기 : " + Integer.BYTES + " 인티저");
		System.out.println("int 변수의 최대값 : " + Integer.MAX_VALUE);
		System.out.println("int 변수의 최소값 : " + Integer.MIN_VALUE);

	}

}
