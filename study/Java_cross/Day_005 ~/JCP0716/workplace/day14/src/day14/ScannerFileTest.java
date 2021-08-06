package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) {
		// 사용팔 파일 객체 생성
		String fname = "D:\\바탕화면\\beforCopy\\프린트테스트.txt";
		File file = new File(fname);
		
		try {
			Scanner fsc = new Scanner(file);	// 지정된 File 객체에서 문자열을 읽어옴
			
			System.out.println(fsc.nextLine());	// 라인 단위로 읽어 옴
			
			// hasNext() - Iterator 반복자 인터페이스의 추상메소드. 토큰은 단위 데이터. 반복자는 다음 토큰을 접근하는 메소드
			while(fsc.hasNext()) { // 읽어 올 다음 데이터(토큰)가 있는지 검사
				System.out.println(fsc.nextLine());
			} // while end
			
			fsc.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
