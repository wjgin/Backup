package jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.CustomVo;
import util.jdbc.OracleConnectionUtil;

// sql 쿼리(조회, select)실행 테스트 -> where 조건 추가 후 조회 결과 VO클래스와 맵핑
public class SelectWhereTest4 {

	public static void main(String[] args) {

		ResultSet rs = null;
		String id = null;
		String name = null;
		String email = null;
		int age;
		Date regdate = null;
		CustomVo vo = null;
		
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM CUSTOM# WHERE CUSTOM_ID = ?"; // 받을 조건을 인자로
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "momo");	 
			rs = pstmt.executeQuery(); 
			
			if (rs.next()) {	// where 검색 컬럼이 PK, unique(조회 결과 1 or 0) -> while x -> if문
					// 테이블 컬럼과 CustomVo 타입 객체와 매핑 -> 자동화 가능
					id = rs.getString("custom_id");
					name =  rs.getString("custom_name");
					email =  rs.getString(3); // 인덱스로 가져올 수 있음 == rs.getString("custom_email");
					age = rs.getInt("custom_age");
					regdate = rs.getDate("custom_reg_date");
					
					vo = new CustomVo(id, name, email, age, regdate);
					
			}// if end
			// rs.next()로 조회된 row와 자바의 클래스를 mapping 시켜야함
			//				ㄴ custom 클래스 생성 -> 테이블의 컬럼과 매핑되는 변수 선언 -> 데이터 저장의 목적 Value Object(VO)
			System.out.println(vo);
			rs.close(); pstmt.close();
			
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 생겼습니다. : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn);
		}
		
		if(vo == null) {
			System.out.println("조회할 사용자 id가 없습니다.");
		} else {
			System.out.println("id = " + id + " 조회 되었습니다.");
		}
	} // main end

}
