package com.jcp.day8b;

// 다른 패키지의 클래스를 사용할 경우 import
import com.jcp.day8a.User1;

public class User1Test {

	public static void main(String[] args) {

		// public static -> 모든 클래스에서 가능하고 정적변수(공유 메모리)
		int testSt = User1.st;
		
		// User1 클래스가 Public이기에 import는 가능
		// 생성자는 default라서 다른 패키지에서 접근 불가
		/*
		User1 test = new User1();
		
		test.name = "테스트";
		test.age = 28;
		*/
	}

}
