package day11b;

public interface RemoteControl {
	int MAX_VOLUME =20; //(public static final) int MAX_VOLUME=10;
	int MIN_VOLUME =0;

	void turnOn(); // (public abstract) void turnOn();

	void turnOff();

	void setVolume(int volume);

	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음처리 합니다..");
		}else {
			System.out.println("무음해제 합니다.");
		}
	}

	static void changeBattery() {
		System.out.println("건전지를 교체 합니다.");
	}

}
