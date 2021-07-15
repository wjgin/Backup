#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	
	int n;
	(void)scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <= i; j++) {
			printf("*");
		}
		printf("\n");
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}