package gui.seohyun.teamProject;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginGui extends JFrame {
	LoginGui(){
  	  setTitle("����� ���α׷�");
  	  setSize(300,300);
  	  JButton button=new JButton("�α���");
   	 JButton button2=new JButton("ȸ������");
   	 Label IdLabel = new Label("ID:");
   	 JTextField tf=new JTextField("ID�� �Է��ϼ���",20);
   	Label PWLabel = new Label("PW:");
   	 JTextField tf2=new JTextField("PW�� �Է��ϼ���",20);
   	 this.setLayout(new FlowLayout());
   	 this.add(IdLabel);
   	 this.add(tf);
   	this.add(PWLabel);
   	 this.add(tf2);
   	 this.add(button);
   	 this.add(button2);
   	
   	  setVisible(true);
   	  //�� ���α׷� �ݴ� ����� �ݱ��ư���� ����
   	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
     

	public static void main(String[] args) {
		new LoginGui();

	}

}
