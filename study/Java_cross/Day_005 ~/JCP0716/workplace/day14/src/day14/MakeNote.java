package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MakeNote {

	private String fpath = ".\\"; // null
	private String fname = "myTest"; // null;
	private File file;
	private PrintWriter fpw;
	
	// 단어장 생성하기
	public void makeWordNote(String fname, String fpath) {
		try {
			setFname(fname);
			setFpath(fpath);
			File folder = new File(getFpath());
			if (!folder.exists()) {
				folder.mkdirs();
			}
			setFile();
			fpw = new PrintWriter(getFile());
			fpw.println("[[나의 단어장]]");
			fpw.println("::단어\t\t::뜻");
			fpw.close();
		} catch (IOException e) {
			System.out.println("잘못된 파일 경로입니다. 경로를 다시 확인하세요.");
			// e.printStackTrace();
		}
	}

	// 단어 추가하기
	public void addWord(String eng, String kor) {
		try {
			PrintWriter fpw = new PrintWriter(new FileWriter(getFile(), true));
			fpw.println(eng + "\t\t" + kor);
			fpw.close();
		} catch (IOException e) {
			System.out.println("잘못된 입력 입니다.");
			e.printStackTrace();
		}
	}
	
	// 단어장 전체 출력
	public void printAllWords() {
		try {
			Scanner fsc = new Scanner(getFile());
			while (fsc.hasNextLine()) { // 파일에 줄이 있다면
				System.out.println(fsc.nextLine()); // 한 줄 출력
			} // fsc while end
		} catch (NullPointerException e) {
			System.out.println("단어장을 먼저 생성해 주세요.");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("존재하지 않는 파일 입니다.");
			e.printStackTrace();
		}
	}

	// 단어 찾기
	public String searchWord(String word) {
		String result = "찾는 단어가 없습니다.";
		try {
			Scanner fsc = new Scanner(getFile());
			fsc.next(); // 첫 줄 건너띄기
			fsc.next(); // 둘 째 줄 건너띄기
			while (fsc.hasNextLine()) { // 파일에 줄이 있다면
				String line = fsc.nextLine();
				// 토큰별 검사
				StringTokenizer stk = new StringTokenizer(line);
				while (stk.hasMoreTokens()) { // 토큰이 존재하는 동안
					if (stk.nextToken().equals(word)) { // 동일한 단어 존재시 출력
						result = line;
						return line;
					} else continue;
				} // stk while end
			} // fsc while end
		} catch (NullPointerException e) {
			System.out.println("단어장을 먼저 생성해 주세요.");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("존재하지 않는 파일 입니다.");
			e.printStackTrace();
		}
		return result;
	}


	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		if (fname.length() > 0)
			this.fname = fname;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		if (fpath.length() > 0)
			this.fpath = fpath;
	}

	public File getFile() {
		//setFile();
		return file;
	}

	public void setFile() {
		this.file = new File(getFpath() + "\\" + getFname() + ".txt");
	}

}
