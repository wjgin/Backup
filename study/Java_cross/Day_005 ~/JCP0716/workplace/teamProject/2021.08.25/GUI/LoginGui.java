package gui;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginGui extends JFrame {
	LoginGui(){
  	  setTitle("가계부 프로그램");
  	  setSize(300,300);
  	  JButton button=new JButton("로그인");
   	 JButton button2=new JButton("회원가입");
   	 Label IdLabel = new Label("ID:");
   	 JTextField tf=new JTextField("ID를 입력하세요",20);
   	Label PWLabel = new Label("PW:");
   	 JTextField tf2=new JTextField("PW를 입력하세요",20);
   	 this.setLayout(new FlowLayout());
   	 this.add(IdLabel);
   	 this.add(tf);
   	this.add(PWLabel);
   	 this.add(tf2);
   	 this.add(button);
   	 this.add(button2);
   	
   	  setVisible(true);
   	  //내 프로그램 닫는 기능을 닫기버튼으로 설정
   	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     

	public static void main(String[] args) {
		new LoginGui();

	}

}
