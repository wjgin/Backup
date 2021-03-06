package ArrayListTest;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

	public static void main(String[] args) {

		ArrayList<Integer> lotto = new ArrayList<>();
		ArrayList<Integer> balls = new ArrayList<>();
		for (int i = 1; i <= 45; i++) // 1~45까지 담기
			balls.add(i);

		
		int maxNum = 45;
		// lotto 리스트가 10
		while(true) {
			// 6개 랜덤 뽑기
			for (int i = 0; i < 6; i++) {
				int index = (int) (Math.random() * maxNum);
				lotto.add(balls.get(index));
				balls.remove(index);
				maxNum--;
			}
			if(lotto.size() <= 10) break;
			// System.out.println("뽑은 공 번호 : " + lotto);
			// System.out.println("현재 남은 공 번호 : " + balls);
		}

		System.out.println();
		System.out.println("<< 최종번호  >>");
		lotto.sort(null); // 오름차순 정리
		// Collections.reverse(lotto); // 내림 차순은 컬렉션 클래스의 리버스 함수를 사용해서 뒤집어야한다.
		System.out.println(lotto);

	}

}
