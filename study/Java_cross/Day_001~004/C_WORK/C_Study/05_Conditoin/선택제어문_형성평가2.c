#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int num;
	scanf("%d", &num);
	if (num == 0)
		printf("zero\n");
	else if (num > 0)
		printf("plus\n");
	else
		printf("minus\n");

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}