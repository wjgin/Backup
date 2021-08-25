package gui.seohyun.teamProject;

import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class JoinGui extends JFrame {
	JoinGui(){
    	  setTitle("����� ���α׷�");
    	  setSize(300,300);
    	  
    	 //������Ʈ �����
    	 JButton button=new JButton("���");
    	 Label IdLabel = new Label("ID:");
    	 JTextField tf=new JTextField("������ ID�� �Է��ϼ���",20);
    		Label PWLabel = new Label("PW:");
    	 JTextField tf2=new JTextField("������ PW�� �Է��ϼ���",20);
    		Label telLabel = new Label("tel:");
    	 JTextField tf3=new JTextField("�ڵ��� ��ȣ�� �Է��ϼ���",20);
    	 this.setLayout(new FlowLayout());
    	 this.add(IdLabel);
    	 this.add(tf);
    	 this.add(PWLabel);
    	 this.add(tf2);
    	 this.add(telLabel);
    	 this.add(tf3);
    	 this.add(button);
    	
    	  setVisible(true);
    	  //�� ���α׷� �ݴ� ����� �ݱ��ư���� ����
    	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       }
	public static void main(String[] args) {
		new JoinGui();

	}

}
