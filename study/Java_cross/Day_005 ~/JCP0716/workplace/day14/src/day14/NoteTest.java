package day14;

import java.util.Scanner;
public class NoteTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[나의 단어장]");
		MakeNote mk = new MakeNote();
		
		System.out.println(":::나의 단어장을 실행 합니다.:::");
		System.out.println("1.새로 시작하기\t2.기존 단어장 사용하기");
		int firstUserAnswer = sc.nextInt();
		sc.nextLine();
		
		switch(firstUserAnswer) {
		case 1:
			System.out.println("단어장을 새로 시작 합니다.");
			System.out.println("파일을 생성할 경로를 선택하세요.");
			mk.setFpath(sc.nextLine());
			break;
		case 2:
			System.out.println("단어장을 이어서 시작 합니다.");
			System.out.println("단어장이 위치한 입력해주세요.");
			mk.setFpath(sc.nextLine());
			System.out.println("단어장의 이름을 입력해주세요(확장자 제외)");
			mk.setFname(sc.nextLine());
			break;
		default :
			System.out.println(mk.getFpath() +" 에 위치한 " + mk.getFname() + "파일로 시작합니다.");
		} 
		
		while(true) {
			int userAnswer;
			System.out.println("\n<<< 메뉴를 선택하세요. >>>");
			System.out.println("1.단어장 생성하기 2. 새로운 단어 저장하기    3.단어장 확인하기    4.종료하기");
			userAnswer = sc.nextInt();
			sc.nextLine();
			
			if(userAnswer == 1) {
				String fname = null, fpath = null;
				System.out.println("새로운 단어장 생성 합니다.");
				System.out.print("파일명을 입력하세요 미 입력시 기본 값으로 설정 됩니다. >>> ");
				fname = sc.nextLine();
				System.out.print("파일 경로를 입력하세요 . 미 입력시 기본 값으로 설정 됩니다.>>> ");
				fpath = sc.nextLine();
				
				mk.makeWord(fname, fpath);
				
			}else if(userAnswer == 2) {
				String eng, kor;
				System.out.println("새로운 단어를 추가 합니다.");
				
				System.out.print("영단어를 추가해주세요. >>> ");
				eng = sc.nextLine();
				mk.setFname(eng);
				
				System.out.print("뜻을 입력해주세요.>>> ");
				kor = sc.nextLine();
				mk.setFpath(kor);
				
				mk.addWord(eng, kor);
			}else if(userAnswer == 3) {
				mk.searchWord();
			} else if(userAnswer == 4) {
				System.out.println(mk.getFpath() + mk.getFname());
				System.out.println("종료 합니다.");
				break;       
			} else System.out.println("잘못된 입력 입니다.");
		} // while end
		sc.close();
	} // main end
}
