package gui.seohyun.teamProject;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import dao.seungJoon.teamProject.UserinfoDao;

public class Pre_LoginGui extends JFrame {

	private JFrame frame;
	private JLabel bottomLabel;
	private JTextField tf;
	private JTextField tf2;
	private JButton button;
	private JButton button2;
	private Label IdLabel;
	private Label PWLabel;
	UserinfoDao bd = UserinfoDao.getInstance();

	Pre_LoginGui() {
		// frame 위치 및 크기 서정
		frame = new JFrame();
		frame.setTitle("가계부 프로그램");
		//setSize(300, 300);
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		
		// 버튼 설정
		button = new JButton("로그인");
		button2 = new JButton("회원가입");
		IdLabel = new Label("ID:");
		tf = new JTextField("", 20);
		PWLabel = new Label("PW:");
		tf2 = new JTextField("", 20);
		bottomLabel = new JLabel("아이디와 비밀번호를 입력하세요.");
		
		// 로그인 버튼 클릭시 이벤트시 login 실행
		button.addActionListener(login);

		frame.setLayout(new FlowLayout());
		frame.add(IdLabel);
		frame.add(tf, BorderLayout.CENTER);
		frame.add(PWLabel);
		frame.add(tf2, BorderLayout.SOUTH);
		frame.add(button);
		frame.add(button2);
		frame.add(bottomLabel);

		frame.setVisible(true);
		// 내 프로그램 닫는 기능을 닫기버튼으로 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Pre_LoginGui();
	}

	
	// login 이벤트 트리거
	private ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = tf.getText();
			String pw = tf2.getText();

			if (bd.checkIdPw(id, pw)) {
				System.out.println("아이디 확인");
				bottomLabel.setText(id + "님이 로그인 중 입니다....");
				tf.setVisible(false);
				tf2.setVisible(false);
				button.setVisible(false);
				button2.setVisible(false);
				IdLabel.setVisible(false);
				PWLabel.setVisible(false);
				new tableGui4(id);
			} else {
				bottomLabel.setText("아이디 혹은 비밀번호를 다시 확인 하세요.");
			}
		}
	}; // end login trigger

}
