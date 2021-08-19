package jcpdev;

import VO.BuyVo;
import dao.BuyDao;

public class BuyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BuyVo vo = new BuyVo(0, "momo", "ㅁㅁ", 1, null); // 상품코드 FK 위반, 날짜 defaults는 현재 sysdate 
		
		// 2) BuyDao의 insert를 객체로 실행
		BuyDao buy = BuyDao.getInstance();
		buy.insert(vo);
		System.out.println("추가 완료");
		
	}

}
