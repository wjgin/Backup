package com.jcp.day5;

import java.util.Scanner;

public class UserIdCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 가입을 환영 합니다.");
		System.out.println("특수문자 @는 사용할 수 없습니다.");

		String id = null;
		boolean result = true;
		while (result) {
			System.out.println();
			System.out.print("사용할 아이디를 입력하세요.");
			id = sc.nextLine();	// 사용자 입력 받기
			System.out.println("입력한 아이디를 검사합니다............");
			
			// 문자열의 모든 char검사
			for (int i = 0; i < id.length(); i++) {
				// 0번 인덱스가 숫자이면 안내 메세지 출력 후 for문 탈출 사용자 재입력
				if (i == 0 && id.charAt(i) >= '0' && id.charAt(i) <= '9') {
					System.out.println("아이디는 숫자로 시작할수 없습니다.");
					break;
					// 6자리 미만의 문자열일 경우 사용자 재입력
				} else if(id.length() < 6) {
					System.out.println("사용할수 없는 아이디입니다. - 아이디를 6글자 이상해주세요.");
					break;
				// 문자열에 '@'문자가 포함시 안내 메세지 출력 후 사용자 재입력
				} else if (id.charAt(i) == '@') {
					System.out.println("@ 기호를 사용할 수 없습니다.");
					result = true;
					break;
				// 이상 없을 경우 for 밎 while문 탈출
				} else result = false;
			} //for문 끝
			
		} // while문 끝
		sc.close();
		System.out.println("---------------------");
		System.out.println("회원가입 완료!");
		// 사용자 입력 값 출력
		System.out.println("현재 아이디는 : " + id + "입니다.");
		
	}

}
