package day11a;

// 인터페이스  InterfaceA를 사용하는 구현 클래스 -> 객체 생성
public class MyClassA implements InterfaceA{
// 추상메소드는 반드시 구현
	
	@Override
	public void methodA() {
		// TODO 추상메소드 구현
		System.out.println("methodA!");
		
	}

	@Override
	public int methodB(int num) {
		// TODO 추상 메소드 구현
		System.out.println("methodB : " + num);
		return num;
	}

}
