package day11c;

public abstract class CreditCard {
	protected String owner;
	protected int limit;
	protected int payTotal;
	
	// 기본 생성자
	// public CreditCard() {}
	
	// 이름을 받는 커스텀 생성자
	public CreditCard(String owner) {
		this.owner = owner;
	}
	
	// 추상 메소드 선언
	public abstract int upLimit(int plus);
	public abstract int pay(int money);
	
	
	// getter / setter
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getPayTotal() {
		return payTotal;
	}
	public void setPayTotal(int payTotal) {
		this.payTotal = payTotal;
	}
	
	
}
