package com.jcp.day2;

public class DoubleTest {

	public static void main(String[] args) {
		
		// 실수 데이터의 (double과 float)출력과 연산결과를 확인해 봅시다.
		double d2 = 1.12345678901234567890123456789;
		float f2 = 1.12345678901234567890123456789f;
		System.out.println("double 1.12345678901234567890123456789 : " + d2); // 소숫점 이하 자릿수 최대 16
		System.out.println("float 1.12345678901234567890123456789 : " + f2); // 소숫점 이하 자릿수 최대 7 

		System.out.println("지수 형식 2e3" + 2e3); // 2000.0
		System.out.println("지수 형식 2e-3" +2e-3); // 0.002
		// 실수 : 부동소숫점형식(0과 1)으로 처리하는데 있어서 발생하는 문제점 (2진수를 10진수로 변환해서 출력할 떄, 발생) 
		System.out.println(0.1 + 1.6); // 1.7000000000000002
		System.out.println(3.0 / 0.0); // Infinity 무한대) : 실수 0.0으로 나는 결과
		System.out.println(0.0 / 0.0); // NaN (실수 0.0을 나눌 때)
		System.out.println( 3 / 0 ); // Error : 정수 0으로 나눌 때
	}

}
