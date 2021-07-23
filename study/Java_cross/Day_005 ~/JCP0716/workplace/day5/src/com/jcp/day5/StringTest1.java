package com.jcp.day5;
import java.util.Scanner;

// Scanner 클래스를 이용하여 문자열 입력을 테스트 해봅시다.
public class StringTest1 {

	public static void main(String[] args) {
		// TODO : 객체란? 메모리에 저장된 데이터 집합. 클래스 타입으로 만들어지는 필드와 메소드를 사용
		
		Scanner sc = new Scanner(System.in);	
		// Scanner 클래스의 참조변수 sc -> Scanner 객체를 사용 가능
		
		String name;	
		// String 클래스 타입의 참조변수  name -> String 객체 사용 가능
		
		// Scanner 클래스에서 문자열 입력 메소드 : next(), nextLine()
		
		System.out.print("이름1 입력하세요 >>> ");
		name = sc.next();	// 문자 공백(\s or \n) 이전까지 저장
		System.out.println("next() 입력확인 : " + name);
		
		System.out.print("이름2 입력하세요 >>> ");
		name = sc.nextLine();	// \n까지 버퍼에서 가져와 저장
		System.out.println("nextLine() 입력확인 : " + name);
		
		// 메소드 프로토 타입(구조)
		// String java.util.Scanner.nextLine()
		// 1)	  2).패키지명.클래스      3)      4)
		// 1)리턴타입  2)메소드 소속  3)메소드이름  4)매개변수 -> 메소드 마다 다름
		
		// 메소드 사용시 2)번 부분이 참조변수(인스턴스 메소드) or 클래스명(클래스 메소드)이 된다.
		
		sc.close();
		
	}

}
