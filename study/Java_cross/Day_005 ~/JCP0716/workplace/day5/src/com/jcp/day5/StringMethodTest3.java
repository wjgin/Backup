package com.jcp.day5;

public class StringMethodTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testStr = "koreait.2021@gmail.com";
		
		System.out.println("1.contains");	// 인자의 포함 관계(boolean) 리턴
		System.out.println(testStr.contains("gmail"));
		System.out.println();
		System.out.println("2.charAt");	// 문자열 인덱스의 값 리턴 
		System.out.println(testStr.charAt(6));
		System.out.println();
		System.out.println("3.indexOf");	// 인자의 첫 글자 기준 인덱스 리턴
		System.out.println(testStr.indexOf("com"));	// 첫 글자(c)기준
		System.out.println(testStr.indexOf("."));
		System.out.println(testStr.indexOf("*"));	// 존재하지 않으면 -1 리턴
		System.out.println();
		System.out.println("4.lastIndexOf");	// 뒷 부분의 인자의 인덱스 리턴
		System.out.println(testStr.lastIndexOf("."));	
		System.out.println();
		System.out.println("5.startsWidth / endsWith");	// 문자열 끝에 인자의 포함 관계(boolean) 리턴
		System.out.println(testStr.endsWith("com"));
		System.out.println(testStr.endsWith("net"));
		System.out.println(testStr.startsWith("kor"));	// 시작 문자열 확인
		System.out.println();
		System.out.println("6.substring");	// start지점부터 end 미만까지 문자열 리턴
		System.out.println(testStr.substring(10, 15));
		System.out.println(testStr.substring(10));	// end 생략시 끝까지
		System.out.println();
		System.out.println("7.replace");	// 문자열 교체
		System.out.println(testStr.replace('1', '2'));	// char, char 인자
		System.out.println(testStr.replace("2021", "2022"));	// charSequence, charSequence 인자
		//System.out.println(testStr.replace('1', "2022"));	// 인자 혼합 불가
		//
		System.out.println();
		System.out.println("최종 문자열");
		System.out.println(testStr);	// 기존 문자열에 변화 없음
	}

}
