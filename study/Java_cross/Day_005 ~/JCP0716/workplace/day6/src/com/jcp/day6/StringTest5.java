package com.jcp.day6;

import java.util.Arrays;

public class StringTest5 {

	// 사전식비교(a < b < c < ... < z) 메소드
	public static void main(String[] args) {
		
		// 문자 char, 정수 데이터 형의 값은 비교를 관계연산자(<, >, <=. >=)로 비교
		// 문자열은 관계연산자 비교 불가능 -> comparTo 메소드로 비교
		String str = "hello";
		
		// str.compareTo(비교 문자열) : 결과 값  = str(아스키 코드 값) - 비교 문자열(아스키 코드 값)
		System.out.println(str.compareTo("cat"));		// str보다 앞에 있는 문자열
		System.out.println(str.compareTo("hello"));		// str과 같은문자열
		System.out.println(str.compareTo("switch"));	// str보다 뒤에 있는 문자열
	
		// 문자열의 비교는 대표적으로 문자열 정렬에 사용
		String[] strArr = {"continue", "break", "switch", "constant", "break", "identifier", "array", "print" };
		
		// 정렬 제공 클래스와 메소드. Arrays.sort
		Arrays.sort(strArr);
		// 배열의 인덱스 순서대로 출력하는 메소드 toString
		System.out.println(Arrays.toString(strArr));
		
	} // main end

}
