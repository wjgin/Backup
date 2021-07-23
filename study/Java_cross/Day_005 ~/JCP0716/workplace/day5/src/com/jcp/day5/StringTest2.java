package com.jcp.day5;
import java.util.Scanner;

// Scanner 클래스를 이용하여 문자열 입력을 테스트 해봅시다.
public class StringTest2 {

	public static void main(String[] args) {
		// TODO : nextInt와 nextLine()을 함께 사용하는 테스트
		
		Scanner sc = new Scanner(System.in);	
		// Scanner 클래스의 참조변수 sc -> Scanner 객체를 사용 가능
		int age;
		String name;	
		// String 클래스 타입의 참조변수  name -> String 객체 사용 가능
		
		// Scanner 클래스에서 문자열 입력 메소드 : next(), nextLine()
		
		System.out.print("나이를 입력하세요 >>> ");
		age = sc.nextInt();	// 연속된 숫자만 가져옵니다.(\s, \n는 버퍼에 남겨짐)
		System.out.print("이름을 입력하세요 >>> ");
		name = sc.nextLine();	//(버퍼에서 \n까지 가져옴(\n을 리턴하지는 않는다.), 버퍼에 \n이 남아있다면 사용자 입력을 추가로 받지 못함.)
				
		System.out.printf("나이 : %d, 이름 : %s입니다 ", age, name);
		
		sc.close();	
	}

}
