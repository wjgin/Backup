package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.jdbc.OracleConnectionUtil;
import vo.InexVo;
import vo.UserinfoVo;

public class InexDao {
	private static InexDao dao = new InexDao();
	public InexDao(){}
	public static InexDao getInstance() {
		return dao;
		}
	
	//1.전체 조회
	public void getList() { 
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM INCOMEEXPENSE"; 
		InexVo vo;
		List<InexVo> list = new ArrayList<InexVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new InexVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4),
						rs.getInt(5),rs.getString(6),rs.getNString(7),rs.getNString(8));
				list.add(vo); 
			}
			for (InexVo bv : list) 
				System.out.println(bv);		
		} catch (SQLException e) {
			System.out.println("오류 : " + e.getMessage());
		} finally {
			try { rs.close();pstmt.close();
			} catch (SQLException e) {System.out.println("close 오류 : " + e.getMessage());}
			OracleConnectionUtil.close(conn);
		}
	}
//=========================================================================================
	//기존적으로 로그인해서 조회하는것이기 때문에 회원별(ID) 조회는 항상 포함됨
	//수입별,지출별 ,유형별조회  ---> 이건 ok
	//기간별(월별,주간별,일별)조회 --->???
	
	//2.로그인(id와 pw입력) 해서 들어와서 자신의 가계부 전체조회
	public void getId_list(String userinfo_id) { 
		Connection conn = OracleConnectionUtil.connect();
		String sql = "SELECT ie_category,ie_price,decode(ie_division,'E','지출','I','수입'),"
				+ " ie_memo,ie_time FROM INCOMEEXPENSE WHERE userinfo_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InexVo vo = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,userinfo_id);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				System.out.println("[카테고리]:"+rs.getString(1)+" [금액]:"+rs.getInt(2)
				+" [수입/지출]:"+rs.getString(3)+" [메모]:"+rs.getString(4)+
				" [시간]:"+rs.getDate(5));
			}
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
		} finally {
			try {rs.close(); pstmt.close();
			} catch (SQLException e) {e.getMessage();}
			OracleConnectionUtil.close(conn);
		}
	}
	
	//2-1 income(I)이 포함된 select
	public void getId_income(String userinfo_id) { 
		Connection conn = OracleConnectionUtil.connect();
		String sql = "SELECT ie_category,ie_price,ie_memo,ie_time "
				+ "FROM INCOMEEXPENSE WHERE userinfo_id=? and ie_division ='I'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		InexVo vo = null; 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,userinfo_id);
			rs = pstmt.executeQuery();
			while(rs.next()) { 
				System.out.println("[카테고리]:"+rs.getString(1)+" [금액]:"+rs.getInt(2)
				+" [메모]:"+rs.getString(3)+ " [시간]:"+rs.getDate(4));
			}
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
		} finally {
			try {rs.close(); pstmt.close();
			} catch (SQLException e) {e.getMessage();}
			OracleConnectionUtil.close(conn);
		}
	}
	
	//2-2 expense(E)이 포함된 select
		public void getId_expense(String userinfo_id) { 
			Connection conn = OracleConnectionUtil.connect();
			String sql = "SELECT ie_category,ie_price, ie_memo,ie_time "
					+ "FROM INCOMEEXPENSE WHERE userinfo_id=? and ie_division ='E'";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			InexVo vo = null; 
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1,userinfo_id);
				rs = pstmt.executeQuery();
				while(rs.next()) { 
					System.out.println("[카테고리]:"+rs.getString(1)+" [금액]:"+rs.getInt(2)
					+" [메모]:"+rs.getString(3)+" [시간]:"+rs.getDate(4));
				}
			} catch (SQLException e) {
				System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
			} finally {
				try {rs.close(); pstmt.close();
				} catch (SQLException e) {e.getMessage();}
				OracleConnectionUtil.close(conn);
			}
		}
	//2-3 category 로  조회 (유형별 조회)
		public void getId_selcetCate(String userinfo_id,String category) { 
			Connection conn = OracleConnectionUtil.connect();
			String sql = "SELECT ie_category,ie_price,decode(ie_division,'E','지출','I','수입'),"
					+ " ie_memo,ie_time FROM INCOMEEXPENSE "
					+ "WHERE USERINFO_ID = ? AND ie_category = ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			InexVo vo = null; 
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1,userinfo_id);
				pstmt.setNString(2,category);
				rs = pstmt.executeQuery();
				while(rs.next()) { 
					System.out.println("[카테고리]:"+rs.getString(1)+" [금액]:"+rs.getInt(2)
					+" [수입/지출]:"+rs.getString(3)+" [메모]:"+rs.getString(4)+
					" [시간]:"+rs.getDate(5));
				}
			} catch (SQLException e) {
				System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
			} finally {
				try {rs.close(); pstmt.close();
				} catch (SQLException e) {e.getMessage();}
				OracleConnectionUtil.close(conn);
			}
		}
		
	//기간별(월별,주간별,일별)조회 --->???
	//2-4 기간별 조회	
		public void getId_selcetDate(String userinfo_id,String date1,String date2) { 
			Connection conn = OracleConnectionUtil.connect();
			String sql = "SELECT ie_category,ie_price,decode(ie_division,'E','지출','I','수입'),"
					+ " ie_memo,ie_time FROM INCOMEEXPENSE "
					+ "WHERE USERINFO_ID = ? AND IE_TIME BETWEEN ? AND ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			InexVo vo = null; 
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1,userinfo_id);
				pstmt.setNString(2,date1);
				pstmt.setNString(3,date2);
				rs = pstmt.executeQuery();
				while(rs.next()) { 
					System.out.println("[카테고리]:"+rs.getString(1)+" [금액]:"+rs.getInt(2)
					+" [수입/지출]:"+rs.getString(3)+" [메모]:"+rs.getString(4)+
					" [시간]:"+rs.getDate(5));
				}
			} catch (SQLException e) {
				System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
			} finally {
				try {rs.close(); pstmt.close();
				} catch (SQLException e) {e.getMessage();}
				OracleConnectionUtil.close(conn);
			}
		}
