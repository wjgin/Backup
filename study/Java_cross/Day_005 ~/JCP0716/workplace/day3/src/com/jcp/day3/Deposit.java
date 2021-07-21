package com.jcp.day3;

import java.util.Scanner;

public class Deposit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		int money, n;
		System.out.println("-----------------------------");
		System.out.println(" 1:예금 | 2:출금 | 3:잔액 | 4:종료");
		System.out.println("-----------------------------");
		Scanner sc = new Scanner(System.in);
		while (run) {
			System.out.println();
			System.out.println("메뉴를 선택하세요.(1~4)");
			n = sc.nextInt();
			
			switch (n) {
			case 1:
				System.out.println("예금할 금액(원)을 입력하세요.");
				money = sc.nextInt();
				balance += money;
				// continue; // while문 끝에 아무 명령도 없다면 불필요

			case 2:
				System.out.println("출금할 금액(원)을 입력하세요.");
				money = sc.nextInt();
				if(balance - money < 0) {
					System.out.println("잘못된 값 입니다.");
					System.out.printf("현재 잔액 : %d원\n", balance);
				}
				else balance -= money;
				// continue;

			case 3:
				System.out.printf("현재 잔액은 %d원 입니다.\n", balance);
				// continue;

			case 4:
				System.out.println("종료 합니다.");
				run = false;
				break;
			default :
				System.out.println("잘못된 값 입니다. 1~4만 입력하세요.");
			}
		}
	
	}

}
