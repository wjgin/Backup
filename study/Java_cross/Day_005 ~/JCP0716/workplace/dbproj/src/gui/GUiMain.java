package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class GUiMain extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	JTextField tf1,tf2,tf3;
	JButton b1,b2,b3,b4;
	JLabel la1,la2,la3,la4,la5;
	JList<String> jlt;
	//int cnt=0;
	//static int ncnt=0;
	
	String str5; 
	JTableList jt;
	
	public GUiMain() {
		la1 = new JLabel("English ");
		la1.setBounds(50, 50, 100, 20); // 윈도우 안에서으 좌표  x, y 너비, 높이
		
		tf1 = new JTextField();
		tf1.setBounds(150, 50, 150, 20);

		la2 = new JLabel("Korean");
		la2.setBounds(50, 100, 100, 20);
		
		tf2 = new JTextField();
		tf2.setBounds(150, 100, 150, 20);
		
		la3 = new JLabel("검색어");
		la3.setBounds(50, 150, 100, 20);
		
		tf3 = new JTextField();
		tf3.setBounds(150, 150, 150, 20);
		//tf3.setEditable(false);   //텍스트 필드 데이터 편집 불가
		
		b1 = new JButton("단어 추가");
		b1.setBounds(50, 200, 90, 40);

		b2 = new JButton("파일 저장");
		b2.setBounds(150, 200, 90, 40);
		
		b3 = new JButton("단어 검색");
		b3.setBounds(250, 200, 90,40);
		
		b4 = new JButton("종료");
		b4.setBounds(350, 200, 90, 40);
		
		b1.addActionListener(this); //actionPerformed 버튼 클릭시 실행
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		la5 = new JLabel();    //���,�˸� ���
		la5.setBounds(50, 250, 400, 20);
		
		la4 = new JLabel("레벨");
		la4.setBounds(350, 50, 100, 20);
		//����
		DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("easy");  
        l1.addElement("so so");  
        l1.addElement("difficult");  
        
        jlt = new JList<>(l1);  
        jlt.setBounds(350,70, 75,75);  
        
        add(jlt);  
		add(la1);add(la2);add(la3);add(la4);add(la5);
		add(tf1);add(tf2);add(tf3);
		add(b1);add(b2);add(b3);add(b4);
		
		setLayout(null);
		setSize(500,350);
		setResizable(false);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new GUiMain();	// 메인 메소드 실행 내용 - 자기 자신 클래스 객체를 생성
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1) {
			la5.setText("b1");
			tf1.setText(jlt.getSelectedValue());
		}else if(e.getSource()==b2) {
			la5.setText(tf2.getText());
			JOptionPane.showMessageDialog(this, "필수 입력 내용 입니다.");
		}else if(e.getSource()==b3) {
			JOptionPane.showMessageDialog(this, "필수 입력 내용 입니다.");
			la5.setForeground(Color.PINK);
		}else if(e.getSource()==b4) {
			dispose();
			System.exit(0);
		}
		
	}
	// 문자열 포맷 설정하기
	//String temp = String.format("%-20s %-20s %3s \t%-15s","English","Korean","lev","date");

}
