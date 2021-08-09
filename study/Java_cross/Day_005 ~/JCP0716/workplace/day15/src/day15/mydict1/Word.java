package day15.mydict1;

import java.util.List;

public class Word {
	private String english;
	private List<String> koreans;	// 컬렉션 타입은 인터페이스로 선언
	
	
	public Word(String english) {
		this.english = english;
	}
	
	
	// 커스텀 생성자
	public Word(String english, List<String> koreans) {
		this.english = english;
		this.koreans = koreans;
	}
	
	
	// 파일 저장 형식 예 : 한 줄씩(Word객체 하나씩) println
	@Override
	public String toString() { // 파일 저장 방법 고려해 재정의
		return english + " → " + koreans; // List의 toString() 출력형식(대괄호) ex): [정적인, 실행중 변화가 없는]
	}
	
	
	// getter setter
	public String getEnglish() {
		return english;
	}
	
	public void setEnglish(String english) {
		this.english = english;
	}

	public List<String> getKoreans() {
		return koreans;
	}

	public void setKoreans(List<String> koreans) {
		this.koreans = koreans;
	}
	
	
	
}
