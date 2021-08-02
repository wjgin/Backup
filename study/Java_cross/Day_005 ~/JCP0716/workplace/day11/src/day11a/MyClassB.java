package day11a;

// interface를 다중으로 사용하는 구현 클래스
public class MyClassB implements InterfaceA, InterfaceX {

	// InterfaceA의 추상 메소드 구현
	@Override
	public void methodA() {
		// TODO Auto-generated method stub

	}

	@Override
	public int methodB(int num) {
		// TODO Auto-generated method stub
		return 0;
	}

	// InterfaceX의 추상 메소드 구현
	@Override
	public String methodX() {
		// TODO Auto-generated method stub
		return null;
	}
}
