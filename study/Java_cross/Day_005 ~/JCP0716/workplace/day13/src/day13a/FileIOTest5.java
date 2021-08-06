package day13a;

// import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

// 표준 입출력 반복문 테스트
//파일 시스템 출력(바탕화면의  test.txt) -> 프로그램 -> 표준 출력
public class FileIOTest5 {

	public static void main(String[] args) {
		System.out.println("작성자 : 이우진 - 실행시간 테스트 합니다.");
		int b;
		byte[] buf = new byte[1024]; // 가장 버퍼 생성

		System.out.println("파일을 [1 바이트 단위로] 복사합니다.... ↓");

		try {
			Scanner sc = new Scanner(System.in);
			int count = 0;
			System.out.println("목적지 경로를 입력하세요.");
			String path = sc.nextLine();
			System.out.println("파일명을 입력하세요.");
			path = path + "\\" + sc.nextLine(); // 리터럴일 경우만 "\\" 입력 필요
			// path = path.replaceAll("\\\\", "\\\\\\\\");

			FileInputStream fis = new FileInputStream("D:\\바탕화면\\beforCopy\\testPictueText.txt");
			FileOutputStream fos = new FileOutputStream(path);

			long start = System.currentTimeMillis();
			while ((b = fis.read()) != -1) { // 입력 스트림을 파일로 변경
				count++;
				fos.write(b); // 문자기반의 메소드 출력
			} // while end

			long end = System.currentTimeMillis();
			System.out.println(":::" + count + "바이트 복사 되었습니다. :::");
			System.out.println("실행시간 " + (end - start) + " ms 소요 되었습니다.\n\n");
			fis.close(); // 사용한 파일을 모두 닫기 (스트림은 컬렉션처럼 재사용 불가)
			fos.close(); // 사용한 파일을 모두 닫기

			System.out.println("파일을 [1024 바이트 단위로] 복사합니다.... ↓");
			count = 0;
			start = System.currentTimeMillis();
			fis = new FileInputStream("D:\\바탕화면\\beforCopy\\testPictueText.txt");
			fos = new FileOutputStream(path);

			while ((b = fis.read(buf)) != -1) { // read() 읽은 바이트 크기를 리턴 (마지막 입력은 1024보다 작음)
				count += b; // b== 읽어온 바이트 크기(맨 마지막은 1024 이하)
				fos.write(buf, 0, b); // buf 배열에서 0인덱스부터 읽어온 크기(b) 만큼 fos파일에 출력
			} // while end

			end = System.currentTimeMillis();

			System.out.println(":::" + count + "바이트 복사 되었습니다. :::");
			System.out.println("실행시간 " + (end - start) + " ms 소요 되었습니다.");
			sc.close();
			fis.close();
			fos.close();

			// FileNotFoundException 와 관계
			// IOException이 상위 클래스 -> 우선 처리됨
			// 하위 클래스를 필요시, 윗줄에 정의(순서가 바뀌면 컴파일 오류)
			// 	ㄴ 상위 클래스가 윗줄이면 이미 처리되었기에 오류
		} catch (FileNotFoundException e) {
			System.out.println("선택한 파일의 경로 잘못 되었습니다. " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("입력 오류 : " + e.getMessage());
			e.printStackTrace();
		}

	} // main end

}
