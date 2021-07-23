package com.jcp.day4;

import java.util.Scanner;

public class CypherTest {

	public static void main(String[] args) {
// 요구 사항: 철수가 미미에게 암호 전달
		// key 값 = 7
		// 메세지 : "I like Java." => 각 문자에 7을 더해 암호화
		// 암호화된 메세지는 String 타입으로 전달

		// 필수 값 선언
		String message = "", cypherText = "";
		String bufferClearing;
		int key = 7;
		char[] tmp;
		int ch;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("\n<====메뉴를 선택하세요====>");
			System.out.println("1.암호화   2.복호화   3.종료");
			ch = sc.nextInt();
			bufferClearing = sc.nextLine();	// 버퍼 \n제거
			if (ch == 3)
				break;
			else if (ch == 1) {
				System.out.println("전달할 메세지를 입력하세요.");
				
				// 전달할 메세지 입력
				message = sc.nextLine();
				
				// String to Array
				tmp = message.toCharArray();
				// 모든 배열 인자에 +key
				for (int i = 0; i < tmp.length; i++)
					tmp[i] += key;

				// Array to String
				cypherText = String.copyValueOf(tmp);
				
				// 암호화된 문자 출력
				System.out.println("암호화된 메세지 : " + cypherText);
				
			} else if (ch == 2) {
				if(message.length() == 0) System.out.println("메시지가 비어있습니다.");
				else System.out.println("복호화된 메세지는 " + message + " 입니다.");
			}
		}
		sc.close();
		System.out.println("\n종료 되었습니다.\n");
		System.out.println("message = " + message);
		System.out.println("cypherText = " + cypherText);
	}

}
