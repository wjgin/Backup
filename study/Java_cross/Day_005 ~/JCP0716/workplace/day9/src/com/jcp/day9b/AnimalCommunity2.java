package com.jcp.day9b;

import java.util.Scanner;

public class AnimalCommunity2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name;
		int age;
		int userInput;
		System.out.println("환영합니다.");
		System.out.print("이름  >>> ");
		name = sc.nextLine();
		System.out.print("나이 >>> ");
		age = sc.nextInt();
		
		Animal[] aniArr = new Animal[10];

		aniArr[0] = new Puppy("브라운");
		aniArr[1] = new Cat();
		aniArr[1].setColor("그레이");
		aniArr[2] = new Rabbit();
		aniArr[2].setColor("화이트");

		// 익명 클래스(Anonymous) 추상 클래스를 가져와서 바로 정의(별도의 하위 클래스 이름이 없음)
		aniArr[3] = new Animal() {
			
			static final String TYPE = "쥐";
			
			@Override
			public void sound() {
				// TODO Auto-generated method stub
				System.out.println(this.getName() + " 쥐는 찍찍하고 웁니다.");
			}
			
			public String getType() {
				return TYPE;
			}
		};
		
		System.out.println(aniArr[3].getType());
		
		System.out.println();
		System.out.println("[[반려동물 목록을 보여드리겠습니다.]]");
		for (int i = 0; i < aniArr.length; i++) {
			if (aniArr[i] != null)
				aniArr[i].sound(); // 다형성 구현한 메소드
		}
		
		System.out.println("1.강아지\t 2.고양이 \t 3.토끼");
		System.out.print(">>> ");
		userInput = sc.nextInt() - 1;

		Member user = new Member(name, age);

		if (user.isAdopt(aniArr[2])) {
			System.out.println(user.getName() + " 회원님은 " + aniArr[userInput].getType() + " 분양이 가능 합니다 😎.");
		} else
			System.out.println(user.getName() + " 회원님은 " + aniArr[userInput].getType() + " 분양이 조건이 맞지 않습니다 😂.");
		sc.close();

	} // main end

}
