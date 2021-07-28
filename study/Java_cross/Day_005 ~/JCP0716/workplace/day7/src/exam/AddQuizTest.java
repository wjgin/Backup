package exam;

import java.util.Scanner;

public class AddQuizTest {

	static final int SIZE = 5;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		AddQuiz[] quiz = new AddQuiz[SIZE]; // AddQuiz 객체는 생성안됨
		int cnt = 0;

		// 문제 내기 : 정수값 범위 : 1 ~ 99
		System.out.println(SIZE + "개의 문제를 풀어봅시다.");
		for (int i = 0; i < SIZE; i++) {
			quiz[i] = new AddQuiz();
			quiz[i].data1 = (int) (Math.random() * 89 + 11);
			quiz[i].data2 = (int) (Math.random() * 89 + 11);
			System.out.print((i + 1) + "번. " + quiz[i].data1 + " + " + quiz[i].data2 + " = ? ");
			quiz[i].userAns = sc.nextInt();
			if (quiz[i].makeResult())
				cnt++;
		}

		System.out.println(":::채점 중...:::");
		System.out.println("번호\t문제\t\t제출한 답\t\t정답\t채점");
		for (int i = 0; i < SIZE; i++) {
			System.out.println(i+1 + "번. "+ "\t" + quiz[i].data1 + " + " + quiz[i].data2 + " = " + "\t" +
		quiz[i].userAns + "\t\t" + (quiz[i].data1 + quiz[i].data2) + "\t" + quiz[i].resultPrint());
		}
		
		
	} //main end

	/*
	 * 추가 개선 사항
	 * 1) 랜던값의 범위를 바꿀수 있는 커스텀 생성자
	 * 2) 연산의 종류 변경(+, - *, /)
	 * 3) 랜덤값 중복 문제
	 */
	
	
}
