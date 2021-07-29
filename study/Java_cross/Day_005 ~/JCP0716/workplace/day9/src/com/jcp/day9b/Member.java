package com.jcp.day9b;

public class Member{

	private String name;
	private int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	boolean isAdopt(Animal animal) {
		// 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상 분양받을 수 있습니다.
		// Animal 타입이 실제 객체 타입 -> unknown
		// instanceof : 실제 객체를 검사하는 연산. 추상클래스 상속객체 확인
		if(animal instanceof Puppy && age >= 15) return true;
		else if(animal instanceof Cat && age >= 18) return true;
		else if(animal instanceof Rabbit && age >= 13) return true;
		else return false;
	}

	public String getName() {
		return name;
	}
	
	
}
