package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Student 객체를 저장한 ArrayList 데이터를 파일로 출력
public class PrintWriterTest2 {
	public static void main(String[] args) {
		
		// 사용할 파일 객체 생성
		String fname = "D:\\바탕화면\\beforCopy\\student.txt";
		File file = new File(fname);
		List<Student> stus = new ArrayList<>();
		stus.add(new Student("모모", 90, 80, 70));
		stus.add(new Student("마마", 98, 88, 77));
		stus.add(new Student("무무", 55, 44, 33));
		stus.add(new Student("머머", 45, 35, 85));
		stus.add(new Student("ㅓㅁㅓㅁ ", 78, 34, 75));
		
		try {
			PrintWriter fpw = new PrintWriter(file); // File 객체로 출력 파일 지정
			
			// 빠른 for문으로 출력
			for(Student stu : stus) {
				fpw.println(stu);
			}
			
			fpw.close();
			System.out.println("파일 출력이 완료되었습니다.");
		} catch (FileNotFoundException e) {
			System.out.println("파일 경로명 / 파일 확인하세요.");
			e.printStackTrace();
		}
		
		
	} // main end
}
