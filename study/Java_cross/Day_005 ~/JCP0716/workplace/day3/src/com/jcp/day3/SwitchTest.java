package com.jcp.day3;

import java.util.Scanner;

// if 문을 switch 문으로 바꿔보는 예제 입니다.
// 내용은 여러개의 메뉴 중 선택하는 조건으로 합니다.
public class SwitchTest {

	public static void main(String[] args) {
		System.out.println("[[사용자 메뉴]]");
		System.out.println("1:장바구니 2:상품목록 3:결제 4:배송조회 5:종료");
		;
		System.out.println("선택하세요>>>> ");

		Scanner sc = new Scanner(System.in);
		int menu;
		menu = sc.nextInt();

		if (menu == 1) {
			System.out.println("장바구니🎁 입니다.");
		} else if (menu == 2) {
			System.out.println("상품목록👀입니다.");
		} else if (menu == 3) {
			System.out.println("결제💲 입니다.");
		} else if (menu == 4) {
			System.out.println("배송조회🚚 입니다.");
		} else if (menu == 5) {
			System.out.println("프로그램 종료❌ 입니다.");
		} else {
			System.out.println("잘못된 선택❗ 입니다.");
		}

		System.out.println();
		System.out.println(":::switch로 동일한 테스트:::");
		System.out.println();
		// switch는 if 조건이 == 로 검사하는 경웨,
		// 데이터형식은 byte, short, int, long, String 일 때, 사용가능

		switch (menu) {
		case 1:
			System.out.println("장바구니🎁 입니다.");
			break;
		case 2:
			System.out.println("상품목록👀입니다.");
			break;
		case 3:
			System.out.println("결제💲 입니다.");
			break;
		case 4:
			System.out.println("배송조회🚚 입니다.");
			break;
		case 5:
			System.out.println("프로그램 종료❌ 입니다.");
			break;
		default:
			System.out.println("잘못된 선택❗ 입니다.");
			break;
		}
		System.out.println("프로그램을 종료 합니다................");
	}

}
