package com.jcp.day1;

public class CircleTest {

	public static void main(String[] args) {
		// 원의 반지름 저장할 변수
		int r = 6; // 반지름 테스트 정수값 저장
		// 원의 넓이 저장할 변수
		double area;

		System.out.println("-------------------------------------");
		System.out.println("*원(circle)의 넓이를 구하는 프로그램입니다.*");
		System.out.println("원의 반지름 (단위 : m) >>> " + r);

		System.out.println("\n원의 넓이를 구했습니다.............");
		area = 3.14 * r * r;
		System.out.printf("3.14 x %d x %d =  %.3f  (단위:㎡)  \n", r, r, area);
		// format : %d 정수 %f 실수(double, float) %.xf x자리수 만큼 실수 표현
		System.out.println("--------------------------------------");
	}

}
