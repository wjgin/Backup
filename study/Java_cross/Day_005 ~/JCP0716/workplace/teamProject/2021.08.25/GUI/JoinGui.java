package gui;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class JoinGui extends JFrame {
	JoinGui(){
    	  setTitle("가계부 프로그램");
    	  setSize(300,300);
    	  
    	 //컴포넌트 만들기
    	 JButton button=new JButton("등록");
    	 Label IdLabel = new Label("ID:");
    	 JTextField tf=new JTextField("가입할 ID를 입력하세요",20);
    		Label PWLabel = new Label("PW:");
    	 JTextField tf2=new JTextField("가입할 PW를 입력하세요",20);
    		Label telLabel = new Label("tel:");
    	 JTextField tf3=new JTextField("핸드폰 번호를 입력하세요",20);
    	 this.setLayout(new FlowLayout());
    	 this.add(IdLabel);
    	 this.add(tf);
    	 this.add(PWLabel);
    	 this.add(tf2);
    	 this.add(telLabel);
    	 this.add(tf3);
    	 this.add(button);
    	
    	  setVisible(true);
    	  //내 프로그램 닫는 기능을 닫기버튼으로 설정
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
	public static void main(String[] args) {
		new JoinGui();

	}

}
