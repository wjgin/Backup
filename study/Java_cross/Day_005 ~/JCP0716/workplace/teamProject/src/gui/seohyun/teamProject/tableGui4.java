package gui.seohyun.teamProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
//가계부테이블
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

import dao.seungJoon.teamProject.AccountDao;
import dao.seungJoon.teamProject.InexDao;

public class tableGui4 extends JFrame {
	
	tableGui4(String id) {
		// 상단 메뉴탭 생성
		createMenu();
		
		// 종료
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		
		// 로그인 후 사용자 id를 받아서 전체 가게부 리스트 가져오기
		InexDao dao = InexDao.getInstance();

		// 가게부 리스트를 2차원 배열 data로 매핑
		List<String[]> list = dao.getId_list(id);
		String[][] data = list.stream().toArray(String[][]::new);

		// 가게부 테이블 컬럼 
		String column[] = { "수입|지출", "날짜", "금액" };// 칼럼(열) 이름
		
		// 가게부 테이블 생성
		JTable jt = new JTable(data, column);
		jt.setCellSelectionEnabled(true);
		ListSelectionModel select = jt.getSelectionModel();// 리스트모델
		select.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 하나의 셀만 선택

		select.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String Data = null;
				int[] row = jt.getSelectedColumns();
				int[] columns = jt.getSelectedColumns();

				for (int i = 0; i < row.length; i++) {
					for (int j = 0; j < columns.length; j++) {
						Data = (String) jt.getValueAt(row[i], columns[j]);
					}

				}
				JOptionPane.showInputDialog(this, "선택된 테이블은" + Data + "입니다");

			}

		});
		JScrollPane sp = new JScrollPane(jt);
		add(sp);
		setTitle("가계부테이블");
		// setSize(400, 300);
		setBounds(100, 100, 800, 600); // 크기 변경
		setLocationRelativeTo(null); // 중앙 정렬 추가
		setVisible(true);

	}

	public void createMenu() {
		// 메뉴바 생성
		JMenuBar mb = new JMenuBar();
		// 메뉴생성
		JMenu screenMenu = new JMenu("필터");
		JMenu screenMenu2 = new JMenu("계좌관리");
		JMenu screenMenu3 = new JMenu("가계");
		JMenu screenMenu4 = new JMenu("exit");
		
		screenMenu.add(new JMenuItem("기간별 조회"));
		screenMenu.add(new JMenuItem("지출/수입별"));
		screenMenu.add(new JMenuItem("카테고리별"));
		
		// 계좌 탭
		accountResist = new JMenuItem("계좌등록");
		accountManage = new JMenuItem("계좌관리");
		accountEdit = new JMenuItem("계좌수정");
		screenMenu2.add(accountResist);
		screenMenu2.add(accountManage);
		screenMenu2.add(accountEdit);
		
		JMenuItem resister = new JMenuItem("가계등록");
		screenMenu3.add(resister);
		
		
		// 이벤트 실행
		resister.addActionListener(resist);	// 가계 등록
		accountResist.addActionListener(openAccountResistWindow);	// 계좌 등록
		
		
		// 메뉴바에 메뉴부착
		mb.add(screenMenu);
		mb.add(screenMenu2);
		mb.add(screenMenu3);
		mb.add(screenMenu4);
		// 메뉴바를 현재프레임의 메뉴로 지정
		setJMenuBar(mb);
	}
	
	JMenuItem accountResist;
	JMenuItem accountManage;
	JMenuItem accountEdit;
	
	// "가계 등록" 탭 클릭 이벤트 정의
	private ActionListener resist = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new RegistGui();
		}
	};
	
	// "계좌 등록" 이벤트
	private ActionListener openAccountResistWindow = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("계좌 등록 창");
		}
	};

}