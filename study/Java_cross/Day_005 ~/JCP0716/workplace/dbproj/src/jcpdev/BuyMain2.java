package jcpdev;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import VO.BuyVo;
import dao.BuyDao;

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

public class BuyMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String id = null;
		String pcode = null;
		int quantity = 0;
		BuyVo vo;
		LocalDate date = LocalDate.now();
		LocalDate delDate = date.plusDays(3);
		BuyDao buy = BuyDao.getInstance();
		
		System.out.print(":: 상품 구매 :::\n" + 
				"상품 리스트 입니다.\n" + 
				"(( 상품 리스트 출력))\n" + 
				"구매 고객 아이디 입력 >>> ");
		id = sc.nextLine();
		
		if(buy.idCheck(id)) {
			System.out.print("고객님 환영합니다.~!!\n" + 
					"구매 상품 코드 입력 >>>  ");
			pcode = sc.nextLine();
			System.out.print("구매 수량 입력 >>>  ");
			quantity = sc.nextInt();
			sc.nextLine();
			
			System.out.println("배송날짜 : ");
			//buy.insert(new BuyVo(0, id, pcode, quantity, Date.valueOf(date) ,Date.valueOf(delDate)));
			
			System.out.println("구매가 완료되었습니다. 감사합니다 \n"
					+ "프로그램을 종료 합니다.");
		} else {
			System.out.println("없는 고객 입니다.");
		}
		
		
	}

}
