package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// student.txt 를 생성하기
public class StringTokenTest2 {

	public static void main(String[] args) {
		String fname = "D:\\바탕화면\\beforCopy\\student.txt";
		File file = new File(fname);

		List<String> stus = new ArrayList<>();
		stus.add("모모 90 80 70");
		stus.add("마마 56 100 51");
		stus.add("무무 75 15 56");
		stus.add("머머 88 46 89");
		
		try {
			PrintWriter fwt = new PrintWriter(file);
			for (int i = 0; i < stus.size(); i++) {
				StringTokenizer stk = new StringTokenizer(stus.get(i));
				fwt.println((i+1)+"번 학생");
				while (stk.hasMoreTokens()) {
					fwt.print(stk.nextToken() + " ");
				} // while end
				fwt.print("\n\n"); // 줄 바꿈
			} // for end
			System.out.println("입력 완료");
			fwt.close();
		} catch (FileNotFoundException e) {
			System.out.println("경로를 확인하세요.");
			e.printStackTrace();
		}
		
		
	} // main end

}
