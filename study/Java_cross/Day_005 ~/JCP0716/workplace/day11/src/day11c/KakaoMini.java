package day11c;

import java.text.DecimalFormat;

public class KakaoMini extends CreditCard {
	// 작성자 : 이우진
	
	// 최대 한도
	public static final int MAX_LIMIT = 100000;
	
	// 기본 생성자
	//public KakaoMini() {}
	
	// 이름을 받는 커스텀 생성자
	public KakaoMini(String owner) {
		super(owner);
	}
	
	// 한도 상승 추상 메소드 정의
	@Override
	public int upLimit(int plus) {
		if (limit + plus <= MAX_LIMIT) {
			limit += plus;
			return plus;
		} else
			return 0;
	}
	// 금액 사용 추상 메소드 정의
	@Override
	public int pay(int money) {
		if (payTotal + money <= limit) {
			payTotal += money;
			return money;
		} else
			return 0;
	}
	
	// 객체 출력 메소드 변경
	@Override
	public String toString() {
		DecimalFormat fm = new DecimalFormat("#,###");
		String payFormat = fm.format(payTotal);
		String limitFormat = fm.format(limit);
		return owner + " 님, 이번 달 결제 예정 금액 " + payFormat + "원 입니다. "
				+ "[이용한도 " + limitFormat + " 원]";
	}
}
