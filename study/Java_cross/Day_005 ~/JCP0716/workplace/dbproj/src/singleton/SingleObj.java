package singleton;

// 이 클래스는 객체를 1개만 생성해서 공유하도록 생성자와 메소드를 수정
// 프로그램 실행시  클래스가 메모리에 로드 -> 클래스와 static이 저장되는 영역 : 메소드
// 객체가 저장되는 heap 영역
public class SingleObj {
	
	private static SingleObj obj = new SingleObj();	// 1) obj 타입은 자기 자신 클래스 타입 & 객체 생성 
													// -> 이른 초기화
													// 한번의 생성으로 계속 사용하기 위해서(클래스가 로드 되는 순간 생성, 같은 패키지내에 있으면 바로 생성됨)
	private SingleObj() {
		// 2) 생성자 private : 다른 클래스에서 new SingleObj()할 수 없음
	}
	
	public static SingleObj getInstance() {	// 3) 자기 자신 타입 객체 리턴
		return obj;	// 항상 같은 객체를 리턴
	}
	
	public void print() {
		System.out.println("싱클톤 객체 연습...");
	}
	
}
