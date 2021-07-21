package com.jcp.day3;

public class WhileTest {

	public static void main(String[] args) {
		//무한반복 , 조건식이 참인동안 {} 를 반복
		int i = 0;
		while(i < 5) {	// 조건이 참인동안에만 반복  
	         System.out.println("**");
	         i++;
	      }
		System.out.println("확인 i = " + i);
		
		while(true) {
			System.out.println("하이 i = " + i);
			i++;
			if(i == 10) break;	//항상 참인 true 조건을 종료하는 명령문
		}
	}

}
