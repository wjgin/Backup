#include <stdio.h>

/*
	중첩 순환문(nested - loop)
*/

int main()
{
	// 구구단 2단 ~ 9단
	// 2 x 1 = 2
	// ..
	// 2 x 9 = 18

	// 3 x 1 = 3
	// ..
	// 3 x 9 = 27
	// ...
	// 9 x 1 = 9
	// ..
	// 9 x 9 = 81
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			printf("%d x %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}

	// while 문으로 만들기
	int dan = 2, mul;
	while (dan < 10) {
		printf("%d단\n", dan);
		mul = 1;
		while (mul < 10) {
		printf("%d x %d = %d\n", dan, mul, dan * mul);
		mul++;
		}
		printf("\n");
		dan++;
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}