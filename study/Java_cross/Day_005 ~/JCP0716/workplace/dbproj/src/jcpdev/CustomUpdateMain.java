package jcpdev;

import java.util.Scanner;

import VO.CustomVo;
import dao.CustomDao;

/*
:::고객 데이터 관리 :::
고객 정보 수정합니다.
아이디 입력 >>>

새로운 이메일 입력 >>>
수정되었습니다.!!
수정된 내용 보여주기(sql 실행결과)

또는 
고객이 아니시군요 ㅠㅠ
*/

// 고객의 아이디를 입력 받아 입력받은  email 정보를 수정 -> 없는 사용자 아이디의 경우 고객 등록을 물어봄
public class CustomUpdateMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CustomDao dao = CustomDao.getInstance();
		CustomVo vo;
		String userId;
		
		System.out.print(":::고객 데이터 관리 :::\n" + "회원 정보를 수정 합니다.\n" + "아이디 입력 >>> ");
		userId = sc.nextLine();

		while (true) {
			if (!dao.idcheck(userId)) {
				System.out.print("고객이 아닙니다. 다시 입력해주세요. >>> ");
				userId = sc.nextLine();
			} else
				break;
		}

		vo = dao.getCustom(userId);
		System.out.println("\n아이디를 찾았습니다."
				+"\n현재 id : " + vo.getCustom_id() + "\n현재 email : " + vo.getCustom_email()
				+ "\n새로운 이메일 입력 >>> ");
		vo.setCustom_email(sc.nextLine());
		dao.update(vo);
		System.out.println("정보가 수정 되었습니다. \n"
				+"현재 id : " + vo.getCustom_id() + "\n현재 email : " + vo.getCustom_email());
		
		sc.close();

	} // main end

}
