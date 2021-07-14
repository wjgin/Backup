#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int month;
	scanf("%d", &month);

	switch (month)
	{
	case 4:
	case 6:
	case 9:
	case 11:
		printf("%d", 30);
		break;
	case 2:
		printf("%d", 28);
		break;
	default :
		printf("%d", 31);
		break;
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}