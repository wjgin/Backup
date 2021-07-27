package com.jcp.day7;

import java.util.Scanner;

// student 클래스 배열 연습
public class StudentArrTest {
	static final int SIZE = 3;
	public static void main(String[] args) {
		
		// 5명의 학생을 처리할 수 있는 배열
		// status 배열의 인덱스에 정장된 값은  Student 객체를 참조
		Student[] stus = new Student[5];
		
		stus[0] = new Student("이름", new int[] {78, 56, 98});
		stus[1] = new Student("사람", new int[] {58, 54, 95});
		stus[2] = new Student("인간", new int[] {68, 52, 88});
		stus[3] = new Student("휴먼", new int[] {98, 66, 68});
		stus[4] = new Student("네임", new int[] {48, 86, 58});
		
		for(int i = 0; i < stus.length; i++) {
			stus[i].print();
			System.out.println();
		}
		System.out.println();
		
		// 배열에 저장된 학생 중에 총점이 230 이상인 학생의 총정, 평균 출력
		System.out.println("총점이 230인 이상인 학생 정보 출력");
		for(int i = 0; i < stus.length; i++) {
			if(stus[i].sum() >= 230)
				System.out.printf("이름 : %s \t총점 : %d\t평균 : %.2f",stus[i].name, stus[i].sum(), (double)stus[i].sum() / SIZE);
			System.out.println();
		}
		
		// 검색할 학생 이름
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 학생 이름을 입력 하세요 >>> ");
		String studentName = sc.nextLine();
		boolean exist = false;
		
		// 향상된 for문 (빠른 for문, foreach로 불림)
		// for(Student s : stus) {}
		for(Student s : stus) {
			if(s.name.contains(studentName)) {
				System.out.println("검색 결과 학생 이름 : " + s.name);
				System.out.println("학생 성적");
				exist = true;
				for(int jumsu : s.scores) {
					System.out.println(jumsu + "(" + s.grade(jumsu) + ")");
				} // jumsu for문 end
			} 
		} // s for문 end
		if(!exist) System.out.println("그런 학생은 없어요...");
		sc.close();
		
		System.out.println();
		// 이름이 "이름"인 학생의 정보 출력 : print()
		System.out.println("name이 \"이름\"인 학생 정보 출력");
		for(int i = 0; i < stus.length; i++) {
			if(stus[i].name.equals("이름")) stus[i].print();
			System.out.println();
		}
	
	} // main end
}
