package com.jcp.day7;

import java.util.Scanner;

public class StudentTest2 {

	static final int SIZE = 3;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[SIZE];
		String name;
		
		System.out.print("이름을 입력하세요. >>> ");
		name = sc.nextLine();
		
		for(int i = 0; i < scores.length; i++) {
			System.out.println("과목" + (i+1) + "점수 입력  >>> ");
			scores[i] = sc.nextInt();
		}
		
		Student sana = new Student(name, scores);
		sana.print();
		
		sc.close();

	}

}
