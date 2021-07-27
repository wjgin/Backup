package com.jcp.day7;

// 작성자 : 이우진
public class Student {
	// 필드
	
	String name;	// 학생 이름
	int[] scores;
	
	
	// 기본 생성자
	public Student() {
		
	}
	
	// 커스텀 생성자 : 2개의 필드 초기화
	public Student(String name, int[] scores) {
		this.name = name;
		this.scores = scores;
	}
	
	// scores 배열의 합계 구하기
	int sum() {
		int result = 0;
		for(int i= 0; i < scores.length; i++) {
			result += scores[i];
		}
		return result;
	}
	
	
	char grade(int score) {
		if(score >= 90) return 'A';
		else if(score >= 80 && score <= 89) return 'B';
		else if(score >= 70 && score <= 79) return 'C';
		else return 'D';
	}
	
	void print() {
		System.out.println("\n >>> 학생 정보 <<<");
		System.out.printf("name : " + name + "\nscores >>> \n" + 
	"국어 점수 : %d(%c)\n" +
	"영어 점수 : %d(%c)\n" + 
	"수학 점수 : %d(%c)\n" +
	"총점 : %d",
	scores[0], grade(scores[0]), scores[1], grade(scores[1]), scores[2], grade(scores[2])
	, this.sum());
	}
	
	void printFor() {
		System.out.println("\n >>> 학생 정보 <<<");
		System.out.println("name : " + name + "\nscores >>> \n");
		for(int i = 0; i < scores.length; i++) {
			System.out.printf("%d번 째 과목의 성적 : %d점\t", i + 1, scores[i]);
		}
		System.out.printf("총점 : %d점", sum());
	}
	
}
