package day13.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySolution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num;	 // 연산할 변수
		int sum = 0; // 합 변수
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder("실행결과 ");
		// 사용자 입력
		System.out.print("정수 1개 입력 >>> ");
		num = sc.nextInt();
		
		// StringBuilder 이용 풀이
		do {
			list.add(num % 10); // 1의 자리 list에 추가
			sum += num % 10;	// 1의 자리 sum에 더하기
			sb.append(num % 10);
			num /= 10;			// num 자릿수 내리기
			if(num != 0) sb.append("+");
		}
		while(num > 0);
		sc.close();
		System.out.println(sb + " = " + sum);		
		
		
		/* String 이용 풀이
		// 조건 연산 실행
		while(num > 0) {
			list.add(num % 10); // 1의 자리 list에 추가
			sum += num % 10;	// 1의 자리 sum에 더하기
			num /= 10;			// num 자릿수 내리기
		} // while end
		
		// 출력
		String str = list.toString(); // list -> String
		str = str.replaceAll(", ", "+");
		System.out.print("실행 결과 ");
		System.out.println(str.substring(1, str.length()-1) + " = " + sum); // 1 ~ -1행까지 출력
		 */
		
	} // main end

}
