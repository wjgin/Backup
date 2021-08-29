package gui.seohyun.teamProject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


// 계좌등록 클래스
@SuppressWarnings("serial")
public class InputDateGui extends javax.swing.JFrame {

    public InputDateGui(String id) {
        initComponents(id);
    }

    private void initComponents(String id) {
    	JFrame frame = new JFrame();
    	JLabel label1 = new JLabel("시작 날짜");
    	label1.setHorizontalAlignment(SwingConstants.CENTER);
    	label1.setBounds(0, 13, 100, 42);
    	JLabel label2 = new JLabel("종료 날짜");
    	label2.setHorizontalAlignment(SwingConstants.CENTER);
    	label2.setBounds(0, 62, 100, 36);
    	label3 = new JLabel("올바르지 않은 형식 입니다.");
    	label3.setVisible(false);
    	JTextField textField1 = new JTextField();
    	textField1.setHorizontalAlignment(SwingConstants.CENTER);
    	textField1.setBounds(108, 17, 177, 36);
    	JTextField textField2 = new JTextField();
    	textField2.setHorizontalAlignment(SwingConstants.CENTER);
    	textField2.setBounds(108, 63, 177, 36);
    	JButton button1 = new JButton("검색");
    	button1.setBounds(10, 108, 100, 36);
    	JButton button2 = new JButton("취소");
    	button2.setBounds(185, 109, 100, 35);
    	
    	
    	frame.setTitle("날짜별 검색");
    	frame.setResizable(false);
    	frame.setVisible(true);
    	frame.setLocationRelativeTo(null);
    	frame.getContentPane().setLayout(null);
    	
    	frame.getContentPane().add(label1);
    	frame.getContentPane().add(textField1);
    	frame.getContentPane().add(label2);
    	frame.getContentPane().add(textField2);
    	frame.getContentPane().add(button1);
    	frame.getContentPane().add(button2);
    	
    	frame.setSize(301, 220);
    	frame.setVisible(true);
    	frame.setResizable(false);
    	frame.setLocationRelativeTo(null);
    	

		Font gainFont = new Font("Tahoma", Font.PLAIN, 11);
		Font lostFont = new Font("Tahoma", Font.ITALIC, 11);
    	String startDateHint = "yyyy-mm-dd";
    	String endDateHint = "yyyy-mm-dd";
    	textField1.setText(startDateHint);
		textField1.setForeground(Color.GRAY);
		textField2.setText(startDateHint);
		textField2.setForeground(Color.GRAY);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setBounds(0, 147, 289, 36);
		frame.getContentPane().add(label3);
		
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
    	

		// "확인" 이벤트
    	button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startDate = textField1.getText();
				endDate = textField2.getText();
				if(checkFormat(startDate) == true &&
						checkFormat(endDate) == true) {
					
					new SelectDateGui(id, startDate, endDate);
					frame.dispose();
				} else {
					label3.setVisible(true);
				}
					
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
    
    // 날짜형식 체크
	public boolean checkFormat(String date) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		try {
			format.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
    
    private String startDate;
	private String endDate;
	private JLabel label3;
}
