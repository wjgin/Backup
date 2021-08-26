package gui;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class registGui extends JFrame{
	  registGui(){
   	  setTitle("가계부 프로그램");
   	  setSize(300,300);
   	  
   	 //컴포넌트 만들기
   	 JButton button=new JButton("수정");
   	 JButton button2=new JButton("등록");
   	 JButton button3=new JButton("삭제");
//   	 JCheckBox box = new JCheckBox("checkBox");
//   	 JSlider slide = new JSlider();
	 Label eLabel = new Label("가계부 등록");
   	 JTextField tf=new JTextField("날짜",20);
   	 JTextField tf2=new JTextField("금액",20);
   	 JTextField tf3=new JTextField("카테고리",20);
   	 JTextField tf4=new JTextField("지출|수입",20);
   	 JTextField tf5=new JTextField("메모",20);
   	 JTextField tf6=new JTextField("ID",20);
   	 JTextField tf7=new JTextField("계좌번호",20);
   	 this.setLayout(new FlowLayout());
   	 this.add(eLabel);
   	 this.add(tf);
   	 this.add(tf2);
   	 this.add(tf3);
   	 this.add(tf4);
   	 this.add(tf5);
   	 this.add(tf6);
   	 this.add(tf7);
   	 this.add(button);
   	 this.add(button2);
   	 this.add(button3);
   	 
   
   	
   	
   	  setVisible(true);
   	  //내 프로그램 닫는 기능을 닫기버튼으로 설정
   	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      
 
	public static void main(String[] args) {
		new registGui();

	}

}
