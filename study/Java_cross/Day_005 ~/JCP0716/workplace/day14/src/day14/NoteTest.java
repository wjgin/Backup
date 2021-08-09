package day14;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NoteTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MakeNote mk = new MakeNote();
		// 처음 시작하기
		System.out.println(":::::나의 단어장을 실행 합니다.:::::");
		boolean firstLoop = true;
		while (firstLoop) {
			try {
				System.out.println("1.새로 시작하기\t2.단어장 불러오기");
				int firstUserAnswer = sc.nextInt();
				sc.nextLine();
				// 새로 시작하기, 단어장 불러오기 케이스 분류
				switch (firstUserAnswer) {
				// 새로 시작할 경우,
				case 1:
					System.out.println("단어장을 새로 시작 합니다." + "\n기본 값(프로그램의 하위 폴더) : " + mk.getFpath()
							+ "\n단어장이 저장될 위치를 입력해주세요. >>> ");
					String fpath = sc.nextLine(); // 경로 입력 받기

					System.out.println("\n기본 값 : " + mk.getFname() + "\n단어장의 이름을 입력하세요(확장자 제외) >>> ");
					String fname = sc.nextLine(); // 파일 이름 입력 받기

					mk.makeWordNote(fname, fpath); // 단어장 생성 함수

					if (mk.getFile().exists()) // 올바른 경로인지 확인 후 생성
						System.out.println("단어장이 생성 되었습니다." + mk.getFile().getAbsolutePath());

					firstLoop = false; // 모든 과정이 끝나면 루프 탈출
					break;
				// 단어장 불러오기 경우,
				case 2:
					System.out.print("단어장이 저장된 경로를 입력해주세요(파일명 제외).>>> ");
					mk.setFpath(sc.nextLine()); // 경로 입력 받기
					System.out.print("단어장의 이름을 입력해주세요(확장자 제외).>>> ");
					mk.setFname(sc.nextLine()); // 파일명 입력 받기
					mk.setFile(); // 파일 최종 경로 설정
					System.out.println("단어장을 불러옵니다...\n");

					if (!mk.getFile().exists()) { // 파일 경로가 올바르지 않을 때,
						System.out.println("파일이 존재하지 않습니다. 단어장을 새로 만들거나 경로를 확인하세요.");
					} else { // 파일 경로가 올바른 경우 선택된 파일 경로 보여주기
						System.out.println("단어장이 선택되었습니다. : " + mk.getFile().getAbsolutePath());
					}
					firstLoop = false; // 모든 과정이 끝나면 루프 탈출
					break;
				default:
					System.out.println("잘못된 입력 입니다."); // 케이스 이외의 값이 들어올 때,
					break;
				}
				// 예외처리 : 잘못된 입력 값
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 숫자만 입력해주세요." + "\n메뉴 선택창으로 돌아갑니다....\n");
				sc.nextLine(); // nextInt()로 인한 버퍼 속 개행문자 제거
			}
		} // initial while end

		// main 기능 실행
		boolean mainLoop = true; // main loop 탈출 문자
		while (mainLoop) {
			int userAnswer; // 유저의 메뉴 선택 값
			String fname = null, fpath = null; // 유저 입력을 받을 폴더 경로와 파일명 초기화
			try {
				// 메뉴 보여주기
				System.out.println("\n\t\t\t\t<<<<<<< 단어장 메뉴를 선택하세요. >>>>>>>>"
						+ "\n1.새로 만들기 \t2.단어 추가 \t3.단어 찾기 \t4.전체 출력 \t5.단어장 선택 \t6.종료하기");
				userAnswer = sc.nextInt(); // 유저 메뉴 선택 입력 받기
				sc.nextLine(); // 버퍼 속 개행문자 제거

				// 유저 입력 1번
				if (userAnswer == 1) {
					// 현재 폴더 경로 보여주기
					System.out.println("새로운 단어장을 생성 합니다." + "\n현재 경로 : " + mk.getFpath()
							+ "\n파일이 저장될 경로를 입력하세요(파일명 제외). 미 입력시 현재 경로에 저장됩니다.>>> ");
					fpath = sc.nextLine(); // 폴더 경로 입력 받기
					// 현재 파일명 보여주기
					System.out.println(
							"\n현재 파일명 : " + mk.getFname() + "\n파일명을 입력하세요(확장자 제외). 미 입력시 현재 파일명을 덮어씌웁니다. >>> ");
					fname = sc.nextLine(); // 파일명 입력 받기
					// 선택된 파일 경로로 파일 생성
					mk.makeWordNote(fname, fpath);
					if (mk.getFile().exists()) { // 올바른 파일 경로시 출력
						System.out.println("\n👏👏단어장이 생성 되었습니다." + "현재 단어장 : " + mk.getFile().getAbsolutePath());
					} else // 올바르지 않은 파일 경로 시 출력
						System.out.println("올바른 경로가 아닙니다.");

				} else if (userAnswer == 2) {
					if (mk.getFile().exists()) {
						String eng, kor;
						System.out.println("새로운 단어를 추가 합니다.");

						System.out.print("영단어를 추가해주세요. >>> ");
						eng = sc.nextLine();
						mk.setFname(eng);

						System.out.print("뜻을 입력해주세요.>>> ");
						kor = sc.nextLine();
						mk.setFpath(kor);

						mk.addWord(eng, kor); // 단어 추가 실행
						System.out.println("\n👏👏단어가 추가 되었습니다." + "\n추가된 단어 : " + eng + " - " + kor);
					} else {
						System.out.println("선택된 단어장이 없습니다." + "\n단어장을 선택 혹은 생성해 주세요.");
					}
					// 유저 입력 3, 단어 찾기
				} else if (userAnswer == 3) {
					if (mk.getFile().exists()) { // 파일이 존재할 경우
						System.out.print("선택된 단어장 : " + mk.getFile().getAbsolutePath() + "\n찾을 단어를 입력하세요. >>> ");
						String word = sc.nextLine(); // 찾을 단어 입력 받기
						System.out.println(mk.searchWord(word)); // 단어 찾기 실행
						// 파일이 없을 경우,
					} else
						System.out.println("선택된 단어장이 없습니다." + "\n단어장을 선택 혹은 생성해 주세요.");

				} else if (userAnswer == 4) {
					System.out.println("단어장 " + mk.getFile().getAbsolutePath() + "를 출력 합니다.");
					mk.printAllWords();

				} else if (userAnswer == 5) {
					int changeNote;
					System.out.println("단어장을 변경 합니다." + "\n현재 단어장 : " + mk.getFile().getAbsolutePath()
							+ "\n변경하시겠습니까?\t1.예\t2.아니요  >>>");
					changeNote = sc.nextInt();
					sc.nextLine();

					switch (changeNote) {
					case 1: {
						System.out.print("파일 경로를 입력하세요(파일명 제외). 미 입력시 현재 경로를 선택합니다.>>> ");
						fpath = sc.nextLine();
						mk.setFpath(fpath);

						System.out.print("파일명을 입력하세요(화장자 제외). 미 입력시 현재 파일명을 덮어씌웁니다.>>> ");
						fname = sc.nextLine();
						mk.setFname(fname);

						System.out.println("단어장이 선택 되었습니다. : " + mk.getFile().getAbsolutePath());
						break;
					}
					case 2: {
						System.out.println("기존 단어장을 사용합니다.");
						break;
					}
					default:
						System.out.println("잘못된 입력 입니다. 기존 단어장을 사용합니다." + "\n현재 단어장 : " + mk.getFile().getAbsolutePath());
					}

				} else if (userAnswer == 6) {
					System.out.println("종료 합니다.");
					mainLoop = false;
					break;

				} else
					System.out.println("잘못된 입력입니다. 1 ~ 6까지 숫자만 입력하세요.");
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다. 숫자만 입력해주세요." + "\n메뉴 선택창으로 돌아갑니다....");
				sc.nextLine();
			}
		} // main while end
		sc.close();
	} // main end
}
