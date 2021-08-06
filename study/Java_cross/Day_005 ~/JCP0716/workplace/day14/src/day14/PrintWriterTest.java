package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// 문자열을 라인 단위로 파일 출력하는 println test
// 파일을 저장할 때, 문자열로 전달 못하고 File 클래스 객체로 전달
public class PrintWriterTest {
	public static void main(String[] args) {
		
		// 사용팔 파일 객체 생성
		String fname = "D:\\바탕화면\\beforCopy\\프린트테스트.txt";
		File file = new File(fname);
		
		try {
			PrintWriter fpw = new PrintWriter(file); // File 객체로 출력 파일 지정
			fpw.println("뚜비 90 88 79");
			fpw.println("나나 87 82 93");				// 실제로는 ArrayList 크기 만큼 반복
			fpw.close();
			System.out.println("파일 출력이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로명 / 파일 확인하세요.");
			e.printStackTrace();
		}
		
		
	} // main end
}
