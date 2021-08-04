package day13a;

import java.io.IOException;

// 표준 입출력 테스트
public class StandardIOTest {

	public static void main(String[] args) {

		int b, c, d, f, g;
		System.out.println("저장할 내용을 입력하세요. ↓");

		// 입력한 문자(아스키코드 값)를 정수로 리턴. 입력스트림에서 읽어올 것이 없으면 -1 리턴
		// read 메소드는 Exception 가능성이 있어 try ~ catch 필요
		// ㄴ throws IOException
		try {
			// ex) a입력 시
			// 아스키 코드 출력
			// ㄱ 입력시
			b = System.in.read(); // ㄱ 1byte 버퍼에서 읽어오기(없으면 사용자 입력 받음)
			c = System.in.read(); // ㄱ 1byte
			d = System.in.read(); // ㄱ 1byte
			f = System.in.read(); // \r
			g = System.in.read(); // \n

			System.out.write(b);
			System.out.write(c);
			System.out.write(d);
			System.out.write(f);
			System.out.write(g);
/*
			// 13(CR carriage return) + 10(LF line feed) => \\r 복귀 \\n 개행
			b = System.in.read();
			System.out.println(b); // 13 \r
			
			b = System.in.read();
			System.out.println(b); // 10 \n*/
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
