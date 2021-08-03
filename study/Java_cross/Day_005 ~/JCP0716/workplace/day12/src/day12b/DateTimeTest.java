package day12b;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

// 날짜와 시간형식 클래스
// java.util.Date -> java.util.Calender 
// -> java8부터 java.time.LocalDate, LocalTime, LocalDateTime
public class DateTimeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate currentDate = LocalDate.now();	// 현재 날짜를 가져오는 static메소드
		System.out.println("날짜 확인 : " + currentDate);
		
		LocalTime currentTime = LocalTime.now();
		System.out.println("시간 확인 : " + currentTime);
		
		LocalDateTime current = LocalDateTime.now();
		System.out.println("날짜, 시간 확인 : " + current);
		
		// 특정 날짜와 특정 시간 참조
		LocalDate wdate = LocalDate.of(2021, 1, 12);
		System.out.println("날짜 확인 : " + wdate);
		
		LocalTime wtime = LocalTime.of(23, 11);
		System.out.println("시간 확인 : " + wtime);
		
		// 현재 날짜로부터 40일 후를 계산
		System.out.println("오늘 날짜 + 10일 : " + currentDate.plusDays(10));
		System.out.println("오늘 날짜 - 10일 : " + currentDate.minusDays(10));
	}

}
