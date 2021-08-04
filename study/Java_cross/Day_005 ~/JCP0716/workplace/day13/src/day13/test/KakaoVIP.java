package day13.test;

import java.text.DecimalFormat;

public class KakaoVIP extends CreditCard {

	// 최대 증가 한도
	public static final int PLUS_LIMIT = 1000000;

	// 이름을 받는 커스텀 생성자
	public KakaoVIP(String owner) {
		super(owner);
	}

	// 한도 상승 추상 메소드 정의
	@Override
	public int upLimit(int plus) {
		if (plus > PLUS_LIMIT)
			plus = PLUS_LIMIT;
		return limit += plus;
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
		DecimalFormat fm = new DecimalFormat("###,###,###");
		String payFormat = fm.format(payTotal);
		String limitFormat = fm.format(limit);
		return owner + " 님, 이번 달 결제 예정 금액 " + payFormat + "원 입니다. " + "[이용한도 " + limitFormat + " 원]";
	}
}
