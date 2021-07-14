#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int n;
	scanf("%d", &n);
	printf("%d\n", n);

	if(n < 0) printf("minus");


	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}