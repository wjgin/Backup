package day11b;

public class SmartTVTest {
	public static void main(String[] args) {
		// 2개의 인터페이스를 구현하는 SmartTV 클래스를 테스트 합니다.
		
		// 인터페이스 타입으로 객체를 참조 가능
		// SmartTV는 3가지 타입을 가질 수 있음(인터페이스 2개, 클래스 1개)
		RemoteControl rc = new SmartTV();
		RemoteControl ad = new Audio();
		SmartTV sm = new SmartTV();	// 클래스 타입 참조

		rc.setVolume(12);
		ad.setVolume(12);
		workVolume(rc);	// 인터페이스 타입 인자로 메소드를 실행
		workVolume(sm);	
		
// 		workSearch(rc); 				// 오류 : 인자 타입 불일치
		WebSearch ws = (WebSearch) rc;	// 캐스팅으로 타입 변환 가능
		workSearch(ws);
		
		// 인터페이스를 가지는 클래스 자체를 생성해서 인자로 사용 가능
		System.out.println("메소드 인자에 직접 객체 전달하기");
		workVolume(new SmartTV());
		workSearch(new SmartTV());

	} // main end

	// 볼륨을 동작시키는 메소드 RemoteControl 타입
	public static void workVolume(RemoteControl rc) {	// 다형성
		rc.setVolume(12);
	}
	
	// 검색을 동작하는 메소드 WebSearch 타입
	public static void workSearch(WebSearch ws) {		// 다형성
		ws.search("https://www.naver.com");
	}
	
}
