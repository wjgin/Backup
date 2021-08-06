package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerFileTest3 {
	public static void main(String[] args) {
		// 사용팔 파일 객체 생성
		String fname = "D:\\바탕화면\\beforCopy\\프린트테스트.txt";
		File file = new File(fname);
		
		List<Student> stus = new ArrayList<>();
		stus.add(new Student("모모", 90, 80, 70));
		stus.add(new Student("마마", 98, 88, 77));
		stus.add(new Student("무무", 55, 44, 33));
		stus.add(new Student("머머", 45, 35, 85));
		stus.add(new Student("ㅓㅁㅓㅁ ", 78, 34, 75));
		
		try {
			PrintWriter fpw = new PrintWriter(file);
			
			for(Student s : stus) {
				fpw.print(s);
				fpw.print(" ");
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
