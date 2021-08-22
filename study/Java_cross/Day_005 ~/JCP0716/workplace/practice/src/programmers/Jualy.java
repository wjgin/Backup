package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class Jualy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		ArrayList<String> list = new ArrayList<String>();
		int[] answer = {};
		int start = 0;
		int end = 0;
		
		for(int i = 0; i < gems.length; i ++) {
			if(!list.contains(gems[i])) {
				list.add(gems[i]);
				start =  start < i ? i : start;
			} else {
				start =  start < i ? i : start;
			}
		}
        
        System.out.println(Arrays.toString(answer));
	}

}
