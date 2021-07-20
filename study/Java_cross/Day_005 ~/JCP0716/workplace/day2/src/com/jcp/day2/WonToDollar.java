package com.jcp.day2;

public class WonToDollar {

	public static void main(String[] args) {
		int dollar;
		int won;
		// 키보드입력으로 바꿀 수 있게 값을 초기화
		dollar = 1193;
		won = 1000000;

		System.out.println("[환율계산]");
		System.out.println("환율 1달러 = " + dollar + "(원)");
		System.out.println("여행 환전 원화 = " + won + "(원)");

		double result;
		System.out.println("[float변환으로 환전되었습니다.]...............");
		result = (float)won / dollar;	// 정수와 정수의 연산은 정수 이므로 형변환 필요(casting)
		System.out.println("USD 달러 = " + result + "(달러)");
		System.out.println("현재 won = " + won + "원");
		
		// 형변환
		System.out.println("[형변환으로 출력]...............");
		double doubleWon = won;
		result = doubleWon  / dollar;
		System.out.println("USD 달러 = " + result + "(달러)");
		
		System.out.println("[double 변환으로 환전되었습니다.]...............");
		result = won / (double)dollar;	// 정수와 정수의 연산은 정수 이므로 형변환 필요
		System.out.println("USD 달러 = " + result + "(달러)");
		System.out.println("현재 won = " + won + "원");
		// 결과값에 대해 다른 요구사항을 생각해보세요.
	}

}
