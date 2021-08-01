package ArrayListTest;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		
		int maxLen = 30;

		ArrayList<String> stringList = new ArrayList<>();
		
		System.out.println(stringList);	// []
		
		stringList.add("일번");
		stringList.add("이번 입니다.");
		stringList.add("삼번");
		
		System.out.println(stringList.get(1).substring(1, 5));
		
		
		
		
	}

}
