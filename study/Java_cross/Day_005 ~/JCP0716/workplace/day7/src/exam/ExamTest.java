package exam;

import java.util.Arrays;
import java.util.Scanner;


public class ExamTest {

	static final int SIZE = 10;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double random1, random2;
		int solution, cnt = 0;;
		Exam[] ex = new Exam[SIZE];
		char[] result = new char[SIZE];
		
		System.out.println("[[덧셈 10문제 풀이를 시작 합니다.]]");

		for (int i = 0; i < SIZE; i++) {
			random1 = Math.random() * 99 + 0.5;
			random2 = Math.random() * 99 + 0.5;
			ex[i] = new Exam(random1, random2);
			System.out.println("-----------------------");
			System.out.printf("%d번. ", i + 1);
			System.out.println(ex[i].num1 + " + " + ex[i].num2 + " = ?");
			System.out.print("답 >>> ");
			solution = sc.nextInt();
			ex[i].solution = solution;
			
			if (solution == ex[i].sum()) {
				System.out.println("채점 : O \t 정답 입니다." );
				cnt ++;
				result[i] = 'O';
			} else {
				System.out.println("채점 : X \t 정답 : " + ex[i].sum());
				result[i] = 'X';
			}
			System.out.println();
		} // for end
		
		System.out.println("맞은 개수 : " + cnt);
		System.out.println("풀이 결과 : " + Arrays.toString(result));
		sc.close();
		
		// checkResult 메소드 사용
		System.out.println(":::::채점하고 있습니다.:::::");
		System.out.println("            문제              제출한 답       정답        채점");
		for(int i = 0; i < SIZE; i ++) {
			System.out.printf("%2d번   ", i + 1);
			ex[i].checResult(result[i]);
		}
		
	} // main end
}
