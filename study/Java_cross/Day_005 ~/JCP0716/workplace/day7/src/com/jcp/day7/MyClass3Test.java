package com.jcp.day7;

import java.util.Arrays;

public class MyClass3Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass3 mc  = new MyClass3();
		
		// 객체 필드 값 저장하기
		mc.name = "블라블라"; // 필드값 직접 저장
		mc.setName("박이름"); // 메소드를 이용한 변수 저장
		mc.setLevel(10);
		
		// double[] 변수를 생성
		double[] point = new double[5];
		mc.setPoint(point);
		
		// double[] 변수 생성을 생략하고 직접 입력
		mc.setPoint(new double[3]);
		mc.point[1] = 10.1;
		System.out.println(Arrays.toString(mc.point));
	}

}
