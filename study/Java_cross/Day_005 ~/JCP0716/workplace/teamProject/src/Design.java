
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


// 계좌등록 클래스
@SuppressWarnings("serial")
public class Design extends javax.swing.JFrame {

    public Design(String id) {
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
    	frame.getContentPane().setLayout(null);
    	
    	frame.getContentPane().add(label1);
    	frame.getContentPane().add(textField1);
    	frame.getContentPane().add(label2);
    	frame.getContentPane().add(textField2);
    	frame.getContentPane().add(button1);
    	frame.getContentPane().add(button2);
    	
    	frame.setSize(300, 150);
    	frame.setVisible(true);
    	
    	String startDateHint = "시작 날짜를 입력하세요 : yyyy-mm-dd";
    	textField1.setText(startDateHint);
    	
    	
    	textField1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField1.getText().equals(startDateHint)) {
					textField1.setText("");
				}
			}
		});
    	
    	String endDateHint = "종료 날짜를 입력하세요 : yyyy-mm-dd";
    	textField1.setText(endDateHint);
    	textField1.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			if(textField1.getText().equals(endDateHint)) {
    				textField1.setText("");
    			}
    		}
    	});
    	
    }
}
