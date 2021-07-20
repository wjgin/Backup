package com.jcp.day2;

public class CastingTest {
	public static void main(String[] args) {
		
		byte byteValue = 123;	// int literal을 byte 형식으로 자동 형변환해서 저장
		int intValue = 123;
		char charValue = 'a';
		
		// 데이터 타입의 크기가 작은 형식 ~ 큰 형식
		// byte < short < int < long < float < double
		//   1      2      4     8       4       8	(byte)
		// 실수까지 표현하는 실수가 더 큰 범위를 가짐(long < float인 이유)
		
		// 데이터 타입이 작은 형식에 큰 형식의 값을 대입하면 오류
		// byteValue = 234;	// 오류: 작은형식에 큰 형식 값 대입
		byteValue = (byte)245;	// 강제변환(casting)은 가능하지만 값이 부정확
		System.out.println(byteValue);
		
		// 작은 형식의 데이터 값을 큰 형식에 담을 때에는 자동형변환
		intValue = byteValue;	// 큰 형식에 작은 형식의 값 대입
		System.out.println("자동 변환된 결과  : " + intValue);
		intValue = charValue;	// 큰 형식에 작은 형식의 값 대입
		System.out.println("자동 변환된 결과  : " + intValue);
		
		// 아스키코드의 값을 문자로 확인
		// charValue에 저장하기 위해서 casting
		intValue = 101;
		charValue = (char)intValue;
		System.out.println("ASCII code 101 : " + charValue);
		
	}
}
