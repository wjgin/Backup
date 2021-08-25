package gui.seohyun.teamProject;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class tableGui extends JFrame {
	tableGui(){
		setTitle("����� ���α׷�");
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
		public void createMenu() {
			//�޴��� ����
			JMenuBar mb = new JMenuBar();
			//�޴�����
			JMenu screenMenu = new JMenu("����");
			//�޴��� ������ ������ ����
			screenMenu.add(new JMenuItem("�Ⱓ�� ��ȸ"));
			screenMenu.add(new JMenuItem("����/���Ժ�"));
			screenMenu.add(new JMenuItem("ī�װ���"));
		
			//�޴��ٿ� �޴�����
			mb.add(screenMenu);
			
			//�޴��ٸ� ������������ �޴��� ����
			setJMenuBar(mb);
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			new tableGui();

		}

}
