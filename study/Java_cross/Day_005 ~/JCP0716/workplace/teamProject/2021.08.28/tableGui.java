/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import java.util.List;

import dao.InexDao;





/**
 *
 * @author ITCS
 */
@SuppressWarnings("serial")
public class tableGui extends javax.swing.JFrame {

	   /**
	    * Creates new form TableGui
	    */
	   public tableGui(String id) {
	       initComponents(id);
	   }



	/**
	    * This method is called from within the constructor to initialize the form.
	    * WARNING: Do NOT modify this code. The content of this method is always
	    * regenerated by the Form Editor.
	    */
	   @SuppressWarnings("unchecked")
	   // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	   private void initComponents(String id) {

	       jScrollPane1 = new javax.swing.JScrollPane();
	       jTable1 = new javax.swing.JTable();
	       jButton2 = new javax.swing.JButton();
	       jLabel1 = new javax.swing.JLabel();
	       jButton1 = new javax.swing.JButton();
	       jButton3 = new javax.swing.JButton();
	       jMenuBar1 = new javax.swing.JMenuBar();
	       jMenu1 = new javax.swing.JMenu();
	       jMenuItem1 = new javax.swing.JMenuItem();
	       jMenuItem2 = new javax.swing.JMenuItem();
	       jMenuItem3 = new javax.swing.JMenuItem();
	       jMenu2 = new javax.swing.JMenu();
	       jMenuItem4 = new javax.swing.JMenuItem();
	       jMenu3 = new javax.swing.JMenu();
	   	try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(tableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(tableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(tableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(tableGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				setVisible(true);
			}
		});

	       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	       // ????????? ??? ????????? id??? ????????? ?????? ????????? ????????? ????????????
	    		InexDao dao = InexDao.getInstance();

	    		// ????????? ???????????? 2?????? ?????? data??? ??????
	    		List<String[]> list = dao.getId_list(id);
	    		String[][] data = list.stream().toArray(String[][]::new);
	       
	       
	       
	       
	           jTable1.setModel(new javax.swing.table.DefaultTableModel(
	   				data,
	           new String [] {
	               "??????|??????", "??????", "??????", "??????", "??????"}){
	               private static final long serialVersionUID = 1L;
	               
	    	   ////??????????????? ???????????? ????????????
	    	   @SuppressWarnings("rawtypes")
	    		Class[] types = new Class[] { java.lang.String.class, java.lang.Object.class, java.lang.Object.class,
						java.lang.Object.class, java.lang.Object.class };
	           

	           public Class getColumnClass(int columnIndex) {
	               return types [columnIndex];
	           }
	       });
	       jScrollPane1.setViewportView(jTable1);

	       jButton2.setText("??????");

	       jLabel1.setFont(new java.awt.Font("????????????????????????", 0, 36)); // NOI18N
	       jLabel1.setText("           ?????? ?????????");
	       jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

	       jButton1.setText("??????");
	       jButton1.addActionListener(new java.awt.event.ActionListener() {
	           public void actionPerformed(java.awt.event.ActionEvent evt) {
	               jButton1ActionPerformed(evt);
	           }
	       });

	       jButton3.setText("??????");

	       jMenu1.setText("??????");

	       jMenuItem1.setText("????????? ??????");
	       jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
	           public void actionPerformed(java.awt.event.ActionEvent evt) {
	               jMenuItem1ActionPerformed(evt);
	           }
	       });
	       jMenu1.add(jMenuItem1);

	       jMenuItem2.setText("??????/????????? ??????");
	       jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
	           public void actionPerformed(java.awt.event.ActionEvent evt) {
	               jMenuItem2ActionPerformed(evt);
	           }
	       });
	       jMenu1.add(jMenuItem2);

	       jMenuItem3.setText("?????????????????????");
	       jMenu1.add(jMenuItem3);

	       jMenuBar1.add(jMenu1);

	       jMenu2.setText("????????????");

	       jMenuItem4.setText("????????????");
	       jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
	           public void actionPerformed(java.awt.event.ActionEvent evt) {
	               jMenuItem4ActionPerformed(evt,id);
	           }
	       });
	       jMenu2.add(jMenuItem4);

	       jMenuBar1.add(jMenu2);

	       jMenu3.setText("exit");
	       jMenuBar1.add(jMenu3);

	       setJMenuBar(jMenuBar1);

	       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	       getContentPane().setLayout(layout);
	       layout.setHorizontalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(layout.createSequentialGroup()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(layout.createSequentialGroup()
	                       .addGap(188, 188, 188)
	                       .addComponent(jButton2)
	                       .addGap(39, 39, 39)
	                       .addComponent(jButton1)
	                       .addGap(38, 38, 38)
	                       .addComponent(jButton3)
	                       .addGap(0, 0, Short.MAX_VALUE))
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                       .addGap(0, 12, Short.MAX_VALUE)
	                       .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
	               .addContainerGap())
	           .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	       );
	       layout.setVerticalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	               .addContainerGap(57, Short.MAX_VALUE)
	               .addComponent(jLabel1)
	               .addGap(18, 18, 18)
	               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
	               .addGap(33, 33, 33)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(jButton2)
	                   .addComponent(jButton1)
	                   .addComponent(jButton3))
	               .addGap(27, 27, 27))
	       );

	       pack();
	   }// </editor-fold>                        

	   private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	       // TODO add your handling code here:
	   }                                          

	   private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
	       // TODO add your handling code here:
	   }                                          


		// "????????????" ?????????
		private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt, String id) {
			new AccountGui(id);
		}
		
		// "????????????" ?????????
		private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
			new RegistGui();
		}                                       



	   // Variables declaration - do not modify                     
	   private javax.swing.JButton jButton1;
	   private javax.swing.JButton jButton2;
	   private javax.swing.JButton jButton3;
	   private javax.swing.JLabel jLabel1;
	   private javax.swing.JMenu jMenu1;
	   private javax.swing.JMenu jMenu2;
	   private javax.swing.JMenu jMenu3;
	   private javax.swing.JMenuBar jMenuBar1;
	   private javax.swing.JMenuItem jMenuItem1;
	   private javax.swing.JMenuItem jMenuItem2;
	   private javax.swing.JMenuItem jMenuItem3;
	   private javax.swing.JMenuItem jMenuItem4;
	   private javax.swing.JScrollPane jScrollPane1;
	   private javax.swing.JTable jTable1;
	   // End of variables declaration                   
	


}