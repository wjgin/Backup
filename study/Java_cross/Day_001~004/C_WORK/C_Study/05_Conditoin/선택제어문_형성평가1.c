#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int num1, num2;
	scanf("%d %d", &num1, &num2);

	int diff = num1 <= num2 ? num2 - num1 : num1 - num2;
	printf("%d", diff);

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}