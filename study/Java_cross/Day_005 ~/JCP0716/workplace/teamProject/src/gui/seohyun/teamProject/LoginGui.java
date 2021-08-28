/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import dao.seungJoon.teamProject.UserinfoDao;

@SuppressWarnings("serial")
public class LoginGui extends javax.swing.JFrame {
	UserinfoDao bd;

	public LoginGui() {
		bd = UserinfoDao.getInstance();
		initComponents();
	}

	private void initComponents() {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(LoginGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		textField1 = new java.awt.TextField();
		textField2 = new java.awt.TextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);

		String idHint = "아이디 입력";
		textField1.setText(idHint);
		textField1.setForeground(Color.GRAY);
		textField1.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (textField1.getText().equals("")) {
					textField1.setText(idHint);
					textField1.setFont(lostFont);
					textField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (textField1.getText().equals(idHint)) {
					textField1.setText("");
					textField1.setFont(gainFont);
					textField1.setForeground(Color.BLACK);
				}
			}
		});

		String pwHint = "패스워드 입력";
		textField2.setText(pwHint);
		textField2.setForeground(Color.GRAY);
		textField2.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (textField2.getText().equals("")) {
					textField2.setText(pwHint);
					textField2.setFont(lostFont);
					textField2.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (textField2.getText().equals(pwHint)) {
					textField2.setText("");
					textField2.setFont(gainFont);
					textField2.setForeground(Color.BLACK);
				}
			}
		});

		jLabel1.setText("ID  :");

		jLabel2.setText("PW :");

		jLabel3.setIcon(new javax.swing.ImageIcon(
				"D:\\Desktop\\PJ\\study\\Java_cross\\Day_005 ~\\JCP0716\\workplace\\teamProject\\2021.08.27\\loginlogo.png")); // NOI18N

		jLabel4.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 14)); // NOI18N
		jLabel4.setText("로그인에 실패하셨습니다");
		jLabel4.setVisible(false);

		jButton1.setText("로그인");
		jButton1.addActionListener(login); // login 이벤트 리스너

		jButton2.setText("회원가입");
		jButton2.addActionListener(openJoinWindow);

		jButton3.setText("나가기");
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(0, 37, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25).addComponent(jLabel2).addGap(18, 18, 18).addComponent(textField2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 98,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(jButton1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton2)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jButton3))
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 288,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(58, 58, 58))
				.addGroup(layout.createSequentialGroup().addGap(109, 109, 109).addComponent(jLabel4)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(34, 34, 34)
				.addComponent(
						jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(3, 3, 3)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2)
						.addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addGap(29, 29, 29)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jButton2)
						.addComponent(jButton3).addComponent(jButton1))
				.addGap(18, 18, 18).addComponent(jLabel4).addContainerGap(35, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setAutoRequestFocus(false);

	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private java.awt.TextField textField1;
	private java.awt.TextField textField2;

	// "로그인" 버튼 클릭 이벤트
	private ActionListener login = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			String id = textField1.getText();
			String pw = textField2.getText();

			if (bd.checkIdPw(id, pw)) {
				System.out.println("아이디 확인");
				jLabel1.setVisible(false);
				new SelectAllGui(id);
				dispose();
			} else {
				System.out.println("로그인 오류");
				jLabel4.setVisible(true);
			}
		}
	}; // end login trigger

	// "회원가입" 버튼 클릭 이벤트
	private ActionListener openJoinWindow = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new JoinGui();
		}
	};

}