//==========================================================================================
	//3.insert
	public void insert(InexVo vo) {
		Connection conn = OracleConnectionUtil.connect();
		String sql = "INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,"
				+ "ie_price,userInfo_id,account_num,ie_memo) VALUES(ie_seq.nextval,?,?,?,?,?,?)";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getIe_division());
			pstmt.setString(2, vo.getIe_category());
			pstmt.setInt(3, vo.getIe_price()); 
			pstmt.setString(4, vo.getUserinfo_id()); 
			pstmt.setString(5, vo.getAccount_num()); 
			pstmt.setString(6, vo.getIe_memo()); 

			pstmt.execute();   
			pstmt.close(); 
			System.out.println("등록 완료!");
		} catch (SQLException e) {
			 e.printStackTrace();
		} finally {
			OracleConnectionUtil.close(conn); 
		}
	}

//	
//	//2.로그인(id와 pw입력) 해서 들어와서 자신의 가계부 전체조회
//	public void getId_list1(String userinfo_id) { 
//		Connection conn = OracleConnectionUtil.connect();
//		String sql = "SELECT * FROM INCOMEEXPENSE WHERE userinfo_id= ?";
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		InexVo vo = null; 
//		ArrayList<InexVo> list = new ArrayList<InexVo>();
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setNString(1,userinfo_id);
//			rs = pstmt.executeQuery();
//			while(rs.next()) { 
//				vo = new InexVo(rs.getInt(1),rs.getString(2),rs.getString(3),
//						rs.getDate(4),rs.getInt(5),rs.getString(6),rs.getNString(7),rs.getNString(8));
//				list.add(vo);
//				
//			}
//		} catch (SQLException e) {
//			System.out.println("SQL 실행에 오류발생 : " + e.getMessage());
//		} finally {
//			try {rs.close(); pstmt.close();
//			} catch (SQLException e) {e.getMessage();}
//			OracleConnectionUtil.close(conn);
//		}
//		for (InexVo iv : list) {
//			System.out.println(iv);			
//		}
//	}
		
	}

	