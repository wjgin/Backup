package com.jcp.day1;

public class DataTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num1 = 3.1417;	//8byte
		//실수는 double이 기본. 실수를 리터럴로쓸 때 f를 붙여 float으로 지정
		float num2 = 3.1417f;	//4byte
		// 소스파일 안에서 직접 데이터를 쓸 때, 리터럴이라고 함.
		System.out.println(num1);
		System.out.println(num2);
		
		num1 = 2.456;
		num2 = 101.3465f;
		System.out.println(num1);
		System.out.println(num2);
		
		System.out.println(":::Double 클래스로 데이터타입 정보확인-double :::");
		System.out.println("doble 변수의 크기 : " + Double.BYTES + " 바이트"); // Double 클래스의 BYTES 필드
		System.out.println("doble 변수의 최대값 : " + Double.MAX_VALUE);
		System.out.println("doble 변수의 최소값 : " + Double.MIN_VALUE);
		System.out.println();
		
		System.out.println(":::Float 클래스로 데이터타입 정보확인-float :::");
		System.out.println("float 변수의 크기 : " + Float.BYTES + " 바이트");
		System.out.println("float 변수의 최대값 : " + Float.MAX_VALUE);
		System.out.println("float 변수의 최소값 : " + Float.MIN_VALUE);
		System.out.println();
		
		// float과 double의 차이점은 소숫점이하의 자릿수 표시 정도: 정밀도
		// float 7자리 / double 16 자리까지 정밀
		
	}

}
