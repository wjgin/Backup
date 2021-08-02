package day11b;

public class SmartTV implements RemoteControl, WebSearch {

	private int volume;

	@Override
	public void search(String url) {
		System.out.println("브로드밴드 서비스로 인터넷에 연결 합니다.");
		System.out.println(url + " 에 접속 합니다.");
	}
	
	@Override
	public void turnOn() {
		System.out.println("스마트 티비를 켭니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("스마트 티비를 끕니다.");
	}

	@Override
	public void setVolume(int volume) {
		// 볼륨의 범위를 지정
		if (volume > RemoteControl.MAX_VOLUME)		// 최댓값을 넘어가면 최댓값으로
			this.volume = RemoteControl.MAX_VOLUME;
		else if (volume < RemoteControl.MIN_VOLUME)	// 최솟 값 이하가 되면 최솟 값으로
			this.volume = RemoteControl.MIN_VOLUME;
		else
			this.volume = volume;					// 0~20 사이 값이면 인자 값으로
		
		System.out.println("현재 볼륨 : " + this.volume);
	}

	
	
}
