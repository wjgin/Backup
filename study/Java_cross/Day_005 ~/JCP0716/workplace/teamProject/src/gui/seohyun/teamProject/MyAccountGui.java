package gui.seohyun.teamProject;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.seungJoon.teamProject.AccountDao;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dao.seungJoon.teamProject.AccountDao;

@SuppressWarnings("serial")
public class MyAccountGui extends javax.swing.JFrame {

    public MyAccountGui(String id) {
        initComponents(id);
    }

    @SuppressWarnings({ "unchecked" })
    private void initComponents(String id) {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyAccountGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });

        
    	// 로그인 후 사용자 id를 받아서 전체 가게부 리스트 가져오기
		AccountDao dao = AccountDao.getInstance();

		rows = dao.getList(id);
		columns = new String [] { "은행", "계좌번호", "예금주"};
		data = rows.stream().toArray(String[][]::new);
		
		// jTable1 생성
		model = new DefaultTableModel(data, columns);
		jTable1 = new javax.swing.JTable(model);
		// jTable1 sort
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable1.getModel());
		jTable1.setRowSorter(sorter);
        
//        jTable1.setModel(new javax.swing.table.DefaultTableModel() {
//            @SuppressWarnings("rawtypes")
//			Class[] types = new Class [] {
//                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
//            };
//
//            @SuppressWarnings("rawtypes")
//			public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//        });
		
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("등록");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	jButton1ActionPerformed(evt, id);
            }
        });

        jLabel1.setFont(new java.awt.Font("휴먼둥근헤드라인", 0, 24)); // NOI18N
        jLabel1.setText("      계좌관리");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(74, 74, 74))
        );

        pack();
        setLocationRelativeTo(null); 
    }


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private List<String[]> rows;
    private String[] columns;
    private String[][] data;
    private DefaultTableModel model;
    // End of variables declaration       
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, String id) {     
    	new AddAccountGui(id);
    	dispose();
    }    

    
}
