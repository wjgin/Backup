package gui.seohyun.teamProject;

import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import dao.seungJoon.teamProject.InexDao;
import vo.seungJoon.teamProject.InexVo;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SelectAllGui extends javax.swing.JFrame {

	public SelectAllGui(String id) {
		initComponents(id);
	}

	private void initComponents(String id) {
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
			java.util.logging.Logger.getLogger(SelectAllGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(SelectAllGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(SelectAllGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(SelectAllGui.class.getName()).log(java.util.logging.Level.SEVERE, null,
					ex);
		}

		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setEnabled(false);

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenu2 = new javax.swing.JMenu();
		jMenu3 = new javax.swing.JMenuItem();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();
		jMenuItem5 = new javax.swing.JMenuItem();
		
		vo = new InexVo();
		vo.setUserinfo_id(id);

		// 로그인 후 사용자 id를 받아서 전체 가게부 리스트 가져오기
		InexDao dao = InexDao.getInstance();

		// 가게부 리스트를 2차원 배열 data로 매핑
		rows = dao.getListById(id);
		columns = new String[] { "수입|지출", "날짜", "금액", "분류", "메모", "계좌번호" , "IDX"};
		data = rows.stream().toArray(String[][]::new);

		// jTable1 생성
		model = new DefaultTableModel(data, columns);
		jTable1 = new javax.swing.JTable(model);
		jScrollPane1.setViewportView(jTable1);
		
		// jTable1 컬럼 별 정렬
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable1.getModel());
		jTable1.setRowSorter(sorter);


		jButton1.setText("등록");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("새로고침");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt, id);
			}
		});
		
		jButton3.setText("삭제");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
		jLabel1.setText("나의 가계부");

		jMenu1.setText("필터");

		jMenuItem1.setText("기간별 조회");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt, id);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText("지출/수입별 조회");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt, id);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuItem3.setText("카테고리별조회");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt, id);
			}
		});
		
		jMenu1.add(jMenuItem3);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("계좌관리");

		jMenuItem4.setText("계좌등록");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt, id);
			}
		});

		jMenuItem5.setText("계좌확인");
		jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem5ActionPerformed(evt, id);
			}
		});

		jMenu2.add(jMenuItem4);
		jMenu2.add(jMenuItem5);
		jMenuBar1.add(jMenu2);

		jMenu3.setText("exit");
		jMenu3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenu3ActionPerformed(evt);
			}
		});

		jMenuBar1.add(jMenu3);
		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(188, 188, 188).addComponent(jButton2)
										.addGap(39, 39, 39).addComponent(jButton1).addGap(38, 38, 38)
										.addComponent(jButton3).addGap(0, 0, Short.MAX_VALUE))
								.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
										layout.createSequentialGroup().addGap(0, 12, Short.MAX_VALUE).addComponent(
												jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				.addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(57, Short.MAX_VALUE).addComponent(jLabel1)
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton2).addComponent(jButton1).addComponent(jButton3))
						.addGap(27, 27, 27)));

		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}// </editor-fold>

	
		// "기간별 조회" 이벤트
	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		new InputDateGui(id);

	}

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		new ChoiceIE(id);
	}
	
	// "새로고침" 이벤트
	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		InexDao dao = InexDao.getInstance();

		// 새 list를 가져오기
		rows = dao.getListById(id);
		columns = new String[] { "수입|지출", "날짜", "금액", "분류", "메모", "계좌번호" , "IDX"};
		data = rows.stream().toArray(String[][]::new);

		// 새 모델 생성 후 테이블 생성
		model = new DefaultTableModel(data, columns);
		jTable1 = new javax.swing.JTable(model);
		
		// jTable1 sort
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable1.getModel());
		jTable1.setRowSorter(sorter);

		jScrollPane1.setViewportView(jTable1);
	}
	
	// "삭제" 이벤트
	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		int row = jTable1.getSelectedRow();
		int idx = Integer.valueOf((String)jTable1.getValueAt(row, 6));
		InexDao dao = new InexDao();
		
		model.removeRow(row);
		dao.delete(idx);
		
		System.out.println(row +"  "+ idx);
	}

	// "카테고리별 조회" 이벤트
	private void jMenuItem3ActionPerformed(ActionEvent evt, String id) {
		new InputCategoryGui(id);
	}
	
	// "계좌등록" 이벤트
	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		new AddAccountGui(id);
	}

	// "계좌확인" 이벤트
	private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt, String id) {
		new MyAccountGui(id);
	}

	// "가계등록" 이벤트
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		new RegistGui(vo);
	}

	// "exit" 이벤트
	private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenuItem jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JMenuItem jMenuItem5;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	List<String[]> rows;
	String[][] data;
	private DefaultTableModel model;
	private String[] columns;
	private InexVo vo;
	// End of variables declaration
}
