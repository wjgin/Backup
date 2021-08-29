package gui.seohyun.teamProject;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

// 수입 및 지출 선택 창
@SuppressWarnings("serial")
public class ChoiceIE extends javax.swing.JFrame {

	public ChoiceIE(String id) {
		setBackground(Color.WHITE);
		initComponents(id);
	}

	private void initComponents(String id) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(ChoiceIE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ChoiceIE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ChoiceIE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ChoiceIE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel6 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setHorizontalAlignment(SwingConstants.CENTER);
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox<>();

		// setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel1.setText("수입 | 지출 선택");
		jLabel6.setText("수입 | 지출");

		jLabel8.setText("수입 혹은 지출을 선택해주세요.");
		jLabel8.setVisible(false);

		jButton1.setText("등록");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, id);
			}
		});

		jButton2.setText("닫기");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "수입 ", "지출" }));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addContainerGap(90, Short.MAX_VALUE)
					.addComponent(jButton1)
					.addGap(28)
					.addComponent(jButton2)
					.addGap(65))
				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
					.addGap(18)
					.addComponent(jLabel6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(jComboBox1, 0, 165, Short.MAX_VALUE)
					.addGap(40))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(33)
					.addComponent(jLabel1)
					.addGap(39)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel6))
					.addGap(18)
					.addComponent(jLabel8)
					.addGap(18)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jButton2)
						.addComponent(jButton1))
					.addContainerGap(116, Short.MAX_VALUE))
		);
		getContentPane().setLayout(layout);

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>

	// ======================button event
	// 등록 버튼
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		String division = (String)jComboBox1.getSelectedItem();
		System.out.println(id + "   " + division);
		new SelectDivisionGui(id, division);
		dispose();
	}

	// 종료 버튼
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		dispose();
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JComboBox<String> jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel8;

	String dateHint = "(essential) yyyy-mm-dd";
	String priceHint = "(essential) only number";
	String categoryHint = "(essential) category";
	String memoHint = "(optional)";
	// End of variables declaration
}
