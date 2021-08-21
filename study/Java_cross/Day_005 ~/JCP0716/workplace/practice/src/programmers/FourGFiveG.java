package programmers;

public class FourGFiveG {

	public static void main(String[] args) {
		int n = 16;
		int[] stations = { 9 };
		int w = 2;
		int start = 0 - w - 1;
		int end = 0;
		int temp = 0;
		int range = 2 * w + 1;

		int answer = 0;

		for (int x : stations) {
			end = x - 1;
			if (n - start - 1 > w) {
				temp = (end - start - 1 - 2*w);
				while (temp > 0) {
					temp = temp - range;
					answer++;
				}
				start = end;
			}
		}
		// 마지막 인자 계산
		if (n - start - 1 > w) {
			end = n + w;
			temp = (end - start - 1 - 2*w);
			while (temp > 0) {
				temp = temp - range;
				answer++;
			}
			start = end;
		}
		
	} // main end
}

/*
 * // 1 미리설치되어있던 곳 표기 // 2 0인덱스부터 뒤로가며 w만큼비어있다면 설치 후 카운트 for (int x : stations)
 * { for (int i = 0; i <= w; i++) { if (x - 1 - i >= 0) check[x - 1 - i] = 1; if
 * (x - 1 + i <= n - 1) check[x - 1 + i] = 1; } }
 * System.out.println(Arrays.toString(check));
 * 
 * for (int i = 0; i < n; i++) { if (check[i] == 0) { cnt++; for (int j = 0; j <
 * 2*w + 1; j++) { if (i + j < n) check[i + j] = 1; } } }
 * System.out.println(cnt);
 */