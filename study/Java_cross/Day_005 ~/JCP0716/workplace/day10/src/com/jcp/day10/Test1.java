package com.jcp.day10;

import java.util.ArrayList;

public class Test1 {

	static final int MAX_SIZE = 20;
	static final int MAX_PRIMECNT = 7;

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();

		ArrayList<Integer> testArr = new ArrayList<>();
		ArrayList<Integer> primeArr = new ArrayList<>();

		int primeCnt = 0;
		while (true) {
			int randomNum = (int) (Math.random() * 89 + 11);
			// 소수이고 중복이 없을 때 배열 추가 및 primeCnt++
			if (isPrime(randomNum) && !primeArr.contains(randomNum)) {
				testArr.add(randomNum);
				primeArr.add(randomNum);
				primeCnt++;
			} else // 소수가 아닌 값도 배열에 추가
				testArr.add(randomNum);
			// 배열의 인자가 20개가 되었을 때 조건 확인AA
			if (testArr.size() == MAX_SIZE) {
				if (primeCnt == MAX_PRIMECNT) { // 소수가 7개 일 때, 탈출
					break;
				} else { // 소수가 7개가 이니면 배열을 비우고 재시작AA
					testArr.clear();
					primeArr.clear();
					primeCnt = 0;
				}
			}
		} // while end

		System.out.print("테스트 배열 : ");
		System.out.println(testArr);
		System.out.print("소수 배열 : ");
		System.out.println(primeArr);

		long endTime = System.currentTimeMillis();
		System.out.println("실행시간 : " + (endTime - startTime) + " ms 소요되었습니다.");
		
	}// main end

	// 소수 확인 함수
	static boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

}
