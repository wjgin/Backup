package com.jcp.day9b;

import java.util.Scanner;

public class AnimalCommunity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal[] aniArr = new Animal[10];

		aniArr[0] = new Puppy("브라운");
		aniArr[1] = new Cat();
		aniArr[1].setColor("그레이");
		aniArr[2] = new Rabbit();
		aniArr[2].setColor("화이트");

		System.out.println();
		System.out.println("[[반려동물 목록을 보여드리겠습니다.]]");
		for (int i = 0; i < aniArr.length; i++) {
			if (aniArr[i] != null)
				aniArr[i].sound(); // 다형성 구현한 메소드
		}
		System.out.println();

		{
			// 회원의 분양 가능 체크
			Member momo = new Member("모모", 17);
			if (momo.isAdopt(aniArr[1])) {
				System.out.println(momo.getName() + " 회원님은" + aniArr[1].getType() + " 분양이 가능 합니다 😎.");
			} else
				System.out.println(momo.getName() + " 회원님은 " + aniArr[1].getType() + " 분양이 조건이 맞지 않습니다 😂.");
			// aniArr는 Animal 타입 => TYPE 상수를 직접 받으면 Animal 클래스의 상수가 사용됨
			// => 하위 클래스에서 상수 값 변경 및 getter함수 오버라이딩
		}
		{
			Member nana = new Member("나나", 7);
			String type = null;
			// 서브 클래스에 따른 동물 종류 확인
			if (aniArr[2] instanceof Puppy)
				type = "강아지";
			else if (aniArr[2] instanceof Cat)
				type = "고양지";
			else if (aniArr[2] instanceof Rabbit)
				type = "토끼";

			if (nana.isAdopt(aniArr[2])) {
				System.out.println(nana.getName() + " 회원님은" + type + " 분양이 가능 합니다 😎.");
			} else
				System.out.println(nana.getName() + " 회원님은 " + type + " 분양이 조건이 맞지 않습니다 😂.");
		}
		{
			Scanner sc = new Scanner(System.in);
			int userInput;
			System.out.println();
			Member nunu = new Member("누누", 25);
			System.out.println(nunu.getName() + "님 분양받을 동물을 선택해주세요.");
			System.out.println("1.강아지\t 2.고양이 \t 3.토끼");
			System.out.print(">>> ");
			userInput = sc.nextInt() - 1;

			if (nunu.isAdopt(aniArr[2])) {
				System.out.println(nunu.getName() + " 회원님은 " + aniArr[userInput].getType() + " 분양이 가능 합니다 😎.");
			} else
				System.out.println(nunu.getName() + " 회원님은 " + aniArr[userInput].getType() + " 분양이 조건이 맞지 않습니다 😂.");
			sc.close();
		}

	} // main end

}
