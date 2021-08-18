package jcpdev;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VO.ProductVo;
import util.jdbc.OracleConnectionUtil;

//product# 테이블에 있는 상품목록을 사용자에게 보여줌
public class ProductListMain {

	public static void main(String[] args) {

		List<ProductVo> list = product_list();
		
		// 상품 목록 한 줄씩 출력 
		for(ProductVo vo : list) {
			
			System.out.println(vo);
		}
		
	} // main end

	private static List<ProductVo> product_list() {
		// 상품목록 리스트 db에서 가져와 리턴
		// ㄴ 테이블의 컬럼값을 vo클래스와 맵핑
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVo vo;
		String sql = "SELECT * FROM PRODUCT#"; // 실행결과 예측 : 최대 row
		List<ProductVo> list = new ArrayList<ProductVo>();

		try {
			pstmt = conn.prepareStatement(sql);

			// 쿼리결과 rs 참조(일종의 pointer)
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// Vo클래스와 조회 결과 매핑
				vo = new ProductVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(vo); // 리스트에 추가
				// System.out.println(vo); // 테스트용
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
	} // product_list end

}
