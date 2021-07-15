#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int n, odd = 0, even = 0;

	while (1) {
		(void)scanf("%d", &n);
		if (n == 0) break;
		if (n % 2 == 0) even++;
		else odd++;
	}

	printf("odd : %d\n", odd);
	printf("even : %d\n", even);

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}