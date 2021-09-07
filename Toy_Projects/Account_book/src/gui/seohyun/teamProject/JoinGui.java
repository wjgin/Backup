package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import dao.seungJoon.teamProject.UserinfoDao;
import vo.seungJoon.teamProject.UserinfoVo;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFrame;

// 회원가입 클래스
@SuppressWarnings("serial")
public class JoinGui extends javax.swing.JFrame {

	public JoinGui() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setAutoRequestFocus(false);
		setResizable(false);
		initComponents();
	}

	private void initComponents() {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});


		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(JoinGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(JoinGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(JoinGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(JoinGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2 = new javax.swing.JLabel();
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3 = new javax.swing.JLabel();
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4 = new javax.swing.JLabel();
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5 = new javax.swing.JLabel();
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6 = new JLabel("");
		jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
//		
//		Font gainFont = new Font("Glum12", Font.PLAIN, 11);
//		Font lostFont = new Font("Glum12", Font.ITALIC, 11);
		
		jTextField1.setText(idHint);
		jTextField1.setForeground(Color.GRAY);
		jTextField1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText(idHint);
					//jTextField1.setFont(lostFont);
					jTextField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals(idHint)) {
					jTextField1.setText("");
					//jTextField1.setFont(gainFont);
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});
		
		jTextField2.setText(pwHint);
		jTextField2.setForeground(Color.GRAY);
		jTextField2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField2.getText().equals("")) {
					jTextField2.setText(pwHint);
					//jTextField2.setFont(lostFont);
					jTextField2.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField2.getText().equals(pwHint)) {
					jTextField2.setText("");
					//jTextField2.setFont(gainFont);
					jTextField2.setForeground(Color.BLACK);
				}
			}
		});
		
		jTextField3.setText(phHint);
		jTextField3.setForeground(Color.GRAY);
		jTextField3.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField3.getText().equals("")) {
					jTextField3.setText(phHint);
					//jTextField3.setFont(lostFont);
					jTextField3.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField3.getText().equals(phHint)) {
					jTextField3.setText("");
					//jTextField3.setFont(gainFont);
					jTextField3.setForeground(Color.BLACK);
				}
			}
		});
		
		jTextField4.setText(nameHint);
		jTextField4.setForeground(Color.GRAY);
		jTextField4.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField4.getText().equals("")) {
					jTextField4.setText(nameHint);
					//jTextField4.setFont(lostFont);
					jTextField4.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField4.getText().equals(nameHint)) {
					jTextField4.setText("");
					//jTextField4.setFont(gainFont);
					jTextField4.setForeground(Color.BLACK);
				}
			}
		});
		
		jLabel1.setText("가입할 ID  :");
		
		jLabel2.setText("가입할 PW :");

		jLabel3.setText("전화번호   :");

		jLabel4.setText("성명 :");

		jLabel5.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel5.setText("회원가입");

		jButton1.setText("등록");
		jButton1.addActionListener(userJoin); // 유저 정보 등록 이벤트 리스너

		jButton2.setText("초기화");
		jButton2.addActionListener(initTextField);

		jButton3.setText("나가기");
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(12)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTextField4))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(12)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTextField3))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(12)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTextField2))
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(12)
						.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(jTextField1))
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(60)
						.addComponent(jButton1)
						.addGap(7)
						.addComponent(jButton2)
						.addGap(7)
						.addComponent(jButton3)))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(jLabel1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(jLabel2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(jLabel3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(jLabel4))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(jButton1)
						.addComponent(jButton2)
						.addComponent(jButton3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private UserinfoVo vo;
	private UserinfoDao bd;
	String idHint = "영문 및 숫자 (10자 이내)";
	String pwHint = "영문 및 숫자  (8자 이내)";
	String phHint = "숫자만 (11자 이내)";
	String nameHint = "한글 (8자 이내)";
	// End of variables declaration

	// "등록" 이벤트
	private ActionListener userJoin = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (jTextField1.getText().equals(idHint) || jTextField2.getText().equals(pwHint)
					|| jTextField3.getText().equals(phHint) || jTextField4.getText().equals(nameHint)) {
				jLabel6.setText("모든 항목을 입력해주세요");
			} else {
				if (jTextField1.getText().length() > 10) {
					jLabel6.setText("아이디가 너무 깁니다.\n(영문, 숫자 조합 10자 이내)");
				} else if (jTextField2.getText().length() > 8) {
					jLabel6.setText("비밀번호가 너무 깁니다.\n(영문, 숫자 조합 8자 이내)");
				} else if (jTextField3.getText().length() > 11) {
					jLabel6.setText("전화번호가 너무 깁니다.\n(숫자 11자 이내)");
				} else if (jTextField4.getText().length() > 8) {
					jLabel6.setText("이름이 너무 깁니다.\n(한글 8자 이내)");
				} else {
					vo = new UserinfoVo(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(),
							jTextField4.getText());
					bd = UserinfoDao.getInstance();
					
					if (!bd.idcheck(vo.getId())) {
						bd.insert(vo);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "이미 존재하는 아이디입니다");
					}
				}
			}

		}
	}; // userJoin end

	// "초기화" 버튼 이벤트
	private ActionListener initTextField = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			jTextField1.setText(idHint);
			jTextField2.setText(pwHint);
			jTextField3.setText(phHint);
			jTextField4.setText(nameHint);
		}
	}; // init end

}
