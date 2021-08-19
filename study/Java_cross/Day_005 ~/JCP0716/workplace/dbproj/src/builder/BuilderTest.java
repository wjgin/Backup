package builder;

public class BuilderTest {

	public static void main(String[] args) {
		
		Buy b1 = new Buy();
		Buy b2 = new Buy(3, "aaa", "bbb");
		// Buy b3 = new Buy(3); // 오류 : 다양한 생성자를 작성하기 불편 -> Builder pattern 사용
		
		// builder를 이용한 다양한 필드 최적화 Buy static method 사용
		Buy b4 = Buy.builder().custom_id("momo").build();	// id필드만 초기화 하고 객체 생성
		Buy b5 = Buy.builder().product_code("SAMSUNG").build();
		Buy b6 = Buy.builder().buy_no(3).custom_id("TEST").build(); // 필드 두개를 초기화하고 객체 생성
		
		
		// builder로 초기값을 넣지 않은 값 =>  int = 0, String = null로 초기화
		System.out.println(b4);
		System.out.println(b5);
		System.out.println(b6);	
		
	}
	

}
