package com.jcp.day4;

import java.util.Arrays;

public class LottoTest4 {	// step 4 - 이우진

	public static void main(String[] args) {
		// 로또 테스트 : 1~45 정수값 6개를 랜덤으로 생성
		// 1) for문으로 출력
		// 2) 중복된 값 나오는 것은 무시

		int lotto; // 난수 값을 담을 변수
		int[] lottos = new int[6]; // 선택된 로또 번호를 담을 배열

		// 6회 실행
		for (int i = 0; i < 6; i++) {
			double temp = Math.random() * 45 + 0.5; // 0.5부터 45.5 미만의 난수 생성
			lotto = (int)Math.round(temp); // 난수 값 반올림 => 1~45 까지의 값 (int 범위 값 안 이기에 형변환 가능)

			// 중복 값 검사
			int j;
			for (j = 0; j < i; j++) {	// i 전까지 중복 검사
				if (lottos[j] == lotto) {
					break;
				}
			}
			if (j == i)	// 중복이 없다면 j == i
				lottos[i] = lotto; // 중복이 아니라면 로또 배열에 추가
			else
				i--; // 존재한다면 다시 뽑기
		}

		// 로또 번호 6자리 출력
		System.out.println(Arrays.toString(lottos));

	}

}
