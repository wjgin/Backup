/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import dao.seungJoon.teamProject.AccountDao;
import dao.seungJoon.teamProject.InexDao;
import vo.seungJoon.teamProject.InexVo;

// 가계부 등록 클래스
@SuppressWarnings("serial")
public class RegistGui extends javax.swing.JFrame {

	public RegistGui(InexVo vo) {
		initComponents(vo);
	}

	private void initComponents(InexVo vo) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(RegistGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(RegistGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(RegistGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RegistGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});

		new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox<>();
		jComboBox2 = new javax.swing.JComboBox<>();

		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel1.setText("가계부 등록");
		jLabel2.setText("날짜 :");
		jLabel3.setText("금액 :");
		jLabel4.setText("분류:");
		jLabel5.setText("메모:");
		jLabel6.setText("수입 | 지출");
		jLabel7.setText("계좌번호");

		jLabel8.setText("필수사항을 모두 입력해 주세요.");
		jLabel8.setVisible(false);

		// ================== textFields edit
		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
		jTextField1.setText(dateHint);
		jTextField1.setForeground(Color.GRAY);
		jTextField1.setFont(lostFont);
		jTextField2.setText(priceHint);
		jTextField2.setForeground(Color.GRAY);
		jTextField2.setFont(lostFont);
		jTextField3.setText(categoryHint);
		jTextField3.setForeground(Color.GRAY);
		jTextField3.setFont(lostFont);
		jTextField4.setText(memoHint);
		jTextField4.setForeground(Color.GRAY);
		jTextField4.setFont(lostFont);

		jTextField1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField1.getText().equals("")) {
					jTextField1.setText(dateHint);
					jTextField1.setFont(lostFont);
					jTextField1.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField1.getText().equals(dateHint)) {
					jTextField1.setText("");
					jTextField1.setFont(gainFont);
					jTextField1.setForeground(Color.BLACK);
				}
			}
		});

		jTextField2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField2.getText().equals("")) {
					jTextField2.setText(priceHint);
					jTextField2.setFont(lostFont);
					jTextField2.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField2.getText().equals(priceHint)) {
					jTextField2.setText("");
					jTextField2.setFont(gainFont);
					jTextField2.setForeground(Color.BLACK);
				}
			}
		});

		jTextField3.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField3.getText().equals("")) {
					jTextField3.setText(categoryHint);
					jTextField3.setFont(lostFont);
					jTextField3.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField3.getText().equals(categoryHint)) {
					jTextField3.setText("");
					jTextField3.setFont(gainFont);
					jTextField3.setForeground(Color.BLACK);
				}
			}
		});

		jTextField4.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (jTextField4.getText().equals("")) {
					jTextField4.setText(memoHint);
					jTextField4.setFont(lostFont);
					jTextField4.setForeground(Color.GRAY);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (jTextField4.getText().equals(memoHint)) {
					jTextField4.setText("");
					jTextField4.setFont(gainFont);
					jTextField4.setForeground(Color.BLACK);
				}
			}
		});
		// ================== textFields edit end
		
		jButton1.setText("등록");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, vo);
			}
		});

		jButton2.setText("초기화");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		AccountDao dao = new AccountDao();
		String[] accountNums = dao.getAccoutNum(vo.getUserinfo_id()).stream().toArray(String[]::new);
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "수입 ", "지출" }));
		jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(accountNums));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup()
				.addGap(18)
				.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup().addComponent(jLabel7).addGap(18))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel6)
										.addPreferredGap(ComponentPlacement.UNRELATED))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(jLabel3)
												.addComponent(jLabel4, Alignment.LEADING).addComponent(jLabel2))
										.addGap(18))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel5).addGap(18)))
								.addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout
										.createParallelGroup(Alignment.TRAILING).addComponent(jLabel1)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(Alignment.LEADING)
														.addComponent(jTextField2, 165, 165, 165)
														.addGroup(layout.createSequentialGroup()
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(jTextField3, GroupLayout.DEFAULT_SIZE,
																		165, Short.MAX_VALUE))
														.addComponent(jTextField4, 165, 165, 165)
														.addComponent(jComboBox1, 0, 165, Short.MAX_VALUE)
														.addComponent(jComboBox2, 0, 165, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED)))
										.addComponent(jTextField1, 165, 165, 165)))
						.addGroup(layout.createSequentialGroup().addGap(56).addGroup(layout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup().addComponent(jButton1)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jButton2)))
								.addGap(1)))
				.addGap(40)));
		layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(33).addComponent(jLabel1).addGap(18)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel7))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel6))
						.addGap(9)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel3))
						.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel4))
						.addGap(31)
						.addGroup(
								layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 49,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5))
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(jLabel8).addGap(7).addGroup(layout
								.createParallelGroup(Alignment.BASELINE).addComponent(jButton1).addComponent(jButton2))
						.addGap(18)));
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	// ======================button event
	// 등록 버튼
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, InexVo vo) {
		if (jTextField1.getText().equals(dateHint) || jTextField2.getText().equals(dateHint)
				|| jTextField3.getText().equals(dateHint)) {
			jLabel8.setVisible(true);
		} else {
			InexDao dao = new InexDao();
			InexVo ieVo = new InexVo();
			ieVo = vo;
			ieVo.setIe_time(Date.valueOf(jTextField1.getText()));
			ieVo.setIe_category(jTextField3.getText());

			if (((String) jComboBox1.getSelectedItem()).equals("수입")) {
				ieVo.setIe_division("I");
			} else
				ieVo.setIe_division("E");

			ieVo.setIe_price(Integer.valueOf(jTextField2.getText()));
			ieVo.setAccount_num((String) jComboBox2.getSelectedItem());
			if (jTextField4.getText().equals(memoHint)) {
				ieVo.setIe_memo("");
			} else {
				ieVo.setIe_memo(jTextField4.getText());
			}
			dao.insert(ieVo);
		}
	}

	// 초기화 버튼
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		jTextField1.setText("");
		jTextField2.setText("");
		jTextField3.setText("");
		jTextField4.setText("");
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JComboBox<String> jComboBox2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;

	String dateHint = "(essential) yyyy-mm-dd";
	String priceHint = "(essential) only number";
	String categoryHint = "(essential) category";
	String memoHint = "(optional)";
	// End of variables declaration
}
