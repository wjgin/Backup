package com.jcp.day10;

import java.util.Arrays;

// 메소드 오버로딩 확인
public class MethodTest {

	public static void main(String[] args) {
		// 1. Math 클래스의 메소드 중에서 메소드 오버로딩을 찾아봅시다.
		// 		ㄴ 메소드오버로딩 : 메소드 이릉과 실행 내용이 같지만, 인자와 반환 타입이 다를 수도 있음.
		//		ㄴ 메소드오버라이딩은 상속 관계에서만 사용
		int ires;
		ires = Math.min(12,  156);
		System.out.println(ires);
		
		// 2. Arrays 클래스 메소드 중에 오버로딩
		double[] dres = {23.45, 34.12, 7.8, 4.5, 3.14};
		// 인자 타입은 다르지만, 리턴 타입은 모두 같은 경우, 인자가 Object이면 모든 클래스를 참조 가능 -> 다형성
		System.out.println(Arrays.toString(dres));
		
		// 3. 대표적인 메소드 오버로딩 - 생성자(기본, 커스텀)
		
		// 4. 클래스 타입 배열로 Array.toString 테스트
		Member[] members = new Member[3]; // Member 타입 차조값 저장할 배열
		members[0] = new Member("보라돌이", 7);
		members[1] = new Member("뚜비", 5);
		members[2] = new Member("나나", 4);
		System.out.println("Object 타입 배열로 Arrays.toString 실행 결과");
		System.out.println(Arrays.toString(members)); // => member[index].toString 이 생략된 형태   
		// out : [com.jcp.day10.Member@5fdef03a, com.jcp.day10.Member@3b22cdd0, com.jcp.day10.Member@1e81f4dc]
		// 참조값이 출력
		// 필드값 출력으로 변경하기 위해서 Object 클래스에서 상속받은 toString 메소드를 재정의
		System.out.println(members);	// member.toString : 배열의 toString => 주소값 출력
		System.out.println(members[0]); // members[0].toString : Member 클래스의 toString 재정의 => 필드 값 출력 
		
	} // main end

}
