package day11b;

import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

//  자바 API 클래스의 인터페이스 활용 테스트
// CharSequence 인터페이스
public class CharSequenceTest {
	
	public static void main(String[] args) {
		
		String result = "";
		for(int i = 2; i < 5; i++) {
			result += i + "/";	// result 문자열에 i, "/" 연결
			System.out.println(result);
			/* 출력결과
			 * 2/		-> 문자열은 매번 새로운  String 객체를 만들어 저장함(메모리 사용 / 해제 지속적 관리 필요)
			 * 2/3/	
			 * 2/3/4/
			 */
		}
		
		StringBuilder sb = new StringBuilder();
		StringBuffer sf = new StringBuffer();	// StringBuilder와 같은 동작. 멀티스레드 구현에 사용
		for(int i = 2 ; i < 5; i++) {
			sb.append(i).append(",");	// 문자열이 바뀌어도 객체 유지(추가 및 삭제 등 변경 가능)
			System.out.println(sb);		// 빈번하게 문자열에 문자열의 내용 바뀔 때 사용
		}
		
		// CharSequence 인터페이스 구현 클래스는  String, StringBuilder, StringBuffer 등이 있다.
		String temp = "1, 2, 3, 4,5 ";
		System.out.println(temp.contains(result));	// 인자 : String
		System.out.println(temp.contains(sb));		// 인자 : StringBuilder
													//  ㄴ contains 메소드 인자는 CharSequence 인터페이스 타입이다.
		
		List<String> list = new ArrayList<String>();	// ** ArrayList 참조변수 선언형식. 인터페이스 타입으로
		List<String> vector = new Vector<String>();		// ArrayList와 동일한 동작. 멀티스레드 구현
		list.add("123");
		vector.add("456");
		
	} // main end
}
