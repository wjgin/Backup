package com.jcp.day1;	// 패키지명

// 클래스 시작 
// 클래스(메소드 포함) : 1)이미 자바에서 만들어지고 우리는 가져다 사용하는 것
// 					2)프로그래머가 필요해서 직접 만드는 것.	
// 1) 2) 3)
public class PrintTest {
	// 3) 클래스 이름 : 대문자로 시작하도록 하는 규칙이있다.
	// 클래스 구성 : 메소드
	
	// 메소드
	//1)	2)	3)	4)	5)
	public static void main(String[] args) {
		// 4) 메소드 이름 : 소믄지로 시작하는 규칙
		// main 메소드: 여기서부터 프로그램이 시작됨.
		// 1)	2)	3)	4)
		System.out.println("Hi! Java ~ 안녕 자바!");			// print line(일반 출력, 자동 줄바꿈)
		System.out.print("Hi, java\n");						// 일반출력 줄 안바꿈
		System.out.printf("%d %d %s\n", 12, 34, "Java");	// format print
		// syso + ctr + space = print 자동완성
		// 1) System : 기본적인 데이터의 입/출력을 위한 클래스
		// 2) out : System 클래스의 필드. 표준출력(클래스 형태)
		// 3) printxx : out의 메소드(out도 클래스)
		
		
	}

}
