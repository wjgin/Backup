package gui;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;


public class AccountGui extends JFrame {
	
	AccountGui(){
  	  setTitle("����� ���α׷�");
  	  setSize(300,300);
  	  
  	 //������Ʈ �����
  	 JButton button=new JButton("���");
//  	 JCheckBox box = new JCheckBox("checkBox");
//  	 JSlider slide = new JSlider();
  	Label eLabel = new Label("���µ��");
  	 JTextField tf=new JTextField("���༱��",20);
  	 JTextField tf2=new JTextField("���¹�ȣ",20);
  	 JTextField tf3=new JTextField("������",20);
  	 JTextField tf4=new JTextField("ID",20);
  	 this.setLayout(new FlowLayout());
  	this.add(eLabel);
  	 this.add(tf);
  	 this.add(tf2);
  	 this.add(tf3);
  	 this.add(tf4);
  	 this.add(button);
  	
  	
  	  setVisible(true);
  	  //�� ���α׷� �ݴ� ����� �ݱ��ư���� ����
  	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     

	public static void main(String[] args) {
		new AccountGui();

	}

}
