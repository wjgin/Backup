package com.jcp.day10;

import java.util.ArrayList;

// 컬렉션 - 자료구조. 많은 양의 데이터를 저장하는 형식 --> 데이터를 수정 / 삭제 등의 알고리즘 구현
public class ArrayListTest {
	public static void main(String[] args) {
		
		 int[] datas = {1, 5, 7, 9, 11};
		 int[] datas2 = new int[100];	// 400 바이트
		 
		 // 1) 만약 datas 배열에서 index 2번 값 7을 삭제 --> {1, 5, 9, 11}
		 // --> ArrayList 클래스로 해결
		 // 2) 배열의 타입 : int, double, byte, char, short, long, float, Object 타입
		 // --> ArrayList 도 배열처럼 타입을 반영해야함 : 제너릭 타입<>으로 구현
		 
		 // ArrayList 사용
		 ArrayList<Member> members = new ArrayList<>();
		 ArrayList<Integer> idatas = new ArrayList<>();	// 기본형 타입 ArrayList
		 
		 idatas.add(123);	// 첫번 째 데이터 123 추가
		 idatas.add(567);	// 두번 째 데이터 567 추가
		 idatas.add(23);
		 idatas.add(1, 555);	// 1번 인덱스에 555 데이터 추가
		 System.out.println(idatas);

		 // 배열과의 차이
		 System.out.println("리스트의 크기 : " + idatas.size()); // length가 아닌 size() 메소드 사용
		 for(int x : idatas) System.out.print(x + "  ");
		 System.out.println();
		 System.out.println(idatas);	// toString이 이미 오버라이딩 되어있음
		 System.out.println();
		 // 리스트 인덱스 사용
		 System.out.println("인덱스 사용해서 특정 위치 값 가져오기");
		 System.out.println("1번 인덱스 값 : " + idatas.get(1));
		 System.out.println();
		 // 리스트 데이터 삭제 : 인덱스 값 또는 데이터 값으로 삭제
		 System.out.println("1번 인덱스 값 삭제하기");
		 idatas.remove(1);
		 System.out.println(idatas);
		 System.out.println();
		 
		 // members 출력
		 System.out.println("mebers 출력해보기 ");
		 members.add(new Member("보라돌이", 5000));	// Member타입의 객체 생성 및 리스트에 추가
		 members.add(new Member("뚜비", 4000));
		 members.add(new Member("나나", 3000));
		 System.out.println(members);
		 System.out.println("뽀가 뚜비의 자리를 차지 합니다.");
		 members.remove(1);							// 1번 인덱스의 데이터 삭제
		 members.add(1, new Member("뽀", 999));		// 1번 인덱스에 새로운 객체 추가
		 System.out.println(members);
	}
}
