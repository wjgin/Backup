package com.jcp.day3;

public class ForTest1 {
	public static void main(String[] args) {
		int i; // for문 실행횟수를 제어하는 변수

		for (i = 0; i < 5; i++) { // 아래 출력문을 5번 실행. 카운트 변수 i (초기값 식; 조건식; 증감식)
			System.out.println("Hello world!");
		}
		for (i = 0; i < 5; i += 2) { // 아래 출력문을 5번 실행. 카운트 변수 i (초기값 식; 조건식; 증감식)
			System.out.println("Hello java!");
		}

		//cnt를 이용해서 50번 실행
		int cnt = 100;
		for(i = 0; i < cnt; i += 2) {
			System.out.println("good morning");
		}
	}
}
