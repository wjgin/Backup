#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	for (int i = 10; i <= 20; i++) {
		printf("%d ", i);
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}