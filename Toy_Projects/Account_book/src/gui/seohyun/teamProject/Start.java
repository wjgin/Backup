package gui.seohyun.teamProject;

public class Start {

	public static void main(String[] args) {
		LoginGui login = new LoginGui();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				login.setVisible(true);
			}
		});
	}
}