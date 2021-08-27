package dao.seungJoon.teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.jdbc.OracleConnectionUtil;
import vo.seungJoon.teamProject.InexVo;



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
	
	//2-1.로그인(id와 pw입력) 해서 들어와서 자신의 가계부 전체조회
	public List<String[]> getId_list(String userinfo_id) { 
		Connection conn = OracleConnectionUtil.connect();
		List<String[]> list = new ArrayList<String[]>();
		String sql = "SELECT decode(ie_division,'E','지출','I','수입'), ie_time, ie_price, ie_category, ie_memo, account_num"
				+ "  FROM INCOMEEXPENSE WHERE userinfo_id=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,userinfo_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String[] temp = {rs.getString(1), rs.getTimestamp(2).toString(), String.valueOf(rs.getInt(3)), rs.getString(4), rs.getString(5), rs.getString(6)};
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
	
	
	//2-2  E/I를 입력받아서 select
		public void getId_IE(String userinfo_id, String ie) { 
			Connection conn = OracleConnectionUtil.connect();
			String sql = "SELECT ie_category,ie_price, ie_memo,ie_time "
					+ "FROM INCOMEEXPENSE WHERE userinfo_id=? and ie_division = ?";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			if(ie.contains("E")) {System.out.println(":::지출:::");}
			else if(ie.contains("I")) {System.out.println(":::수입:::");}
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1,userinfo_id);
				pstmt.setNString(2, ie);
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

		//2-3 category 로  조회 (유형별 조회) --인자가 3개 id,첫번째 카테고리, 추가된 카테고리 sql 예) addSql = " or ie_category='식대'"
				public void getId_selcetCate1(String userinfo_id,String category,String addSql) { 
					Connection conn = OracleConnectionUtil.connect();
					String sql = "SELECT ie_category,ie_price,decode(ie_division,'E','지출','I','수입'),"
							+ " ie_memo,ie_time FROM INCOMEEXPENSE "
							+ "WHERE USERINFO_ID = ? AND ie_category = ?";
					sql += addSql;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
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
// =======================================================================================
	
	// 일자별 조회
    public List<String[]> getId_selcetDate(String userinfo_id,String date1,String date2) { 
       Connection conn = OracleConnectionUtil.connect();
       List<String[]> list = new ArrayList<String[]>();
       String sql = " SELECT decode(ie_division,'E','지출','I','수입'), TO_CHAR(ie_time,'mm/dd'), ie_price, ie_category, ie_memo, account_num"
       		+ "FROM INCOMEEXPENSE "
             + "WHERE USERINFO_ID = ? "
             + "AND TO_NUMBER(TO_CHAR(ie_time,'mmdd')) BETWEEN TO_NUMBER(?) AND TO_NUMBER(?)"
             + " order by TO_CHAR(ie_time,'mm/dd')";
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       int income=0, expense=0;
      
       try {
          pstmt = conn.prepareStatement(sql);
          pstmt.setNString(1,userinfo_id);
          pstmt.setNString(2,date1);
          pstmt.setNString(3,date2);
          rs = pstmt.executeQuery();
          while(rs.next()) { 
             String[] temp = {rs.getString(1)};
             list.add(temp);
          }
          System.out.println("[수입] : "+income + "원  ,[지출] : "+ expense+"원");
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

	