package day13a;

// import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.IOException;

// 표준 입출력 반복문 테스트
//파일 시스템 출력(원본 폴더) -> 프로그램 -> 파일 출력(다운로드 경로에 복사)
public class FileInputTest4 {

	public static void main(String[] args) {

		int b;
		System.out.println("파일에서 입력 받은 내용을 출력 합니다.... ↓");
		try {
			int count = 0;
			FileInputStream fis = new FileInputStream("D:\\바탕화면\\test.txt");
			// 파일이 없으면 오류 발생 FileNotFoundException
			while ((b = fis.read()) != -1) { // 입력 스트림을 파일로 변경
				count++;
				System.out.write(b);	// 문자기반의 메소드 출력
				
			}
			System.out.println(":::" + count + "바이트 입력 :::");
			fis.close();
			// FileNotFoundException 와 관계
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();
		} 

	}

}
