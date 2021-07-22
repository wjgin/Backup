package com.jcp.day4;

// 다양한 데이터 활용을 위해서 Math 클래서를 사용합니다.
// Math 클래스: 수학적인 기능을 메소드로 제공합니다.(랜덤 값 생성, 반올림)
public class MathTest {

	public static void main(String[] args) {
		// 데이터 생성 : 1) 코드에서 리터럴 사용 int num = 10;
		// 2) 사용자 키보드 입력

		System.out.println("랜덤 값 생성합니다........");
		System.out.println(Math.random()); // 랜덤 값의 범위 : 0 ~ 1 사이 실수(double)
		System.out.println(Math.random());
		System.out.println(Math.random());
		System.out.println(Math.random() * 100);
		System.out.println(Math.random() * 100);
		
		System.out.println("--- floor, round 메소드 사용하기 ---");
		double temp = Math.random();	// 난수 생성 후 저장
		System.out.println(temp);
		System.out.println(Math.floor(temp* 100));	// 소숫점 이하 버림 (소숫점 자리 남음)
		System.out.println(Math.round(temp* 100));	// 소숫점 반올림 (정수형 리턴 : 인자타입에 따른  리턴 값 형식 :(int or long))
		temp = 123.567;
		long test = Math.round(temp * 100);	// Math.round(double) -> return long
		System.out.println(test);	// 12356.7의 반올림 후 정수 타입으로 변경
		
		// 1 ~ 45 정수 값
		// a부터 ~ b 중 랜덤 값 출력 => Math.radome() * (b -a + 1) + a
			
			
			
		// 클래스 구성 : 필드, 메소드
		// 1) 클래스 메소드 : ex): 클래스이름.random()
		// 2) 인스턴트 메소드 ex): 객체참조변수.nextInt()
		// 메소드의 형식 : 인자(메소드 실행 요구 값), 리턴 값(메소드 실행 결과 값)
		// 
	}

}
