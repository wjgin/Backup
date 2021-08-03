package day12c;

import java.util.InputMismatchException;
import java.util.Scanner;


public class TryCatchTest4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] menu = { "삼겹살", "곱창전골", "스파게티", "불고기", "탕수육" };
		int sel;
		try {
		System.out.println("메뉴를 선택하세요.");
		for (int i = 0; i < menu.length; i++) {
			System.out.println("[" + (i + 1) + "]" + menu[i]);
		}
		
		sel = sc.nextInt();
		System.out.println("당신 선택한 메뉴는 " + menu[sel - 1] + " 입니다.");
		}
		// 예외 처리
		catch(IndexOutOfBoundsException e) { // 범위를 벗어난 값을 입력 시
			System.out.println("잘못된 번호 입니다.[1 ~ 5]");
		} catch(InputMismatchException e) {	// 정수가 아닌 값 입력 시
			System.out.println("번호를 입력해 주세요.");
		} finally {		
			sc.close();	// 사용 자원 해제
			System.out.println("🙏🙏🙏");
		}
		
		
	} // main end

}
