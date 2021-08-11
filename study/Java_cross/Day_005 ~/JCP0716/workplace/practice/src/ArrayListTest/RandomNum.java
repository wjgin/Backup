package ArrayListTest;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

	public static void main(String[] args) {
		List<Integer> randomArr = new ArrayList<Integer>();

		for (int i = 0; i < 45; i++) {
			randomArr.add(i + 1);
		}

		while (true) {
			int randomNum = (int) Math.round((Math.random() * 44 + 0.5));
			System.out.println(randomNum);
			if(randomArr.contains(randomNum))
				randomArr.remove(randomNum);
			
			if (randomArr.size() == 10)
				break;
		}
		System.out.println(randomArr.toString());
		
		/*
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				int randomIndex = (int) Math.round((Math.random() * 9));
				System.out.print(randomArr.get(randomIndex) + "  ");
				System.out.println();
			}
		}
		*/
	}

}
