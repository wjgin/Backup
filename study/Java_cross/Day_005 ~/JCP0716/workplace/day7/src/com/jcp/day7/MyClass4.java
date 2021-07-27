package com.jcp.day7;

import java.util.Arrays;

public class MyClass4 {

	// 필드 선언
	String name; // 참조 타입 변수
	int level;
	double[] point; // 참조 타입 변수

	// 기본 생성자는 인자가 없는 형식
	public MyClass4() {
		// 필드값을 참조타입 기본형 null, 수치 기본형 데이터는 0으로 초기화
	}
	
	// 생성자를 커스텀하게 정의 - 인자로 전달받은 값을 3개의 필드값으초기화
	public MyClass4(String name, int level, double[] point) {
		this.name = name;
		this.level = level;
		this.point = point;
	}
	
	public MyClass4(String name, int level) {	// 필요에 따라 두개의 필드 값만 초기화
		this.name = name;
		this.level = level;
	}
	
	// 아래의  setXXX 메소드는 값의 변경 용도
	// name 필드 값 저장하기
	void setName(String name) {
		this.name = name;
	}

	// level 필드 값을 저장
	void setLevel(int level) {
		this.level = level;
	}

	// point 필드 값(참조 값) 저장
	void setPoint(double[] point) {
		this.point = point;

	}
	
	void print() {
		System.out.println("name : " + name + "\tlevel : " + level + "\tpoint : " + Arrays.toString(point));
	}

}
