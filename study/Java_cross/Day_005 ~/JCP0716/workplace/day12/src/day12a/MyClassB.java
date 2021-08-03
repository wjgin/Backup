package day12a;

// public abstract class MyClassB implements InterfaceA{
	// 인터페이스의 추상 메소드를 구현하지 않고 추상 클래스로 만듦
	// MyClassB를 상속하는 하위 클래스에서 추상 메소드를 구현해야함
	
	// 사용 이유: 추상 클래스에서는 클래스의 공통사항을 필드로 선언가능
	//		ㄴ InterfaceA에서는 상수와 추상 메소드만 객체 생성에 활용

public class MyClassB extends MyClassA{
	// 인터페이스를 갖는 클래스A를 상속 받은 클래스B
	@Override
	public void methodC(String message) {
		// TODO Auto-generated method stub
		System.out.println("재정의");
	}
}
