package day11b;

public class Audio implements RemoteControl {
	private int volume;
	
	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControl.MAX_VOLUME + 10)		// 최댓값을 넘어가면 최댓값으로
			this.volume = RemoteControl.MAX_VOLUME + 10;
		else if (volume < RemoteControl.MIN_VOLUME + 5)	// 최솟 값 이하가 되면 최솟 값으로
			this.volume = RemoteControl.MIN_VOLUME + 5;
		else
			this.volume = volume;					// 0~20 사이 값이면 인자 값으로
		
		System.out.println("현재 볼륨 : " + this.volume);
	}

	@Override
	public void turnOff() {
		System.out.println("Audio off");
	}

	@Override
	public void turnOn() {
		System.out.println("Audio on");
	}
}
