package tossTest20210814;

import java.util.regex.Pattern;

public class TossTest2 {
	public static void main(String[] args) {
		System.out.println(solution("13,030,000"));
	}

	public static boolean solution(String amountText) {
		boolean answer = true;
		String pattern = "^[0-9,]*$";
		String pattern2 = "([0-9]*,(\\d{3}))*$";
		
		if(amountText.length()==0) return false;
		if (amountText.length() == 1) {
			if (Pattern.matches("^[0-9]$", amountText))
				return true;
		}
		if (amountText.length() > 1) {
			if (!Pattern.matches("^[0-9,]*$", amountText) ||
				Pattern.matches("^[0-9]*$", amountText))
				return false;
			if (amountText.charAt(0) == '0' || amountText.charAt(0) == ',')
				return false;
		}
		if (amountText.length() >= 4) {
			// , 포함시
			if (Pattern.matches(pattern, amountText)) {
				while (amountText.length() > 3) {
					if (!Pattern.matches(pattern2, amountText))
						return false;
					amountText = amountText.substring(0, amountText.length() - 4);
				}
			}
		}
		return answer;

	}

}
/*
 * 옳은 금액은 0~9 사이의 숫자 또는 구분자(,)로만 구성되어야 한다. 예를 들면 1만원이나 10,000원, +300은 0~9 사이의 숫자
 * 또는 구분자(,)가 아닌 문자가 포함되어 있으므로 옳지 않은 금액이다. 금액이 0원인 경우를 제외하고는 가장 왼쪽 숫자가 0일 수 없다.
 * 예를 들면, 0은 옳은 금액이지만, 0100은 옳지 않다. 금액은 세자리 구분자(,)를 포함하고 있거나, 또는 전혀 포함하고 있지 않다.
 * 예를 들면, 구분자를 전혀 포함하지 않은 금액 39900도 옳은 금액이다. 세자리 구분자는 가장 오른쪽 숫자로부터 시작해 왼쪽 방향으로 매
 * 3개의 숫자마다 1개의 구분자(,)가 등장하는 형태이다. 예를 들면, 25,000,123은 옳은 금액이고, 24,999,99는 옳지 않은
 * 금액이다. 가장 왼쪽 끝이나 오른쪽 끝에는 구분자를 두지 않는다. 예를 들면, 10,000,과 ,999,000은 모두 옳지 않다. 영수증에
 * 적혀있는 금액을 보고 가짜 영수증인지 진짜 영수증인지 판단하는 시스템을 만들어주세요.
 */
/**
 * // stringbuilder ex StringBuilder sb = new StringBuilder("바로문자 가능");
 * sb.append("추가할 문자열"); sb.delete(0, 3); // 삭제(시작, 끝) sb.deleteCharAt(0); //
 * 인덱스 문자만 삭제 sb.insert(1, "인덱스에 삽입 가능"); sb.replace(0, 2, "변경");
 * 
 * System.out.println(sb);
 * 
 * ArrayList<Integer> list = new ArrayList<Integer>(); list.add(1);
 * list.add(100); list.sort(Comparator.naturalOrder()); // 오름 차순
 * System.out.println("오름차순 : " + list.toString());
 * list.sort(Comparator.reverseOrder()); // 내림 차순 System.out.println("내림차순 : " +
 * list.toString());
 * 
 * System.out.println(list.toString()); System.out.println(list.get(0));
 * System.out.println(list.indexOf(100));
 * 
 * /
 */