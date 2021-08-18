package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import util.jdbc.OracleConnectionUtil;

// 연습 : Scanner로 id, name, email, age 사용자 입력 후 테이블에 insert
public class DBConnectionTest2 {
	public static void main(String[] args) {
		// OracleConnectionUtil 클래스로 DB연결 시도
		
		Connection conn = OracleConnectionUtil.connect();
		System.out.println(conn);	// 출력값이 null이면 db연결이 안된 것
		
		// 무결성 위반시 오류
		String sql = "INSERT INTO CUSTOM#(custom_id, custom_name, custom_email, custom_age)"
				+ " VALUES(?,?,?,?)";
		
		try {
			Scanner sc = new Scanner(System.in);
			String userId;
			String userName;
			String userEmail;
			int userAge;
			PreparedStatement pstmt = conn.prepareStatement(sql); // 실행할  sql 전달 -> Connection 객체 실행
			
			System.out.println("새로운 사용자를 추가 합니다.\n");
			System.out.print("id를 입력해주세요 >>> ");
			userId = sc.nextLine();
			pstmt.setString(1, userId);	// (인덱스, 값) 0 인덱스는 없음
			System.out.print("이름을 입력해주세요 >>> ");
			userName = sc.nextLine();
			pstmt.setString(2, userName);
			System.out.print("이메일을 입력해주세요 >>> ");
			userEmail = sc.nextLine();
			pstmt.setString(3, userEmail);
			System.out.print("나이를 입력해주세요 >>> ");
			userAge = sc.nextInt();
			sc.nextLine();
			pstmt.setInt(4,  userAge);
			
			
			pstmt.execute();	// sql 실행( -> PreparedStatement 객체로 실행
								// execute() 함수는 insert, delete, update에 사용
			pstmt.close();		// pstmt 사용종료
			sc.close();
			
			System.out.println("새로운 사용자를 등록합니다...");
			System.out.println("\n\t\t<<< 환영 합니다. >>>");
			System.out.println("id : " + userId + "\t이름 : " + userName + "\t이메일 : " + userEmail + "\t나이 : " + userAge);
		} catch (SQLException e) {
			System.out.println("SQL 실행 오류 발생 : " + e.getMessage());	// 중복의 경우 PK무결성 오류
			// e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn); // 연결 종료
		}
		
		
	} // main end
}
