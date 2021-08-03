package day12c;

import java.util.InputMismatchException;
import java.util.Scanner;

//TryCatchTest1.java 에서 catch를 수정하고 테스트 합니다.
public class TryCatchTest3 {
//형식 : try { 변수선언..... } catch() { .... }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String message = null; // Exception 발생하는 경우
		message = "hello";
		boolean result = false;
		try {
			result = message.equals("hello"); // null객체가 equals 실행 못합니다.
			if (result)
				System.out.println("원하는 메시지 입니다.");
			else // result 가 거짓일때
				System.out.println("보고싶은 메시지가 아닙니다.");

			System.out.print("정수를 입력하세요. >>> ");
			int num = sc.nextInt(); // try 블럭의 지역 변수
			System.out.println("입력받은 데이터 nun : " + num);
			sc.close();

		} catch (NullPointerException e) {
			System.out.println("exception 이 발생했습니다. - " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("abc 문자열은 nextInt() 로 정수변환을 못합니다. " + e.getMessage());
			e.printStackTrace();
		} finally {
			// try or catch 실행 후
			// return이 있는 try, catch를 사용할 때, 종료 전 실행
			System.out.println("끝");
		}

	}

}
