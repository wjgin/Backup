package day12a;

// interface의 형식
public interface InterfaceA {
	// 생성자는 없음 -> 객체를 직접 생성하지 않음
	// 필드는 상수만 가능 (기본 설정, public static final 생략)
	int SIZE = 100;
	
	// 메소드는 1) **abstract(기존 설정, public abstract 생략). 선언만 
	//		 2) instance(default), 3) static 세가지 사용 가능. 정의하여 사용
	
	// 1)
	void methodA();
	int methodB(int num);
	
	// 2) default 키워드는 default 한정자가 아닌 인스턴스 메소드의 의미
	default void methodC(String message) {
		System.out.println("메세지 수신 : " + message);
	}
	
	// 3) static 메소드는 인터페이스 이름으로 호출
	static void methodD() {
		System.out.println("나는 static 메소드");
	}
	
}
