package gui.seohyun.teamProject;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class Pre_AccountGui extends JFrame {
	
	Pre_AccountGui(){
  	  setTitle("가계부 프로그램");
  	  setSize(300,300);
  	  
  	 //컴포넌트 만들기
  	 JButton button=new JButton("등록");
//  	 JCheckBox box = new JCheckBox("checkBox");
//  	 JSlider slide = new JSlider();
  	Label eLabel = new Label("계좌등록");
  	 JTextField tf=new JTextField("은행선택",20);
  	 JTextField tf2=new JTextField("계좌번호",20);
  	 JTextField tf3=new JTextField("예금주",20);
  	 JTextField tf4=new JTextField("ID",20);
  	 this.setLayout(new FlowLayout());
  	this.add(eLabel);
  	 this.add(tf);
  	 this.add(tf2);
  	 this.add(tf3);
  	 this.add(tf4);
  	 this.add(button);
  	
  	
  	  setVisible(true);
  	  //내 프로그램 닫는 기능을 닫기버튼으로 설정
  	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     

	public static void main(String[] args) {
		new Pre_AccountGui();

	}

}
