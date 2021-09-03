package jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import util.jdbc.MySQLConnectionUtil;

public class MySQLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = MySQLConnectionUtil.connect();
		System.out.println(conn);
		
//		 encoding이 안 맞을 때, mySQL insert 오류가 날 수 있음 -> table의 인코딩 방식 확인
//		String sql = "INSERT INTO BOOK VALUES ('D1105', 'HTML완성', '자바왕', '코리아아이티', '03/09/21')";
		String sql = "delete from BOOK where bcode = 'D1105'";
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLConnectionUtil.close(conn);
		}
		
		
	}

}
