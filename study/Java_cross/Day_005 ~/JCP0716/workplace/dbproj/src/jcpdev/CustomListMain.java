package jcpdev;

import VO.CustomVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;

// 고객 리스트를 db에서 가져오기
public class CustomListMain {

	public static void main(String[] args) {
		List<CustomVo> list = custom_list();

		for (CustomVo CV : list) {
			System.out.println(CV);
		}

	} // main end
	

	public static List<CustomVo> custom_list() {
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
				conn.close();
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
		} // finally end

		return list;
	} // comstom_list end

}
