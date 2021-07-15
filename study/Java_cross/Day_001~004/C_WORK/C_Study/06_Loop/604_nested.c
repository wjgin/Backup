#include <stdio.h>

/*
	��ø ��ȯ��(nested - loop)
*/

int main()
{
	// ������ 2�� ~ 9��
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

	// while ������ �����
	int dan = 2, mul;
	while (dan < 10) {
		printf("%d��\n", dan);
		mul = 1;
		while (mul < 10) {
		printf("%d x %d = %d\n", dan, mul, dan * mul);
		mul++;
		}
		printf("\n");
		dan++;
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}