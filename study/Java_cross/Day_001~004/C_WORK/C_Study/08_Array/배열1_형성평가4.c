#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int arr[100];
	int n;
	int breakPoint = 0;;
	for (int i = 0; i < 100; i++) {
		(void)scanf("%d", & n);
		if (n == -1) {
			breakPoint = i;
			break;
		}
		else arr[i] = n;
	}

	if (breakPoint > 3) {
		for (int i = breakPoint - 3; i < breakPoint; i++) {
			printf("%d ", arr[i]);
		}
	} else {
		for (int i = 0; i < breakPoint; i++) {
			printf("%d ", arr[i]);
		}
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}