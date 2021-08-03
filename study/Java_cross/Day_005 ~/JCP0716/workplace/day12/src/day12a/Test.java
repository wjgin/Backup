package day12a;

// 추상 클래스는 상속으로 하위 클래스 사용, 인터페이스는 구현 클래스 사용
// 공통점 : 추상 메소드를 포함 => 익명 클래스
public class Test {

	public static void main(String[] args) {
		// InterfaceA를 익명(Anonymous) 클래스 구현으로 객체 생성 -> 스레드 프로그래밍에서 활용
		InterfaceA ifa = new InterfaceA() {	// 임시로 한번만 사용하는 인터페이스 구현체
			
			@Override
			public int methodB(int num) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public void methodA() {
				// TODO Auto-generated method stub
				
			}
		};

	}

}
