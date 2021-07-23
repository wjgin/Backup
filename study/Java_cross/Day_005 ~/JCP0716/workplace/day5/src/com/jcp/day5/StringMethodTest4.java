package com.jcp.day5;

public class StringMethodTest4 {

	public static void main(String[] args) {
		// indexOf 메소드와 substring 메소드 활용
		// "korHK korTE korSH korea" 에서 "kor"의 개수 찾기
		
		String testStr = "korHK korTE korSH korea";
		String purpose = "kor";                 
		int len = purpose.length();
		int index;
		
		String temp = testStr;	// temp는 testStr과 같은 참조 값을 갖는다.
		int cnt = 0;
		while(true) {
			System.out.println("temp 문자열 : " + temp);
			index = temp.indexOf(purpose);	// 찾을 문자열 "kor"
			System.out.println("index : " + index);
			if(index == -1) break;
			else cnt++;
			temp = temp.substring(index + len);	// 찾은 문자열 이전 값들은 temp에서 삭제
			
		}
		System.out.println("찾는 문자열 : kor,  횟수 : " + cnt + "번");

	}	// 작성자 : 이우진

}
