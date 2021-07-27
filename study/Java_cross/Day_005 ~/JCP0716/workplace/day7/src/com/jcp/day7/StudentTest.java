package com.jcp.day7;

import java.util.Scanner;

// 작성자 : 이우진
public class StudentTest {

	static final int SIZE = 3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 과목은 3개
		Student lee = new Student("lee", new int[SIZE]);
		
		System.out.print("국어 성적을 입력하세요. >>> ");
		lee.scores[0] = sc.nextInt();
		System.out.print("영어 성적을 입력하세요. >>> ");
		lee.scores[1] = sc.nextInt();
		System.out.print("수학 성적을 입력하세요. >>> ");
		lee.scores[2] = sc.nextInt();
		sc.close();
		
		lee.print();
		System.out.println();
		lee.printFor();
	}

}
