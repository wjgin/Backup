package exam;

public class AddQuiz {
	
		int data1;
		int data2;
		int userAns;
		
		
		boolean makeResult() {
			if(data1+data2==userAns) return true;
			else return false;
		}
		
		String resultPrint() {
			if(makeResult()) return "O";
			else return "X";
		}

}
