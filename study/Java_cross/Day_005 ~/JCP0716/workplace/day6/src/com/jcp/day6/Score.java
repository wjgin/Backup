package com.jcp.day6;

public class Score {
	String name;
	int kor, eng, math;
	
	
	int sum() {
		return (kor + eng + math);
	}
	
	double avg() {
		return (sum() / 3.0);	// 지역변수와 겹치는 전역변수가 없을 때, this 사용 필요없음
	}
	
	char grade(int score) {
		if(score >= 90) return 'A';
		else if(score >= 80 && score <= 89) return 'B';
		else if(score >= 70 && score <= 79) return 'C';
		else return 'D';
	}
	
	void print() {
		System.out.printf("%s - %3d(%c) %3d(%c) %3d(%c) 합계 = %3d  평균 = %.2f\n", 
				name, kor, grade(kor), eng, grade(eng), math, grade(math), sum(), avg());
	}
	
}
