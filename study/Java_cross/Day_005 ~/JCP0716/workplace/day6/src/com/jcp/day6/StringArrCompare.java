package com.jcp.day6;
import java.util.Scanner;
/*
 * 반복문 안에서 String 배열이 참조하는 문자열 비교하는 테스트
 */
public class StringArrCompare {

	public static void main(String[] args) {
		// 처리조건: 문자열 중복이 가능한 데이터 저장
		Scanner sc = new Scanner(System.in);
		String[] strArr = {"continue", "break", "switch", "constant", "break", "identifier", "array", "print" };
		String[] korArr = {"계속", "종료", "선택", "상수", "탈출", "식별자", "배열", "출력"};
		
		
		boolean result = false;	// 찾는 문자열 여부
		// 비교: equals 메소드(완전 일치), contains 메소드(부분 일치), 사전식비교(a < b < c < ... < z) 메소드
		// 찾고싶은 문자열
		System.out.print("찾을 문자열을 입력하세요 >>> ");
		String find = sc.nextLine();
		
		for(int i = 0 ; i  < strArr.length; i++) {	// 순서대로 모두 비교
				System.out.println("i = " + i + " 찾는 값? " + strArr[i].equals(find));
				if(strArr[i].equals(find)) {	// 중복 불가면 break
				System.out.println("i = " + i + " 영문 = " + strArr[i] + ", " + "한글 = " + korArr[i]);
				result = true;
			}
		}
		// 찾는 문자열이 없을 때
		if(!result) System.out.println("찾는 문자열이 없어요.🙏🙏");
		sc.close();
		
	} // main end
	
	

}
