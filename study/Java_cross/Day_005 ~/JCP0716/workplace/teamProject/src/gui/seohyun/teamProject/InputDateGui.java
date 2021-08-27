package gui.seohyun.teamProject;


import java.awt.GridLayout;

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
    	JLabel label2 = new JLabel("종료 날짜");
    	JTextField textField1 = new JTextField();
    	JTextField textField2 = new JTextField();
    	JButton button1 = new JButton("검색");
    	JButton button2 = new JButton("취소");
    	
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
    }
    

               
}
