package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class tableGui extends JFrame {
	tableGui(){
		setTitle("가계부 프로그램");
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
		public void createMenu() {
			//메뉴바 생성
			JMenuBar mb = new JMenuBar();
			//메뉴생성
			JMenu screenMenu = new JMenu("필터");
			//메뉴에 부착할 아이템 생성
			screenMenu.add(new JMenuItem("기간별 조회"));
			screenMenu.add(new JMenuItem("지출/수입별"));
			screenMenu.add(new JMenuItem("카테고리별"));
		
			//메뉴바에 메뉴부착
			mb.add(screenMenu);
			
			//메뉴바를 현재프레임의 메뉴로 지정
			setJMenuBar(mb);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new tableGui();

		}

}
