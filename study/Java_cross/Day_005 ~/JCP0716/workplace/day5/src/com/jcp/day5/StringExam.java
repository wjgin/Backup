package com.jcp.day5;

public class StringExam {

	public static void main(String[] args) {
		// 문자열 "kor_sec20_21@gmail.com";
		// -> 숫자의 개수를 출력합니다. 위의 예 => 4
		// 메소드 charAt 사용하여 문자 1개씩 검사
		// 반복횟수는 문자열의 길이를 구하는 lenght 메소드 사용
		
		
		String problem = "kor_sec20_21@gmail.com";	// 문제의 문자열
		int len = problem.length();	// 문제의 문자열 길이
		int cnt = 0;	// 숫자 개수를 담을 변수
		// 문자열의 모든 인덱스 값 확인
		for(int i = 0; i < len; i++) {
			// 숫자 0 ~ 9일 경우 cnt 1 추가
			if(problem.charAt(i) >= '0' && problem.charAt(i) <= '9') {
				cnt++;
			}
		}
		System.out.println("숫자의 개수 : " + cnt);	// cnt 출력
	}

}
