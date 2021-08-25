package gui.seohyun.teamProject;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class registGui extends JFrame{
	  registGui(){
   	  setTitle("����� ���α׷�");
   	  setSize(300,300);
   	  
   	 //������Ʈ �����
   	 JButton button=new JButton("����");
   	 JButton button2=new JButton("���");
   	 JButton button3=new JButton("����");
//   	 JCheckBox box = new JCheckBox("checkBox");
//   	 JSlider slide = new JSlider();
	 Label eLabel = new Label("����� ���");
   	 JTextField tf=new JTextField("��¥",20);
   	 JTextField tf2=new JTextField("�ݾ�",20);
   	 JTextField tf3=new JTextField("ī�װ�",20);
   	 JTextField tf4=new JTextField("����|����",20);
   	 JTextField tf5=new JTextField("�޸�",20);
   	 JTextField tf6=new JTextField("ID",20);
   	 JTextField tf7=new JTextField("���¹�ȣ",20);
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
   	  //�� ���α׷� �ݴ� ����� �ݱ��ư���� ����
   	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }
      
 
	public static void main(String[] args) {
		new registGui();

	}

}
