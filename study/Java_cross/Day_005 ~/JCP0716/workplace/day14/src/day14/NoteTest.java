package day14;

import java.util.Scanner;

public class NoteTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("[나의 단어장]");
		MakeNote mk = new MakeNote();

		System.out.println(":::나의 단어장을 실행 합니다.:::");

		System.out.println("1.새로 시작하기\t2.이어서 시작하기");
		int firstUserAnswer = sc.nextInt();
		sc.nextLine();

		switch (firstUserAnswer) {
		case 1:
			System.out.println("단어장을 새로 시작 합니다.");
			System.out.println("기본 값 : " + mk.getFpath());
			System.out.print("단어장이 저장될 위치를 입력해주세요. >>> ");
			String fpath = sc.nextLine();
			
			System.out.println("\n기본 값 : " + mk.getFname());
			System.out.print("단어장의 이름을 입력하세요 >>> ");
			String fname = sc.nextLine();
			mk.makeWordNote(fname, fpath);
			System.out.println("단어장이 생성 되었습니다." + mk.getFile());
			break;
		case 2:
			System.out.println("단어장을 이어서 시작 합니다.");
			System.out.println("단어장이 저장된 위치를 입력해주세요.");
			mk.setFpath(sc.nextLine());
			System.out.println("단어장의 이름을 입력해주세요(확장자 제외)");
			mk.setFname(sc.nextLine());
			break;
		default:
			System.out.println(mk.getFpath() + " 에 위치한 " + mk.getFname() + "파일로 시작합니다.");
		}

		while (true) {
			int userAnswer;
			String fname = null, fpath = null;

			System.out.println("\n<<< 메뉴를 선택하세요. >>>");
			System.out.println("1.단어장 생성하기 \t 2.단어 추가하기 \t 3.단어 찾기 \t 4.단어장 변경하기 \t 5.종료하기");
			userAnswer = sc.nextInt();
			sc.nextLine();

			if (userAnswer == 1) {
				System.out.println("새로운 단어장을 생성 합니다.");
				if (mk.checkExistence()) {
					System.out.println("현재 경로 : " + mk.getFpath());
				} else
					System.out.println("선택된 경로가 없습니다.");

				System.out.print("파일 경로를 입력하세요 . 미 입력시 현재 경로를 덮어씌웁니다.>>> ");
				fpath = sc.nextLine();
				System.out.print("파일명을 입력하세요. 미 입력시 현재 파일명을 덮어씌웁니다.>>> ");
				fname = sc.nextLine();

				mk.makeWordNote(fname, fpath);

				if (mk.checkExistence()) {
					System.out.println("\n👏👏단어장이 생성 되었습니다.");
					System.out.println("현재경로 : " + mk.currentFilePath() + "\n");
				} else
					System.out.println("파일이 없습니다.");

			} else if (userAnswer == 2) {
				if (mk.checkExistence()) {
					String eng, kor;
					System.out.println("새로운 단어를 추가 합니다.");

					System.out.print("영단어를 추가해주세요. >>> ");
					eng = sc.nextLine();
					mk.setFname(eng);

					System.out.print("뜻을 입력해주세요.>>> ");
					kor = sc.nextLine();
					mk.setFpath(kor);

					mk.addWord(eng, kor); // 단어 추가 실행
					System.out.println("\n👏👏단어가 추가 되었습니다.");
					System.out.println("추가된 단어 : " + eng + " - " + kor + "\n");
				} else {
					System.out.println("단어장을 먼저 생성해주세요.");
				}
			} else if (userAnswer == 3) {
				System.out.print("찾을 단어를 입력하세요. >>> ");
				String word = sc.nextLine();
				System.out.println(mk.searchWord(word)); // 단어 찾기 실행

			} else if (userAnswer == 4) {
				Scanner csc = new Scanner(System.in);
				int changeNote;
				System.out.println("단어장을 변경 합니다.");
				System.out.println("현재 단어장 : " + mk.currentFilePath());
				System.out.print("변경하시겠습니까?\t1.예\t2.아니요  >>>");
				changeNote = csc.nextInt();

				switch (changeNote) {
				case 1: {
					System.out.print("파일 경로를 입력하세요 . 미 입력시 현재 경로를 선택합니다.>>> ");
					fpath = sc.nextLine();
					mk.setFpath(fpath);
					System.out.print("파일명을 입력하세요. 미 입력시 현재 파일명을 덮어씌웁니다.>>> ");
					fname = sc.nextLine();
					mk.setFname(fname);
					System.out.println("단어장이 선택 되었습니다. : " + mk.currentFilePath());
					break;
				}
				case 2: {
					System.out.println("기존 단어장을 사용합니다.");
					break;
				}
				default:
					System.out.println("잘못된 입력 입니다. 기존 단어장을 사용합니다.");
				}

			} else if (userAnswer == 5) {
				System.out.println("종료 합니다.");
				break;

			} else
				System.out.println("잘못된 입력 입니다.");
		} // while end
		sc.close();
	} // main end
}
