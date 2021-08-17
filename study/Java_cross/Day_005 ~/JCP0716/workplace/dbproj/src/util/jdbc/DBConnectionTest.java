package util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest {
	public static void main(String[] args) {
		// OracleConnectionUtil 클래스로 DB연결 시도
		
		Connection conn = OracleConnectionUtil.connect();
		System.out.println(conn);	// 출력값이 null이면 db연결이 안된 것
		
		// 실행할 sql문 : 원초적인 방법 
		String sql = "INSERT INTO CUSTOM#(custom_id, custom_name, custom_email, custom_age)"
			//	+ " VALUES('sana1000', '박사나', 'sana@naver.com', 29)"; // 1) 데이터 직접 작성
				+ "VALUES(?,?,?,?)";	// 2) 변수 처리(문자열, 문자열, 문자열, 정수) 준비
		
		// sql 실행 => PrepareStatement 메서드 실행
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql); // 실행할  sql 전달 -> Connection 객체 실행
			
			// 2) 방법은 sql 전달 후 설정 -> pstmt 객체 메소드
			pstmt.setString(1, "nana");	// (인덱스, 값) 0 인덱스는 없음
			pstmt.setString(2, "이나나");
			pstmt.setString(3, "lee@naver.com");
			pstmt.setInt(4,  28);
			
			pstmt.execute();	// sql 실행 -> PreparedStatement 객체로 실행
			pstmt.close();		// pstmt 사용종료
			System.out.println("Insert 완료.");
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 발생 : " + e.getMessage());	// 중복의 경우 PK무결성 오류
			// e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn); // 연결 종료
		}
		
		
	} // main end
}
