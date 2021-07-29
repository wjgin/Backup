package com.jcp.day9a;


// 추상클래스 : 부모클래스로 사용됨. new 연산자로 객체 직접 생성 불가능
//			abstract메소드 존재
// 추상 : 구체화되지 않은 상태, 추상클래스는 공통점으로 구성된 상태
// 구체화 : 자식클래스가 구체화하여 객체 생성
public abstract class AShape {

		private String shapeName;
		private int width;			// 도형의 너비
		private int height;			// 도형의 높이

		public AShape() {
		}
		
		public AShape(String shapeName, int width, int height) {
			this.shapeName = shapeName;
			this.width = width;
			this.height = height;
		}
		
		// 추상 메소드 선언. 메소드 실행 내용 정의가 없음
		// 하위 클래스가 실행 내용 정의. 구체화 되었을때, 실행내용이 다를 경우
		//	ㄴ 추상메소드는 오버라이딩을 강제한다.
		public abstract int getArea();
		
		// 일반 인스턴스 메소드
		String getShapeName() {
			return shapeName;
		}
		int getWidth() {
			return width;
		}
		int getHeight() {
			return height;
		}
		
		
		
} // end
