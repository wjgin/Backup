package day12a;

public class Test2 {
	InterfaceA ifa;							// 인터페이스 타입 필드
	InterfaceA[] ifas = new InterfaceA[10];	// 인터페이스 타입 배열,  참조할 배열의 크기만 선언
	
	void test() {
		ifas[0] = new MyClassA();			// 배열에 구현 클래스 객체 참조
	}
}
