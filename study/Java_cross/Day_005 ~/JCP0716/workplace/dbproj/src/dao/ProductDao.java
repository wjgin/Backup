package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.ProductVo;
import util.jdbc.OracleConnectionUtil;

public class ProductDao {

	private static ProductDao dao = new ProductDao();
	
	private ProductDao() {
	}
	
	public static ProductDao getInstance() { 
		return dao;
	}
	
	// 상품 전체 리스트 가져오기
	public List<ProductVo> getList() {
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo vo;
		String sql = "SELECT * FROM PRODUCT#"; 
		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				vo = new ProductVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(vo); // 리스트에 추가
			} // while end

		} catch (SQLException e) {
			System.out.println("SQL문 오류 입니다. : " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("close오류 : " + e.getMessage());
			}
		} // finally end

		return list;
	}
	
	
	// 상품 카테고리 리스트
	public List<ProductVo> getCategoryList(String category) {
		List<ProductVo> list = new ArrayList<ProductVo>(); 
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo vo;
		
		String sql = "SELECT * FROM PRODUCT# WHERE PRODUCT_CATEGORY = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				vo = new ProductVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(vo); // 리스트에 추가
			} // while end

		} catch (SQLException e) {
			System.out.println("SQL문 오류 입니다. : " + e.getMessage());
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				System.out.println("close오류 : " + e.getMessage());
			}
		} // finally end

		return list;
		
		
	}
	
	
	
}
