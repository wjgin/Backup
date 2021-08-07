package testPackage2;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringEqualTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String word = "test    test tsetes tesl tes  tesot";
		
		StringTokenizer stk = new StringTokenizer(word);
		while(stk.hasMoreTokens()) {
			String line = stk.nextToken();
			System.out.println(line + " : " + line.equals(sc.nextLine()));
		}
	}

}
