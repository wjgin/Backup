#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	// 10 15 36 99 100 19 46 88 87 13 (10���� ����)�Է� �ޱ�
	int n;
	int mul3 = 0, mul5 = 0;	// 3�� ����� 5�� ����� ������ ���� ����
	for (int i = 0; i < 10; i++) {
		(void)scanf("%d", &n);
		if (n % 3 == 0) mul3++;
		if (n % 5 == 0) mul5++;	// 3, 5 ����� ����� ���� ������ else if ���  x
	}
	printf("Multiples of 3 : %d\n", mul3);
	printf("Multiples of 5 : %d\n", mul5);

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}