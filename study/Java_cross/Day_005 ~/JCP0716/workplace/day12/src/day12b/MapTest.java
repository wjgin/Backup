package day12b;

import java.util.HashMap;
import java.util.Map;

// Map<K, V> 인터페이스 구현체 HashMap<K, V> 클래스
// 		ㄴ Key, Value (K, V는 기본 데이터 타입과 클래스 타입(Object) 모두 가능)

public class MapTest {

	public static void main(String[] args) {
		// 지금까지 데이터 저장 자료 구조 : 배열, ArrayList --> 인덱스를 갖고 순차적 접근
		
		// 데이터를 저장하는 자료구조 중  Map 타입을 사용 --> 순차적접근  x, 키 값으로 접근. 인덱스 없음 
		Map<String, Integer> map = new HashMap<>(); 
		
		// 데이터 저장하기
		map.put("삼겹살", 10000);
		map.put("파스타", 9000);
		map.put("불고기", 13000);
		map.put("평양냉면", 16000);
		
		// 값 가져오기 - 순차적 접근이 아니기에 반복문 사용하는 경우가 거의 없음
		System.out.println("KEY : 삼겹살의 값 - " + map.get("삼겹살"));	// 값 가져오기 -> key 지정
		System.out.println("KEY : 치킨의 값 - " + map.get("치킨"));	// 없는 값 가져오기 => value : null
		String key = "파스타";
		int value = map.get(key);
		System.out.println("KEY : " + key + " VALUE : " + value);
	}

}
