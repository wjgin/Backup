package util.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
	//  오라클을 연결하는 메소드 작성. 리턴 타입 Connection
	public static Connection connect() {
		Connection conn = null;

		String url = "jdbc:mysql://localhost:3306/jcpdev?useSSL= false";	// 데이터베이스 URL - 디비버에서 확인
		String driver="com.mysql.cj.jdbc.Driver";  	// mysql 드라이버 클래스(패키지명.클래스)
		String user ="jcpdev";
		String password="1234";    
		
		try {
			// 메모리에 드라이버를 로드함
			Class.forName(driver);
// DriverManager 클래스의 메소드 getConnection으로 데이터베이스 드라이버에 대한 Connection 구현 객체 생성
//												ㄴ 인터페이스 Connection 타입으로 참조
			conn = DriverManager.getConnection(url,user,password);	// db 연결에 필요한 정보 인자 전달
			
		} catch (ClassNotFoundException e) {
			System.out.println("데이터베이스 드라이버 로드에 문제가 생겼습니다. : " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 및 사용에 문제가 생겼습니다. : " + e.getMessage());
		} 
		
		return conn;	// 생성된 Connection 객체 리턴
	}
	
	// 오라클 연결 Connection 객체 close 메소드 - 인자 타입 Connection
	public static void close(Connection conn) {
		if(conn != null)	// conn이 null일 때, close가 실행되면 오류
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("데이터베이스 연결 종료에 문제가 생겼습니다. : " + e.getMessage());
			}
	}

}