#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int YEAR;
	scanf("%d", &YEAR);

	if (YEAR % 400 == 0 || YEAR % 4 == 0 && YEAR % 100 != 0) printf("leap year");
	else printf("common year");

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}