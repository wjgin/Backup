#include <stdio.h>

/*
	���� ������
	(���ǽ�) ? ���� ��� : ������ ���
*/

int main()
{
	int result;
	result = 10 > 3 ? 200 : -100;
	printf("result = %d\n", result);	// output: result = 200

	result = 10 < 3 ? 200 : -100;
	printf("result = %d\n", result);	// output: result = -100c

	int a = 60;
	int b = 43;
	// a �� b�� ���̰� (difference)��?
	int diff = a > b ? a - b : b - a;
	printf("diff = %d\n", diff);	// ��� �� ���

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}