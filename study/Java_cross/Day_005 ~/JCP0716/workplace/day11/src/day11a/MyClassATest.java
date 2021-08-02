package day11a;

public class MyClassATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 구현 클래스 객체 생성
		MyClassA my = new MyClassA();
		
		// 인터페이스 상수 출력
		System.out.println(InterfaceA.SIZE);
		
		// 구현 클래스 상수 출력
		System.out.println(MyClassA.SIZE);
		
		// 메소드 호출
		my.methodA();		// 추상 메소드
		my.methodB(23);		// 추상 메소드
		my.methodC("hi");	// Interface의 default 메소드
		
		// static 메소드는 인터페이스 이름으로 호출
		InterfaceA.methodD();
	}

}
