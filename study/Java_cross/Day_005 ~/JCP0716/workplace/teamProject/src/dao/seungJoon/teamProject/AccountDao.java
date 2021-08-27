package dao.seungJoon.teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;
import vo.seungJoon.teamProject.AccountVo;

public class AccountDao {
	private static AccountDao md = new AccountDao();
	public AccountDao() {	}
	public static AccountDao getInstance() {
		return md;
	}
	
	//1.insert 계좌 등록
	public void insert(AccountVo vo) { 
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "insert into account(account_num,account_bank,account_owner,userinfo_id) "
				+ "values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, vo.getAccNum());
			pstmt.setNString(2, vo.getBank());
			pstmt.setNString(3, vo.getOwner());
			pstmt.setNString(4, vo.getId());
			pstmt.execute();
			System.out.println("등록 완료");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			OracleConnectionUtil.close(conn);
		}	
	}
	
	//2.id로 account_num 리턴하기 -->가계부등록할때 쓰임 (따로 계좌번호 입력안하기 위함)
	public String accoutNum(String id) {
		Connection conn = OracleConnectionUtil.connect();
		String sql = "SELECT * FROM ACCOUNT WHERE USERINFO_ID = ?";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		AccountVo vo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new AccountVo(rs.getNString(1), rs.getNString(2), rs.getNString(3),rs.getNString(4));
			}
			return vo.getAccNum();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			OracleConnectionUtil.close(conn);
		}
		return null;
	}
	
	//3.id로  조회해서 계좌 수정
	public void update(AccountVo vo){
		Connection conn = OracleConnectionUtil.connect();
		String sql = "UPDATE account SET ACCOUNT_NUM = ?, ACCOUNT_BANK = ?,"
				+ "ACCOUNT_OWNER = ? WHERE USERINFO_ID =?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, vo.getAccNum());
			pstmt.setNString(2, vo.getBank());
			pstmt.setNString(3, vo.getOwner());
			pstmt.setNString(4,  vo.getId());
			pstmt.execute();
			
			System.out.println("수정을 완료했습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			OracleConnectionUtil.close(conn);
		}
	}
			
	//4. 계좌 정보 가져오기
	public List<String[]> getList(String id) {
		Connection conn = OracleConnectionUtil.connect();
		List<String[]> list = new ArrayList<String[]>();
		String sql = "SELECT ACCOUNT_BANK, ACCOUNT_NUM, ACCOUNT_OWNER"
				+ "  FROM ACCOUNT WHERE userinfo_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] temp = {rs.getString(1), rs.getString(2), rs.getString(3)};
				list.add(temp);
			}
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
		} finally {
			try {rs.close(); pstmt.close();
			} catch (SQLException e) {e.getMessage();}
			OracleConnectionUtil.close(conn);
		}
		return list;
	}

	

}
