#include <stdio.h>

// ������ 2�� ���
// 2 x 1 = 2
// 2 x 2 = 4
// ..
// 2 x 9 = 18
// TODO

int main()
{
	// ������ 2�� ���
	// 2 x 1 = 2
	// 2 x 2 = 4
	// ..
	// 2 x 9 = 18

	for (int i = 1; i < 10; i++) {
		printf("%d x %d = %d\n", 2, i, 2 * i);
	}

	// 1 ~ 10 �� Ȧ���� ������ �ٲپ� ����ϱ�
	// -1 2 -3 4 -5 6 -7 8 -9 10
	printf("-- ��ȯ�� + ���ǹ� --\n");
	for (int i = 1; i <= 10; i++) {
		if (i % 2 == 1) printf("%d ", -i);
		else printf("%d ", i);
	}
	
	// ������ 2�ܿ��� ¦���� ����ϱ�
	for (int i = 1; i <= 9; i++) {
		if (i % 2 == 0) printf("2 X %d = %d\n", i, i * 2);
	}
	// ��� 2
	for (int i = 2; i <= 9; i += 2) {
		printf("2 X %d = %d\n", i, i * 2);
	}

	// 1 ~ n ���� ���� �ջ�
	int n = 100;
	int sum = 0;
	for (int i = 1; i <= n; i++) {
		sum += i;
	}
	printf("%d\n", sum);


	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}