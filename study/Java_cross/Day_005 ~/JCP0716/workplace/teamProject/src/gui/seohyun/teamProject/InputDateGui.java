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


// 계좌등록 클래스
@SuppressWarnings("serial")
public class InputDateGui extends javax.swing.JFrame {

    public InputDateGui(String id) {
        initComponents(id);
    }

    private void initComponents(String id) {
    	JFrame frame = new JFrame();
    	JLabel label1 = new JLabel("시작 날짜");
    	label1.setBounds(23, 1, 56, 37);
    	JLabel label2 = new JLabel("종료 날짜");
    	label2.setBounds(23, 38, 56, 37);
    	JTextField textField1 = new JTextField();
    	textField1.setBounds(91, 1, 194, 37);
    	JTextField textField2 = new JTextField();
    	textField2.setBounds(91, 38, 194, 37);
    	JButton button1 = new JButton("검색");
    	button1.setBounds(0, 75, 140, 37);
    	JButton button2 = new JButton("취소");
    	button2.setBounds(145, 75, 140, 37);
    	
    	
    	frame.setTitle("날짜별 검색");
    	frame.setResizable(false);
    	frame.setVisible(true);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setLayout(new GridLayout(3, 2, 5, 0));
    	
    	frame.add(label1);
    	frame.add(textField1);
    	frame.add(label2);
    	frame.add(textField2);
    	frame.add(button1);
    	frame.add(button2);
    	
    	frame.setSize(300, 150);
    	frame.setVisible(true);

    	

		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
    	String startDateHint = "yyyy-mm-dd";
    	String endDateHint = "yyyy-mm-dd";
    	textField1.setText(startDateHint);
		textField1.setForeground(Color.GRAY);
		textField2.setText(startDateHint);
		textField2.setForeground(Color.GRAY);
		
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
		textField2.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (textField2.getText().equals("")) {
					textField2.setText(endDateHint);
					textField2.setFont(lostFont);
					textField2.setForeground(Color.GRAY);
				}
			}
			@Override
			public void focusGained(FocusEvent e) {
				if (textField2.getText().equals(endDateHint)) {
					textField2.setText("");
					textField2.setFont(gainFont);
					textField2.setForeground(Color.BLACK);
				}
			}
		});
    	

    	button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectDateGui(id, textField1.getText(), textField2.getText());
				dispose();
			}
		});
    	button2.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    		}
    	});
    	
    	

    	
    	
    }
}
