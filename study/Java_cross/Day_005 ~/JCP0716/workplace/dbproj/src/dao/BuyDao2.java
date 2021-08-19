package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import VO.BuyVo;
import VO.BuyVo2;
import util.jdbc.OracleConnectionUtil;

// singleton pattern
public class BuyDao2 {
	
	private static BuyDao2 dao = new BuyDao2();
	private BuyDao2() {}
	public static BuyDao2 getInstance() {
		return dao;
	}
	
	
	// insert method prototype
	public void insert(BuyVo2 vo2) {
		String sql = "INSERT INTO BUY# (BUY_NO, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY, DEL_DATE) "
						+ "VALUES (buy#_seq.nextval, ?, ?, ?, ?)";
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo2.getCustom_id());
			pstmt.setString(2, vo2.getProduct_code());
			pstmt.setInt(3, vo2.getBuy_quantity());
			pstmt.setDate(4, vo2.getDel_date());
			
			pstmt.execute();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				OracleConnectionUtil.close(conn);
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		}
	}
	
	// idcheck 
	public boolean idCheck(String id) {
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
		} finally { 
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
	
	// getBuyTable
	public BuyVo getBuy(String id) { // custom_id 조회
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM BUY# WHERE CUSTOM_ID = ?";
		BuyVo vo = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new BuyVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5));
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
	
	
	
}
