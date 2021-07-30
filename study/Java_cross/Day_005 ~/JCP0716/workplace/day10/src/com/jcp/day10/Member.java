package com.jcp.day10;

public class Member {
	private String name;
	private int age;

	
	// 생성자 오버로딩 => 커스텀 생성자 정의시 인자 개수와 형식이 달라짐
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}

	// Object 클래스의 자동상속으로 -->  Object 메소드 중 재정의 연습
	@Override
	public String toString() {
		// return super.toString(); Object 클래스의 실행내용
		return "[이름 : " + name +  ", 나이 : " + age + "]";
	}
	
	
}
