package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.CustomVo;
import util.jdbc.OracleConnectionUtil;

public class CustomDao { // singleton 패턴 적용
	private static CustomDao dao = new CustomDao();

	private CustomDao() {
	}

	public static CustomDao getInstance() {
		return dao;
	}

	// CUSTOM# table 대상으로 sql 실행할 메소드 정의

	public List<CustomVo> getList() { // 전체 조회
		List<CustomVo> list = new ArrayList<CustomVo>();
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOM#";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new CustomVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5)));
			} // while end

		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
				OracleConnectionUtil.close(conn);
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		} // finally end

		return list;
	}

	public CustomVo getCustom(String id) { // custom_id 조회
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOM# WHERE CUSTOM_ID = ?";
		CustomVo vo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new CustomVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
			} // while end
			
		} catch (SQLException e) {
			System.out.println("SQL문 오류 : " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		} // finally end
		
		return vo;
	}

	public void isnert(CustomVo vo) {
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt  = null;
		String sql = "INSERT INTO CUSTOM# (CUSTOM_ID, NAME, EMAIL, AGE) VALUES(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getCustom_id());
			pstmt.setString(2, vo.getCustom_name());
			pstmt.setString(3, vo.getCustom_email());
			pstmt.setInt(4, vo.getCustom_age()); // sql 을 먼저 전달 -> 필요한 데이터는 그 후에 설정이됩니다.

			pstmt.execute();   //insert,update,delete SQL 문 실행할때는 execute() 메소드입니다.
			pstmt.close(); // pstmt 사용 종료
			System.out.println("insert 정상완료");
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류 : " + e.getMessage());
			// e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				OracleConnectionUtil.close(conn); // 연결 종료
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		} // close finally end
	}

	public void update(CustomVo vo) {
		Connection conn = OracleConnectionUtil.connect();
		String sql = "UPDATE CUSTOM# SET CUSTOM_EMAIL = ? WHERE CUSTOM_ID = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCustom_email());
			pstmt.setString(2, vo.getCustom_id());
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("update SQL 오류 : " + e.getMessage());
		} 
	}

	public boolean idcheck(String id) {
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM CUSTOM# WHERE CUSTOM_ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next())
				return true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // finally를 쓰는 이유... return이 있어도 그 전에 먼저 실행함... rs와 pstmt를 닫기 위해서
			try {
				rs.close();
				pstmt.close();
				OracleConnectionUtil.close(conn);
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		}
		return false;
	}

}
