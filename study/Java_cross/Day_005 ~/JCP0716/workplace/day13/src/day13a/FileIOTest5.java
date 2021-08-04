package day13a;

// import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// 표준 입출력 반복문 테스트
//파일 시스템 출력(바탕화면의  test.txt) -> 프로그램 -> 표준 출력
public class FileIOTest5 {

	public static void main(String[] args) {

		int b;
		long start = System.currentTimeMillis();
		byte[] buf = new byte[1024]; // 가장 버퍼 생성
		
		System.out.println("파일에서 입력 받은 내용을 출력 합니다.... ↓");
		try {
			Scanner sc = new Scanner(System.in);
			int count = 0;
			System.out.println("경로 입력");
			//String path = sc.nextLine();
			//path = path.replaceAll("\\\\", "\\\\\\\\");
		
			FileInputStream fis = new FileInputStream("D:\\바탕화면\\beforCopy\\testPictueText.txt");
			FileOutputStream fos = new FileOutputStream("D:\\바탕화면\\afterCopy\\textToJpg(copied).jpg ");
			// 파일이 없으면 오류 발생 FileNotFoundException
			//while ((b = fis.read()) != -1) { // 입력 스트림을 파일로 변경
			while ((b = fis.read(buf)) != -1) {	// byte 배열 buf의 크기 만큼 읽기
				count++;
				//fos.write(b);	// 문자기반의 메소드 출력
				fos.write(buf, 0, b);	// buf 배열의 크기 만큼 쓰기
			}
			long end = System.currentTimeMillis();
			System.out.println(":::" + (count * 1024) + "바이트 입력 :::");
			fis.close();
			fos.close();
			System.out.println("복사 완료");
			System.out.println("실행시간 " + (end - start) + " ms 소요 되었습니다.");
			// FileNotFoundException 와 관계
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();
		}

	}

}
