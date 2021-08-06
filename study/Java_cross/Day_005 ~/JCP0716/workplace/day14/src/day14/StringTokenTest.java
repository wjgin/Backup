package day14;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {
		String temp = "모모 90 80 70"; // 하나의 문자열로 된 데이터를 분리. Student 객체 또는 각가 변수에 저장

		// 2)
		System.out.println(":::::방법(2):::::");
		StringTokenizer stk = new StringTokenizer(temp); // temp는 분리할 대상 문자열. 분리기준 기본값 : "공백"
		System.out.println("토큰 출력해보기 : " + stk);
		Student s = null;
		while (stk.hasMoreTokens()) {
			// System.out.println(stk.nextToken());
			s = new Student(stk.nextToken(), 
					Integer.parseInt(stk.nextToken()),
					Integer.parseInt(stk.nextToken()),
					Integer.parseInt(stk.nextToken()));
		}
		System.out.println("Student 객체 확인 : " + s);
		System.out.println("s 객체 이름 : " + s.getName());
		System.out.println("점수 1 : " + s.getJumsu1());
		System.out.println("총점 : " + s.getSum());
		System.out.println("--------------");
		// 위에서 stk의 토큰을 모두 사용했기에 남아 있지 않다.
		while (stk.hasMoreTokens()) {	
			System.out.println("토큰이 존재 합니다. : " + stk.nextToken());
		}
		
		System.out.println(":::::방법(1):::::");
		// 1) String 클래스 split 메소드 이용 -> 데이터 분리 String 배열 리턴
		temp = "모모,,,90,,,80,,,70";
		String[] datas = temp.split(",,,");
		System.out.println(datas[0]);
		System.out.println(datas[1]);
		System.out.println(datas[2]);
		System.out.println(datas[3]);
		// 3개의 데이터에 대한 총점
		System.out.println("총점 : " + datas[1] + datas[2] + datas[3]); // 908070

		// 문자열 데이터 -> int
		int sum = 0;
		for (int i = 1; i < datas.length; i++) {
			sum += Integer.parseInt(datas[i]);
		}

		// sc.nexInt -> sc.nextLine 실행 순서 문제해결 : nextLine으로 받고 필요하면 변환(parseXXX)
		// parseXXX 메소드 실행할 때 인자가 데이터가 문자가 포함되어 있다면 NumberFormatException 발생
	}

}
