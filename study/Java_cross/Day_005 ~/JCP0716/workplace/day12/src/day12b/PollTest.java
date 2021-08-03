package day12b;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Map 예제 : 저녁 메뉴 설문 조사 -> 선택할 때 마다 값 1 증가
public class PollTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String menu = "오늘의 메뉴 : 삼겹살, 불고기, 떡볶이, 스파게티, 곱창전골";
		String ans = null; // 사용자가 입력한 메뉴
		Map<String, Integer> map = new HashMap<>(); // 한꺼번에 import 단축키 : ctr + shift + o

		// 메뉴별 선택 횟수 초기화
		map.put("삼겹살", 0);
		map.put("불고기", 0);
		map.put("떡볶이", 0);
		map.put("스파게티", 0);
		map.put("곱창전골", 0);

		while (true) {
			System.out.println("\n프로그램 종료는 \"end\"를 입력하세요");
			System.out.print("저녁 메뉴 선택 설문조사 중입니다. \n선택 >>> ");
			ans = sc.nextLine();
			if (ans.equals("end"))
				break; // end이면 루프 탈출

			// 존재하는 메뉴인지 확인
			if (map.containsKey(ans)) // <=> (map.equals(ans) != null)
				map.replace(ans, map.get(ans) + 1); // 선택지에 있으면 ++
			// 	ㄴ <=> map.put(ans, map.get(ans) + 1); //key가 존재하면 value 갱신
			else
				System.out.println("☠☠ 다시 선택하세요."); // 선택지에 없을 경우
		} // while end

		System.out.println();
		System.out.println(">>> 투표 종료. 최종결과. <<<");
		System.out.println(map); // 모든 클래스는 Object를 상속받아 toString()을 재정의해 출력 내용을 변경
								// 순서가 없는 출력
		System.out.println("끝");
	} // main end

}

