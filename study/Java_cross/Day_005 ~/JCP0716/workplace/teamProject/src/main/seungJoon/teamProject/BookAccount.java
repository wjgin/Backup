package main.seungJoon.teamProject;

import java.util.Scanner;

import dao.seungJoon.teamProject.AccountDao;
import dao.seungJoon.teamProject.InexDao;
import dao.seungJoon.teamProject.UserinfoDao;
import vo.seungJoon.teamProject.AccountVo;
import vo.seungJoon.teamProject.InexVo;
import vo.seungJoon.teamProject.UserinfoVo;


public class BookAccount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		UserinfoVo uv = new UserinfoVo();
		UserinfoDao ud = UserinfoDao.getInstance();
		String id,name,phone,password; //Userinfo 회원가입을 하기 위한
		
		AccountVo av = new AccountVo();
		AccountDao ad = new AccountDao().getInstance();
		String bank,owner,accNum; //acount 등록,수정,삭제를 위한 

		InexVo iv = new InexVo();
		InexDao dao =new InexDao().getInstance();
		String categoryList = "※카테고리 : [자기계발] [생활비] [식대] [교육] "
				+ "[문화] [미용] [교통] [쇼핑] [월급] [부수입]";
		
		int choice = 0; //스위치문이나 번호선택할때 사용하려고
		//회원가입  -UserinfoDao를 이용
		System.out.println("-------------------------");
		System.out.println("1.회원 가입	  2.로그인     3.나가기   ");
		System.out.println("-------------------------");
		System.out.print("입력 ▶ ");
		choice = Integer.parseInt(sc.nextLine()); //nextInt()로 입력받으면 enter(공백)가 남으니까
		
		switch (choice) { //switch[1]
		case 1:		//[1]-1.회원가입
			while(true) {
				System.out.println("\n환영합니다. 회원가입 입니다.");
				System.out.print("id를 입력하세요 >>> ");
				id = sc.nextLine();
				if(ud.idcheck(id)) { //id중복이 아니면 즉, 사용할 수 있다면 ture		
					System.out.print("name를 입력하세요 >>> ");
					name = sc.nextLine();
					System.out.print("password를 입력하세요(8자리 이하) >>> ");
					password = sc.nextLine();
					System.out.print("전화번호를 입력하세요 >>> ");
					phone = sc.nextLine();
					
					uv.setId(id);
					uv.setName(name);
					uv.setPassword(password);
					uv.setPhone(phone);
					
					ud.insert(uv); // insert 회원가입	
					break;
				}else {
					System.out.println("이미 있는 아이디입니다.");
				}
			}//while end
			//===========================================
			//계좌등록- AccountDao를 이용한다.
			System.out.println("[계좌등록]");
			System.out.print(id+"회원님 은행명을 입력하세요 >>> ");
			bank = sc.nextLine();
			System.out.print("계좌번호를 입력하세요 >>> ");
			accNum = sc.nextLine();
			System.out.print("계좌의 오너를 입력하세요 >>>");
			owner = sc.nextLine();
			
			av.setAccNum(accNum);
			av.setBank(bank);
			av.setOwner(owner);
			av.setId(id);
			ad.insert(av);
			break;
		case 2 : //[1]-2. 로그인
			while(true) { //로그인할때 ID,PW 이 일치하는검사 
				System.out.print("ID : ");
				id = sc.nextLine();
				System.out.print("PW : ");
				password = sc.nextLine();
				if(ud.checkIdPw(id, password)) { //id와 pw가 일치하면 true
					break;
				}else {	System.out.println("아이디와 비밀번호가 일치하지 않습니다."
						+ "\n다시 입력해주세요.");}
			}//while end
			while(choice!=5) { //choice가 5일떄 while문 탈출
				System.out.println("------------------------------------------------");
				System.out.println("1.가계부등록  2.계좌 수정   3.가계부계정(ID)삭제  4.조회  5.나가기   ");
				System.out.println("------------------------------------------------");
				System.out.print("입력 ▶ ");
				choice = Integer.parseInt(sc.nextLine());
				
				switch (choice) {// switch[2]
				case 1: //[2]-1.가계부 등록 (로그인한 ID로)
					System.out.print("수입(I)인지 지출(E)인지 입력하세요 >>> ");
					iv.setIe_division(sc.nextLine());
					System.out.println(categoryList); //카테고리 목록
					System.out.print("카테고리 입력하세요 >>> ");
					iv.setIe_category(sc.nextLine());
					System.out.print("금액을 입력하세요 >>> ");
					iv.setIe_price(Integer.parseInt(sc.nextLine()));
					System.out.println("메모를 입력하세요(30자 이하) : ");
					iv.setIe_memo(sc.nextLine());
					iv.setUserinfo_id(id);
					iv.setAccount_num(ad.accoutNum(id)); //accountDao에서 인자 id로 accNum을 리턴받아서 inexVo에 저장 
					
					dao.insert(iv);
					break;
				case 2://[2]-2. 계좌 수정(은행명,계좌번호,계좌 오너 변경)
					//===================================================
					//계좌 수정(update) - AccountDao를 이용한다.
					System.out.println("[계좌수정]");
					System.out.print(id+"회원님 은행명을 입력하세요 >>> ");
					bank = sc.nextLine();
					System.out.print("계좌번호를 입력하세요 >>> ");
					accNum = sc.nextLine();
					System.out.print("계좌의 오너를 입력하세요 >>>");
					owner = sc.nextLine();
					
					av.setAccNum(accNum);
					av.setBank(bank);
					av.setOwner(owner);
					av.setId(id);
					ad.update(av);		
					break;
				case 3://[2]-3. 로그인한 ID 계정 삭제(3개 테이블에서 전부 삭제된다)
					System.out.print("삭제할 ID를 입력해주세요 >>> ");
					uv.setId(sc.nextLine());
					System.out.print("Password를 입력해주세요 >>> ");
					uv.setPassword(sc.nextLine());
					ud.delete(uv);
					break;
				case 4://[2]-4. 로그인한 ID의 incomeexpense 조회(카테고리,금액,(I/E),메모,시간)
					System.out.println("----------------------------");
					System.out.println("가계부 조회 유형을 선택하세요.");
					System.out.println("1.전체조회  2.기간별조회  3.유형별 조회 ");
					System.out.println("----------------------------");
					System.out.print("입력 ▶ ");
					
					choice = Integer.parseInt(sc.nextLine());
					switch (choice) {//switch[3]
					case 1:
						System.out.println(":::전체조회:::"); 
						dao.getId_list(id);
						break;
					case 2:
						System.out.println(":::기간별조회:::");
						System.out.print("시작일(yyyy-mm-dd) : ");
						String date1 = sc.nextLine();
						System.out.print("끝일(yyyy-mm-dd+1) : ");
						String date2 = sc.nextLine();
						dao.getId_selcetDate(id, date1, date2);;
						break;
					case 3:
						System.out.println(":::유형별조회:::");
						System.out.println(categoryList); //카테고리목록
						System.out.print("조회할 카테고리 입력하세요 >>> ");
						String category = sc.nextLine();
						dao.getId_selcetCate(id, category);
						break;
					}//switch[3] end
				
//					System.out.println(":::수입조회:::"); dao.getId_income(id);
//					System.out.println(":::지출조회:::"); dao.getId_expense(id);
					break;
				case 5://[2]-5. 나가기
					System.out.println("\n이용해주셔서 감사합니다.");		
					break;
				}//switch[2] end
			}//switch[1]-2의 while(5일때 탈출하는)end
			break; //switch[1]-2 break;
		case 3 : //[1]-3 나가기
			System.out.println("\n이용해주셔서 감사합니다.");		
			break;
		default:
			System.out.println("\n없는 번호입니다.");
			break;
		}//switch end
		
		
		
		
		
		
		
// [운영진] 	나중에 생각	
//	case 2 : // 2.회원 정보 전체 조회  
//		System.out.println("\n회원 전체 조회입니다");
//		System.out.println("조회중... 잠시만 기다려주세요");
//		bd.getList(); //회원정보 전체조회
//		break;
//	case 3 ://3.id로 한 사람만 정보조회
//		System.out.print("\n조회할 id를 입력하세요 >>> ");
//		id = sc.nextLine();
//		System.out.print("비밀번호를 입력하세요 >>> ");
//		password = Integer.parseInt(sc.nextLine());
//		System.out.println("조회중... 잠시만 기다려주세요");
//		bd.getId(id,password);
//		break;
//		
		
	}//main end
}
