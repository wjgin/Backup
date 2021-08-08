package testPackage2;

import testPackage1.SuperClass;

public class SubClassTest {

	public static void main(String[] args) {
		SubClass test = new SubClass();
		
		System.out.println(test.getMAX_NUM());	// output : 90
		System.out.println(SuperClass.MAX_NUM);
	}

}
