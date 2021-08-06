package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// student2 txt 파일을 읽어와 STringTokenizer 객체를 한번만 생성해서 ArrayList
public class ScannerFileTest2 {
	public static void main(String[] args) {
		// 사용팔 파일 객체 생성
		String fname = "D:\\바탕화면\\beforCopy\\student2.txt";
		File file = new File(fname);

		List<Student> stus = new ArrayList<>();
		stus.add(new Student("모모", 90, 80, 70));
		stus.add(new Student("마마", 98, 88, 77));
		stus.add(new Student("무무", 55, 44, 33));
		stus.add(new Student("머머", 45, 35, 85));
		stus.add(new Student("ㅓㅁㅓㅁ ", 78, 34, 75));

		try {
			Scanner fsc = new Scanner(file);
			StringTokenizer stk = new StringTokenizer(fsc.nextLine());
				while (stk.hasMoreElements()) {
					System.out.println(stk.nextToken());
					stk = new StringTokenizer(fsc.nextLine());
			}
			fsc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
