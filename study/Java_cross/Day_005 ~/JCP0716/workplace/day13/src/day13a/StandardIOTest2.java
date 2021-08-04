package day13a;

import java.io.IOException;

// 표준 입출력 반복문 테스트
//표준 입력 -> 프로그램 -> 표준 출력
public class StandardIOTest2 {

	public static void main(String[] args) {

		int b;
		System.out.println("저장할 내용을 입력하세요. ↓");
		
		// char 2byte -> 한, 중,일 언어 3byte 영문, 숫자, 특수문자 1byte
		try {
			int count = 0;
			// 종료하려면 enter 입력후 cntrl + z
			while ((b = System.in.read()) != -1) {
				// 버퍼에서 가져올 때, 입력한 문자를 utf-8로 인코딩 
				// -> 한글 3바이트, 아스키 코드 1바이트
				// System.out.print((char) b); // 문자 인코딩 불가능
				//System.out.print(b);	// 1byte씩 읽어냄
				//System.out.println(" ");
				count++;
				System.out.write(b);	// 문자기반의 메소드 출력
			}
			System.out.println(":::" + count + "바이트 입력 :::");
			
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
