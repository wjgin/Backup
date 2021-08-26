package gui.seohyun.teamProject;
//계좌테이블
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class tableGui3 extends JFrame {
	tableGui3() {
		createMenu();
		
		String data[][] = { // 테이블 생성(괄호안 데이터들은 임의로 작성)
				{ "신한은행", "111000", "이서현", "lsh0512" }, { "국민은행", "111222", "홍길동", "hong000" },
				{ "농협은행", "122333", "강감찬", "kkc0101" } };
		String column[] = { "은행", "계좌번호", "이름", "아이디" };// 칼럼(열) 이름

		JTable jt = new JTable(data, column);
		jt.setCellSelectionEnabled(true);
		ListSelectionModel select = jt.getSelectionModel();// 리스트모델
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 하나의 셀만 선택

		
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		setTitle("계좌테이블");
		setSize(250, 200);
		setVisible(true);

	}

	public void createMenu() {
		// 메뉴바 생성
		JMenuBar mb = new JMenuBar();
		// 메뉴생성
		JMenu screenMenu = new JMenu("필터");
		JMenu screenMenu2 = new JMenu("계좌관리");
		JMenu screenMenu3 = new JMenu("exit");
		// 메뉴에 부착할 아이템 생성
		screenMenu.add(new JMenuItem("기간별 조회"));
		screenMenu.add(new JMenuItem("지출/수입별"));
		screenMenu.add(new JMenuItem("카테고리별"));

		screenMenu2.add(new JMenuItem("계좌등록"));
		screenMenu2.add(new JMenuItem("계좌관리"));
		screenMenu2.add(new JMenuItem("계좌수정"));

		// 메뉴바에 메뉴부착
		mb.add(screenMenu);
		mb.add(screenMenu2);
		mb.add(screenMenu3);

		// 메뉴바를 현재프레임의 메뉴로 지정
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new tableGui3();
		
		//JFrame f = new JFrame("계좌테이블");
		
//		f.setSize(300, 200);
//		f.setVisible(true);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}