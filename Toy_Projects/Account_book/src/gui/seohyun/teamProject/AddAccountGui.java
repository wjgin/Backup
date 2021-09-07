package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import dao.seungJoon.teamProject.AccountDao;
import vo.seungJoon.teamProject.AccountVo;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

// 계좌등록 클래스
@SuppressWarnings("serial")
public class AddAccountGui extends javax.swing.JFrame {

	public AddAccountGui(String id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		initComponents(id);
	}

	private void initComponents(String id) {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jComboBox1 = new javax.swing.JComboBox<>();

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(AddAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(AddAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(AddAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(AddAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}
		// </editor-fold>

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});
		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel5.setText("계좌번호");

		jButton1.setText("등록");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel1.setText("계좌등록");

		jTextField1.setText(accountHint);
		jTextField1.setForeground(Color.GRAY);
		jTextField1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText(accountHint);
					jTextField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals(accountHint)) {
					jTextField1.setText("");
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});

		jTextField2.setText(ownerHint);
		jTextField2.setForeground(Color.GRAY);
		jTextField2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField2.getText().equals("")) {
					jTextField2.setText(ownerHint);
					jTextField2.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField2.getText().equals(ownerHint)) {
					jTextField2.setText("");
					jTextField2.setForeground(Color.BLACK);
				}
			}
		});

		// "예금주" 텍스트 필드
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		// "계좌번호" 텍스트 필드
		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt);
			}
		});

		jTextField3.setText(id);
		jTextField3.setForeground(Color.red);
		jTextField3.setEditable(false);
		jTextField3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField3ActionPerformed(evt);
			}
		});

		jLabel2.setText("예금주");

		jLabel3.setText("계좌번호");

		jLabel4.setText("ID");

		jButton2.setText("초기화");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jLabel6.setText("은행");

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "신한은행", "국민은행", "농협", "우리은행" }));
		jComboBox1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jComboBox1ActionPerformed(evt);
			}
		});
		
		jLabel7.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel7.setVisible(false);

		// layout 조정
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGap(34)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
									.addGap(4))
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.TRAILING)
										.addComponent(jLabel4)
										.addComponent(jLabel2))
									.addGap(18)))
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
								.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addComponent(jLabel6)
							.addGap(18)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))))
					.addGap(0, 59, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(76, Short.MAX_VALUE)
					.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(71))
				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
					.addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton2)
						.addComponent(jButton1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);

	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private AccountVo vo;
	String accountHint = "숫자만 입력하세요.";
	String ownerHint = "예금주 혹은 별칭";
	// End of variables declaration

	// event listeners

	// "등록" 버튼 이벤트
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		if (jTextField1.getText().equals(accountHint) || jTextField1.getText().equals(ownerHint)) {

		} else {
			vo = new AccountVo();
			vo.setBank(jComboBox1.getSelectedItem().toString());
			vo.setOwner(jTextField1.getText());
			vo.setAccNum(jTextField2.getText());
			vo.setId(jTextField3.getText());

			AccountDao md = AccountDao.getInstance();
			md.insert(vo);
			dispose();
		}
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	// "초기화" 버튼 이벤트
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jTextField1.setText(accountHint);
		jTextField2.setText(ownerHint);
	}

	private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}
}
