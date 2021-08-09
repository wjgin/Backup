package day15.mydict1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// 메소드 생성 연습 : 파일에서 읽어오기, 파일에 저장하기, 단어 추가하기, 단어 전체 보기
public class MyDIctApp_ListTest {
	static Scanner sc = new Scanner(System.in);
	static List<Word> mydicts = new ArrayList<>(); // 단어장 역할을 하는 컬렉션(List)

	public static void main(String[] args) {
		String filename = "D:\\바탕화면\\listDict.txt"; // 사용자 선택 영역(main 메소드 영역 안에서 선언)
		boolean flag = true;
		try {
			dictRead(filename);
		} catch (FileNotFoundException e1) {
			System.out.println(filename + " 파일이 존재하지 않습니다.");
		}
		while (flag) {
			System.out.println("----------------------------------------------- ");
			System.out.println("1.새로운 단어 추가     2.저장된 단어 전체보기     3.파일에 저장    4.프로그램 종료     ");
			System.out.println("------------------------------------------------ ");
			System.out.print("선택 : ");

			String sel = sc.nextLine();

			switch (sel) { // if로 한다면 sel을 equals메소드로 비교해야함
			case "1": // switch 문에서 문자열 사용 가능
				wordAdd();
				break;
			case "2":
				wordList();
				break;
			case "3":
				try {
					dictsSave(filename);
				} catch (FileNotFoundException e) { 
				System.out.println("선택한 폴더 위치가 잘못되었습니다.");
				}					
				
				break;
			case "4":
				System.out.println("프로그램 종료");
				flag = false;
				break;
			default:
				break;
			} // switch end

		} // while end

	} // main end

	private static void dictRead(String filename) throws FileNotFoundException {
		Scanner fsc = null;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		File file = new File(filename);	// 파일이 없으면 익셉션
		fsc = new Scanner(file);
		
		while(fsc.hasNextLine()) {
			sb.append(fsc.nextLine()).append(" → ");
		} // while end

		st = new StringTokenizer(sb.toString(), " → ");
		List<String> kor;
		
		while(st.hasMoreTokens()) {
			Word w = new Word(st.nextToken());
			String temp = st.nextToken();	// koreans 필드값 -> List<String>
			temp = temp.substring(1, temp.length()-1); 	//[, ] 제거
			// kor = Arrays.asList(temp.split(", ")); // split을 이용해 배열로 만든 뒤 asList로 리스트 객체로 만들기
													// 스트링을 리스트 객체로 바로 만들 수 없음
			kor = new ArrayList<>(Arrays.asList(temp.split(", "))); // 가변 길이 리스트로 생성 합니다.(고정길이)
			// array -> ArrayList => new ArrayList<>(Arrays.asList(배열))
			w.setKoreans(kor);
			mydicts.add(w);	// 리스트에 w객체(영, 한) 추가
		}
		fsc.close();
		
	}

	// mydicts 리스트를 filename을 인자로 파일로 저장합니다. - 인셉션 처리 방법1
	private static void dictsSave1(String filename) { // filename이 존재하지 않으면 파일을 자동 생성
		try {
			PrintWriter pw = new PrintWriter(filename);
			for (int i = 0; i < mydicts.size(); i++) {
				pw.println(mydicts.get(i)); // toString 생략
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// mydicts 리스트를 filename을 인자로 파일로 저장합니다. - 익셉션 처리 방법2 : 현재 메소드에서 익센션 처리하지 않고 호출한
	// main 메소드로 처리를 넘김
	private static void dictsSave(String filename) throws FileNotFoundException { // filename이 존재하지 않으면 파일을 자동 생성
		
		PrintWriter pw = new PrintWriter(filename);
		for (Word w : mydicts)
			pw.println(w); // toString 생략

		pw.close(); // 안닫으면 출력 안됨
	}

	// mydicts 모두 보기
	private static void wordList() {
		for (Word w : mydicts)
			System.out.println(w);
	}

	// 단어 추가 메세소드
	private static void wordAdd() {
		System.out.println("[새로운 단어를 추가] 입니다.");
		do {
			System.out.print("English : ");
			String eng = sc.nextLine().trim(); // 입력 후 양 끝 공백 제거
			System.out.println("우리말 뜻 : ");
			String kor = sc.nextLine().trim();

			// 지금 입력된 eng가 단어 mydicts 리스트에 있는지?
			int index = -1;
			for (int i = 0; i < mydicts.size(); i++) {
				// w객체의 english 필드와 eng 비교하기
				if (mydicts.get(i).getEnglish().equals(eng)) {
					index = i;
					break;
				}
			} // for end

			// mydisct 리스트에서 Word객체 추가 - 필드 값 eng, kor
			if (index == -1) {
				List<String> koreans = new ArrayList<>();
				koreans.add(kor);
				mydicts.add(new Word(eng, koreans));
			} else {
				if (!mydicts.get(index).getKoreans().contains(kor))
					mydicts.get(index).getKoreans().add(kor);
			}

			// mydicts에 이미 eng가 존재할 떄, -> 새로운 뜻으로 입력됨

			System.out.print("단어 추가를 계속하시겠습니까?? (y/n) >>> ");
		} while (sc.nextLine().toLowerCase().equals("y")); // y가 아니면 종료

	} // wordAdd end

}