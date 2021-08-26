package dao.seungJoon.teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.jdbc.OracleConnectionUtil;
import vo.seungJoon.teamProject.UserinfoVo;


public class UserinfoDao {
	private static UserinfoDao bd = new UserinfoDao();
	private UserinfoDao() { }
	public static UserinfoDao getInstance() {
		return bd;
	}
	
	//1.insert 
	public void insert(UserinfoVo vo) { 
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "insert into userinfo(userinfo_id,userinfo_password,userinfo_phone,userinfo_name) "
				+ "values (?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, vo.getId());
			pstmt.setNString(2, vo.getPassword());
			pstmt.setNString(3, vo.getPhone());
			pstmt.setNString(4, vo.getName());
			pstmt.execute();
			System.out.println("등록 완료");
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
	}// insert end
	
	//2.userinfo 테이블 전체조회
	public void getList(){
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "select * from userinfo";
		ResultSet rs = null;
		UserinfoVo vo;
		ArrayList<UserinfoVo> list = new ArrayList<UserinfoVo>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new UserinfoVo(rs.getNString(1),rs.getNString(2),rs.getNString(3), rs.getString(4));
				list.add(vo);
			}
			for (UserinfoVo bv : list) {
				System.out.println(bv);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			OracleConnectionUtil.close(conn);
		}	
	}//전체조회 end
	
	//3.id와 비번으로 정보 조회
	public void getId(String id,String pw){
		Connection conn = OracleConnectionUtil.connect();
		PreparedStatement pstmt = null;
		String sql = "select * from userinfo where userinfo_id = ? and"
				+ " userinfo_password = ?";
		ResultSet rs = null;
		UserinfoVo vo;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, id);
			pstmt.setNString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new UserinfoVo(rs.getNString(1),rs.getNString(2),rs.getNString(3),rs.getString(4));
				System.out.println(vo);
			}else {
				System.out.println("아이디와 비밀번호가 일치하지 않습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			OracleConnectionUtil.close(conn);
		}	
	}//id 조회 end
	
	//4.id와 비번일치 검사
		public boolean checkIdPw(String id,String pw){ //일치하면 true
			Connection conn = OracleConnectionUtil.connect();
			PreparedStatement pstmt = null;
			String sql = "select * from userinfo where userinfo_id = ? and"
					+ " userinfo_password = ?";
			ResultSet rs = null;
			UserinfoVo vo;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1, id);
				pstmt.setNString(2, pw);
				rs = pstmt.executeQuery();
				if(rs.next())
					return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pstmt.close(); conn.close();
				} catch (SQLException e) {
					System.out.println("close 오류 : " + e.getMessage());
				}
				OracleConnectionUtil.close(conn);
			}
			return false;	
		}//id pw 검사 end
	
	//5.id중복 체크
	public boolean idcheck(String id) { //중복값이면 false 리턴
		Connection conn = OracleConnectionUtil.connect();
		String sql ="SELECT * FROM userinfo WHERE userinfo_id =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);   //sql 쿼리 전달
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();   
			if(rs.next()) {   //id는 중복id -> 사용할수 없다.
				return true;    //중복값이면 false 리턴
			} 
			
		} catch (SQLException e) {
			System.out.println("SQL 실행에 오류가 발생했습니다. : " + e.getMessage());
		} finally {       
			try {
				rs.close(); 
				pstmt.close();   
			} catch (SQLException e) {
				System.out.println("close 오류 : " + e.getMessage());
			}
			OracleConnectionUtil.close(conn);
		}	
		return false;
	}
	
	//6.id로  조회해서 회원탈퇴(삭제)
	public void delete(UserinfoVo vo) {
		Connection conn = OracleConnectionUtil.connect();
		String sql = "DELETE FROM USERINFO WHERE USERINFO_ID =? AND USERINFO_PASSWORD = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1,  vo.getId());
			pstmt.setNString(2, vo.getPassword());
			pstmt.execute();
			
			System.out.println("계정(ID)을 삭제했습니다.");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
