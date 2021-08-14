package tossTest20210814;

public class TossTest1 {
	public static void main(String[] args) {
		System.out.println(solution(100, 0, 11));
	}

	public static long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
		// orderAmount : 주문금액
		// taxFreeAmount : 비과세금액
		// serviceFee : 봉사료
		// 부가가치세 : 과세금액 * 0.1 소숫점 첫째자리에서 올림
		// 과세금액 : 공급가액 - 비과세
		// 공급대가 : 공급가액 + 부가가치세 - 봉사료(0원일 수 있음) = 주문금액
		// 공급대가 - 비과세 == 1이면 과세 x
		// 과세금액 == (주문금액 + 봉사료 - 비과세) * 0.1 소숫점자리 첫번째 올림

		long answer = 0;
		
		if (orderAmount - serviceFee - taxFreeAmount <= 1)
			return 0;
		else
			answer = (long) Math.ceil(((orderAmount - serviceFee - taxFreeAmount) * 0.1));

		return answer; // 부가가치세 리턴
	}

}

/*
 * 개발팀 : 그럼 부가가치세는 어떻게 계산해요? 회계팀 : 부가가치세는요, 과세의 대상이 되는 과세금액에서 10%만큼 산정해주시면 됩니다.
 * 참고로 소수점(이하) 첫째자리에서 올림 처리합니다. 개발팀 : 과세 금액은 어떻게 산정하면 될까요? 회계팀 : 공급가액에서 비과세 금액을
 * 빼주시면 됩니다. 비과세 금액은 말 그대로 부가가치세가 부과되지 않는 금액을 의미해요. 개발팀 : 공급가액과 계산된 부가가치세를 합하면
 * 주문금액과 동일한게 맞나요? 회계팀 : 공급가액에 부가가치세를 더한 금액은 공급대가라고도 표현하는데, 보통 봉사료가 없다면 공급대가는
 * 주문금액과 같아요. 하지만 숙박업 등 봉사료가 존재하는 업종의 경우에는 주문금액에서 봉사료를 제한 금액이 공급대가가 됩니다. 개발팀 :
 * 공급대가에서 비과세금액을 뺀 남은 금액이 1원이면, 부가가치세는 어떻게 되나요? 회계팀 : 그 경우는 예외적으로 부가가치세를 0원으로
 * 처리해 주세요. 개발팀 : 자세한 설명 감사합니다!
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