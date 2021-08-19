package jcpdev;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import VO.BuyVo2;
import dao.BuyDao2;

/*
:: 상품 구매 :::
상품 리스트 입니다.

(( 상품 리스트 출력))      

구매 고객 아이디 입력 >>> 
고객님 환영합니다.~!!
구매 상품 코드 입력 >>>
구매 수량 입력 >>>
(+) 테이블컬럼(del_date)추가
    (배송날짜=오늘+3일)

((buy테이블에 insert 할 정보 출력))
구매 완료되었습니다.감사합니다.
*/

// BuyVo2 : builder 패턴 추가 사용
public class BuyMain3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = null;
		String pcode = null;
		int quantity = 0;
		BuyVo2 vo2;
		LocalDate buy_date = LocalDate.now();

		BuyDao2 buy = BuyDao2.getInstance();

		System.out.print(":: 상품 구매 :::\n" + "상품 리스트 입니다.\n" + "(( 상품 리스트 출력))\n" + "구매 고객 아이디 입력 >>> ");
		id = sc.nextLine();

		if (buy.idCheck(id)) {
			System.out.print("고객님 환영합니다.~!!\n" + "구매 상품 코드 입력 >>>  ");
			pcode = sc.nextLine();
			System.out.print("구매 수량 입력 >>>  ");
			quantity = Integer.parseInt(sc.nextLine());

			// 배송날짜 : 1) 현재날짜 + 3일	 2) 사용자가 원하는 날짜
			Date del_date = Date.valueOf(buy_date.plusDays(3)); // 1) +3일
			System.out.println("기본 배송 날짜 : " + del_date);
			
			//2)
			System.out.print("배송 날짜를 입력하세요 (yyyy-mm-dd) >>> ");
			// 문자열 yyyy-mm-dd 를 LocalDate 타입으로 변환 --> LocalDate.parse(yyyy-mm-dd)
			Date custom_del_date = Date.valueOf(sc.nextLine());

			if (custom_del_date.after(Date.valueOf(buy_date))) {
				System.out.println("배송날짜 : " + custom_del_date);

				vo2 = BuyVo2.builder().custom_id(id).product_code(pcode).buy_quantity(quantity).del_date(del_date)
						.build();
				buy.insert(vo2);

				System.out.println("\n주문 내역 확인 : " + vo2);
				System.out.println("구매가 완료되었습니다. 감사합니다 \n" + "프로그램을 종료 합니다.");
			} else {
				System.out.println("잘못된 배송 날짜 입니다.");
			}

		} else {
			System.out.println("없는 고객 입니다.");
		}

		sc.close();
	}

}
