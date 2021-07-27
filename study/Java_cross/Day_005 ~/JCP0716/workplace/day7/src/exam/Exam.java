package exam;

public class Exam {
	int num1; 
	int num2;
	int solution;
	
	public Exam() {}
	
	public Exam(double num1, double num2) {
		this.num1 = (int)Math.floor(num1);
		this.num2 = (int)Math.floor(num2);
	}
	
	int sum() {
		return num1 + num2;
	}
	
	void checResult(char result) {
		System.out.printf("%2d + %2d     %3d     %3d     %c \n", num1, num2, solution, sum(), result);
	}
}
