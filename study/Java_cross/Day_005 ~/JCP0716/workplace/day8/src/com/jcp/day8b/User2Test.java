package com.jcp.day8b;

// 다른 패키지의 클래스를 사용할 경우 import
import com.jcp.day8a.User2;

public class User2Test {

	public static void main(String[] args) {

		// public 접근 제어자 테스트
		User2 test = new User2();
		
		test.name = "테스트";
		test.age = 28;
		
		System.out.println(test.name + "(" + test.age + ")");
	}

}
