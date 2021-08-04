package day13.test;

import java.util.ArrayList;
import java.util.List;

public class MySolution {

	public static int SIZE = 10;

	public static void main(String[] args) {
		// 정수, 소수 값을 담을 배열 생성
		List<Integer> nums = new ArrayList<>();
		List<Integer> isprime = new ArrayList<>();

		int primeCnt = 0;
		while (true) {
			// 랜덤 값 저장(5 ~ 60까지의 정수)
			int randomNum = (int) Math.round((Math.random() * 55 + 5));
			
			// 조건확인
			// 소수이고 소수 배열에 없을 때,
			if (isPrime(randomNum) && !isprime.contains(randomNum)) {
				nums.add(randomNum);
				isprime.add(randomNum);
				primeCnt++;
			} else // 소수가 아니고 배열에 없을 때,
				if(!nums.contains(randomNum))
					nums.add(randomNum);
			// 탈출조건
			// 배열의 크기가 조건과 같을 때,
			if (nums.size() == SIZE) {
				if (primeCnt == 3) { // 소수가 3개 일 때, 탈출
					break;
				} else { // 소수가 3개가 이니면 배열을 비우고 재시작AA
					nums.clear();
					isprime.clear();
					primeCnt = 0;
				}
			}
		}
		
		// 출력 화면
		for (int i = 0; i < SIZE; i++) {
			// 소수일 때, 출력문
			if (isprime.contains(nums.get(i))) {
				System.out.println(nums.get(i) + " 소수");
			} else // 소수가 아닐 때, 출력문
				System.out.println(nums.get(i));
		}

	} // main end

	// 소수 검사 함수
	public static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
