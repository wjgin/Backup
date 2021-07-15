#include <stdio.h>

// 구구단 2단 출력
// 2 x 1 = 2
// 2 x 2 = 4
// ..
// 2 x 9 = 18
// TODO

int main()
{
	// 구구단 2단 출력
	// 2 x 1 = 2
	// 2 x 2 = 4
	// ..
	// 2 x 9 = 18

	for (int i = 1; i < 10; i++) {
		printf("%d x %d = %d\n", 2, i, 2 * i);
	}

	// 1 ~ 10 중 홀수만 음수로 바꾸어 출력하기
	// -1 2 -3 4 -5 6 -7 8 -9 10
	printf("-- 순환문 + 조건문 --\n");
	for (int i = 1; i <= 10; i++) {
		if (i % 2 == 1) printf("%d ", -i);
		else printf("%d ", i);
	}
	
	// 구구단 2단에서 짝수만 출력하기
	for (int i = 1; i <= 9; i++) {
		if (i % 2 == 0) printf("2 X %d = %d\n", i, i * 2);
	}
	// 방법 2
	for (int i = 2; i <= 9; i += 2) {
		printf("2 X %d = %d\n", i, i * 2);
	}

	// 1 ~ n 까지 수를 합산
	int n = 100;
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += i;
	}
	printf("%d\n", sum);


	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}