package com.jcp.day10;

import java.util.ArrayList;

public class ArrayListLotto { // step 4 - 이우진

	public static void main(String[] args) {
		// 로또 테스트 : 1~45 정수값 6개를 랜덤으로 생성
		// 1) for문으로 출력
		// 2) 중복된 값 나오는 것은 무시
		ArrayList<Integer> lottos = new ArrayList<>(); // 난수 값을 담을 리스트

		// 6회 실행 : 난수 생성 및 저장
		for (int i = 0; i < 6; i++) {
			int lotto;								// 로또 번호
			double temp = Math.random() * 45 + 0.5; // 0.5부터 45.5 미만의 난수 생성
			lotto = (int) Math.round(temp); 		// 난수 값 반올림 => 1~45 까지의 값

			// 중복 값 검사
			if (!lottos.contains(lotto))			// 중복 확인 true / false
				lottos.add(lotto);					// 중복 없을시 리스트에 lotto 값 추가
			else
				i--;								// 중복있을 시 반복 횟수 추가
		}
		// 로또 번호 6자리 출력
		lottos.sort(null);
		System.out.println(lottos);
		
	}// main end
}
