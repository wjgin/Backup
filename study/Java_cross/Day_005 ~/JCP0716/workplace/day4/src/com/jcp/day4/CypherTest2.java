package com.jcp.day4;

import java.util.Scanner;

public class CypherTest2 {

	public static void main(String[] args) {
// 요구 사항: 철수가 미미에게 암호 전달
		// key 값 = 7
		// 메세지 : "I like Java." => 각 문자에 7을 더해 암호화
		// 암호화된 메세지는 String 타입으로 전달
		// 암호화된 메세지 복호화 하기

		// 필수 값 선언
		String message = "", cypherText = "";
		int key = 7;
		char[] tmp;
		int ch;

		// String to Array
		tmp = cypherText.toCharArray();
		// 모든 배열 인자에 +key
		for (int i = 0; i < tmp.length; i++)
			tmp[i] -= key;

		// Array to String
		message = String.copyValueOf(tmp);

		// 복호화된 문자 출력
		System.out.println("복호화된 메세지 : " + message);

	}

}
