package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.jdbc.OracleConnectionUtil;

// sql 쿼리(조회, select)실행 테스트
public class SelectTest2 {

	public static void main(String[] args) {
		// custom# table 모든 데이터 가져오기
		// 1. connection 2. PreparedStatement
		// 3. ResultSet: 조회 결과를 참조할 수 있는 클래스의 메소드 사용

		Connection conn = OracleConnectionUtil.connect();

		String sql = "SELECT * FROM CUSTOM#";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // pstmt 객체로 select 쿼리 실행 -> 조회된 결과를 메모리에 저장 -> rs로 참조
			while (rs.next()) {
					System.out.println("\n" + rs.getRow() + "번 고객 정보");
					System.out.println("현재 row의 custom_id : " + rs.getString("custom_id"));
					System.out.println("현재 row의 custom_name : " + rs.getString("custom_name"));
					System.out.println("현재 row의 custom_age : " + rs.getInt("custom_age"));
					System.out.println("현재 row의 custom_reg_date : " + rs.getDate("custom_reg_date"));
					System.out.println("현재 row의 custom_reg_date : " + rs.getTimestamp("custom_reg_date"));
			}// while end

		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 생겼습니다. : " + e.getMessage());
			// e.printStackTrace();
		}

	} // main end

}
