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

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}