package com.jcp.day1;
import java.util.Scanner;

public class RectangleTest2 {

	public static void main(String[] args) {
		// 입력 받을 사각형의 너비와 높이
		double width, height;
		
		// 너비와 높이 사용자 입력
		System.out.println("<======================준비======================>");
		System.out.println("사각형의 넓이를 구하는 프로그램 입니다.");
		System.out.println();
		System.out.println("사각형의 너비를 입력하세요(m).");
		Scanner sc = new Scanner(System.in); 	// 입력 준비
		width = sc.nextDouble();	// 너비 입력
		System.out.printf("현재 사각형의 너비는 %.1f 입니다.\n", width);		
		System.out.println("사각형의 높이를 입력하세요(m).");
		height = sc.nextDouble();	// 높이 입력
		System.out.printf("현재 사각형의 높이는 %.1f 입니다.\n", height);
		sc.close();
		// 입력 종료
		
		// 출력할 사각형의 넓이
		double area = width * height;
		System.out.println();
		System.out.println("<======================결과======================>");
		System.out.printf("사각형의 너비는 %.1fm, 높이는 %.1fm, 넓이는 %.3f㎡입니다.", width, height, area);
	}

}
