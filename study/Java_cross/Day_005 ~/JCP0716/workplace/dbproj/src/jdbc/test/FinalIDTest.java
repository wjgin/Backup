package jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import VO.CustomVo;
import util.jdbc.OracleConnectionUtil;

public class FinalIDTest {

	private static Connection conn = OracleConnectionUtil.connect();

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);

		String id = null;
		String name = null;
		String email = null;
		int age;
		Date regdate = null;
		CustomVo vo = null;

		try {
			System.out.println("새로운 사용자를 등록 합니다.");

			while (true) {
				System.out.print("id 입력 >>> ");
				id = sc.nextLine();

				System.out.print("id 확인 중 입니다.... ");

				if (idCheck(id)) {
					System.out.println("사용중인 id 입니다. \nid를 다시 입력해 주세요");
				} else {
					System.out.println("사용 가능 합니다.");
					break;
				}
			} // while end

			System.out.print("이름 입력 >>> ");
			name = sc.nextLine();
			System.out.print("이메일 입력 >>> ");
			email = sc.nextLine();
			System.out.print("나이 입력 >>> ");
			age = sc.nextInt();
			sc.nextLine();

			vo = new CustomVo(id, name, email, age, regdate);

		} finally {
			sc.close();
			OracleConnectionUtil.close(conn);
		}

		System.out.println("환영 합니다.!!" + "\n<<고객 정보 출력>>\n" + vo);

		// 아래 insert문 새로 추가
		
		
	} // main end

	// ID중복 체크 메소드 -> return 존재하면 true / 아니면 false
	private static boolean idCheck(String id) {
		String sql = "SELECT * FROM CUSTOM# WHERE CUSTOM_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		;
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
