package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


// 계좌등록 클래스
@SuppressWarnings("serial")
public class InputCategoryGui extends javax.swing.JFrame {

    public InputCategoryGui(String id) {
        initComponents(id);
    }

    private void initComponents(String id) {
    	JFrame frame = new JFrame();
    	JLabel label1 = new JLabel("검색어");
    	label1.setHorizontalAlignment(SwingConstants.CENTER);
    	label1.setBounds(0, 19, 140, 37);
    	JTextField textField1 = new JTextField();
    	textField1.setHorizontalAlignment(SwingConstants.CENTER);
    	textField1.setBounds(145, 19, 140, 37);
    	JButton button1 = new JButton("검색");
    	button1.setBounds(0, 66, 140, 37);
    	JButton button2 = new JButton("취소");
    	button2.setBounds(145, 66, 140, 37);
    	
    	
    	frame.setTitle("카테고리 검색");
    	frame.setResizable(false);
    	frame.setVisible(true);
    	frame.setLocationRelativeTo(null);
    	frame.getContentPane().setLayout(null);
    	
    	frame.getContentPane().add(label1);
    	frame.getContentPane().add(textField1);
    	frame.getContentPane().add(button1);
    	frame.getContentPane().add(button2);
    	
    	frame.setSize(300, 150);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	

		Font gainFont = new Font("Glum12", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
    	String startDateHint = "category";
    	textField1.setText("category");
		textField1.setForeground(Color.GRAY);
		
		textField1.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField1.getText().equals("")) {
					textField1.setText(startDateHint);
					textField1.setFont(lostFont);
					textField1.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (textField1.getText().equals(startDateHint)) {
					textField1.setText("");
					textField1.setFont(gainFont);
					textField1.setForeground(Color.BLACK);
				}
			}
		});
    	

		// "확인" 이벤트
    	button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				category = textField1.getText();
				
				new SelectCategoryGui(id, category);
				frame.dispose();
			}
		});
    	
    	// "취소" 이벤트
    	button2.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    		}
    	});
    	

    }
    
    
    private String category;
}
