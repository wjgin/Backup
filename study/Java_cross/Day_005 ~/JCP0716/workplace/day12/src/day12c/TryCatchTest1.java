
package day12c;

/*
예외처리 Exception
잘못된 문법 : 컴파일 불가능
정상 컴파일 후 JVM 실행 -> 오류 발생(Exception) -> try{...}, catch{...}
자바는 Exception을 클래스로 처리 -> 오류 내용에 따라 Exception객체가 생성됨 
*/
public class TryCatchTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = null;
		// message = "hello";
		boolean result = false;
		try {
		result = message.equals("hello");	// null 객체가 equals 실행 불가
		
		} catch (Exception e) {
			// NullPointerException이 발생해서 NullPointerException 객체가 생성 -> 변수 e로 참조
			// Exception e: 모든 Exception 처리
			// NullPointerException: NullPointerException 만 처리
			System.out.println("exception이 발생했습니다." + e.getMessage());
														// ㄴ e 개체의 필드 값 중 오류 메세지 출력
			e.printStackTrace(); // 오류 원인 추적하고 출력
		} 
		if(message != null && result)
			System.out.println("원하는 메세지");
		else if((message != null && !result))
			System.out.println("원치않는 메세지");

		System.out.println("끝");
	}

}
