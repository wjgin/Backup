package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MakeNote {

	private String fname = "test";
	private String fpath = "D:\\바탕화면\\beforCopy";
	private File file = new File(fpath + "\\" + fname + ".txt");
	private PrintWriter fpw;

	// 단어장 생성하기
	public void makeWord(String fname, String fpath) {
		try {
			setFname(fname);
			setFpath(fpath);
			fpw = new PrintWriter(file);
			fpw.println("[[나의 단어장]]");
			fpw.println("::단어\t\t뜻::");
			fpw.close();
			System.out.println("👏👏단어장이 생성 되었습니다.");
			System.out.println("현재경로 : " + getFpath() + "\\" + getFname() + "\n\n");
		} catch (IOException e) {
			System.out.println("잘못된 파일 경로입니다. 경로를 다시 확인하세요.");
			e.printStackTrace();
		}
	}

	// 단어 추가하기
	public void addWord(String eng, String kor) {
		try {
			PrintWriter fpw = new PrintWriter(new FileWriter(file, true));
			fpw.println(eng + "\t\t" + kor);
			System.out.println("👏👏단어가 추가 되었습니다.");
			System.out.println("추가된 단어 : " + eng + " - " + kor + "\n");
			fpw.close();
		} catch (IOException e) {
			System.out.println("잘못된 입력 입니다.");
			e.printStackTrace();
		}

	}

	// 단어장 확인하기
	public void searchWord() {
		try {
			Scanner fsc = new Scanner(file);
			Scanner wsc = new Scanner(System.in);
			Boolean find = false;
			String line;
			System.out.print("찾을 단어를 입력하세요. >>> ");
			String word = wsc.nextLine();
			try {
				while (!find) { // 단어를 찾지 못했을 동안 반복
					if (fsc.hasNextLine()) { // 파일에 줄이 있다면
						line = fsc.nextLine(); // 줄대입
						// 토큰으로 단어별 검사
						StringTokenizer stk = new StringTokenizer(line);
						while (stk.hasMoreTokens()) { // 토큰이 존재하는 동안
							if (stk.nextToken().equals(word)) { // 동일한 단어 존재시 출력
								System.out.println("↓↓ 찾은 단어");
								System.out.println(line);
								find = true; // 동일 단어 존재시 전체 루프 탈출
								break;
							} 
						} // stk while end
					} else break; // 마지막 줄까지 못찾을 때, 전체 루프 탈출
				} // while end
				// 오류 처리 : 요소가 없을 때,
			} catch (NoSuchElementException e) {
				System.out.println("\n해당하는 단어가 없습니다.");
				// fsc.close();
				// wsc.close();
			}
			// 마지막까지 단어를 찾지 못했다면 출력
			if(!find) System.out.println("해당 단어가 없습니다.✋✋");
			// 오류처리 : 해당 파일이 존재하지 않을 때,
		} catch (FileNotFoundException e) {
			System.out.println("존재하지 않는 파일 입니다.");
			e.printStackTrace();
		}
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		if (fpath.length() > 0)
			this.fname = fname;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		if (fpath.length() > 0)
			this.fpath = fpath;
	}

}
