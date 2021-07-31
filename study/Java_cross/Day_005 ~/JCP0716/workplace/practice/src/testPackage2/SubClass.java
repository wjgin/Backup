package testPackage2;

// testPackage1 패키지에서 TestClass1 클래스 가져오기
import testPackage1.SuperClass;

public class SubClass extends SuperClass{
	
	public final int MAX_NUM = 90;
	
	public int getMAX_NUM() {
		return this.MAX_NUM;
	}
}
