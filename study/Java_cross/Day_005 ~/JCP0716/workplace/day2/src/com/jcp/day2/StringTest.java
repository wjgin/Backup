package com.jcp.day2;

import java.util.Scanner;

// 문자열 데이터를 사용합니다. 핵심: 자바에서 문자열은 기본 데이터 형식이 없고 클래스로 사용 합니다.

public class StringTest {

	public static void main(String[] args) {
		String name = "kim";	// 클래스 타입의 변수(참조변수)
		System.out.println(name);
		System.out.println(name.hashCode());	// hashCode() => 객체의 주소값 return
		
		name = "choi";	// 문자열 "choi"가 메모리에 저장되고 그 위치(주소)는  name이 저장되도록 변경.
		System.out.println(name);
		System.out.println(name.hashCode());	// hashCode() => 객체의 주소값 return
		
		Scanner sc = new Scanner(System.in);
		String nickName;
		System.out.print("닉네임을 입력하세요 : ");
		// nickName = sc.next();	// 문자열 입력
		nickName = sc.nextLine();	// 공백을 포함한 문자열 입력
		sc.close();
		System.out.println("닉네임 확인 : " + nickName);
		
	}

}
