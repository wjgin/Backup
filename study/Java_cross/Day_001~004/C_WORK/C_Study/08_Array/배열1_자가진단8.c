#include <stdio.h>
#pragma warning(disable:4996)
#define LEN 10
/*

*/

int main()
{
	int sum = 0, oddCnt = 0;
	float avg = 0.0;
	int arr[LEN];

	for (int i = 0; i < LEN; i++) {
		(void)scanf("%d", &arr[i]);
	}

	for (int i = 0; i < LEN; i++) {
		if ((i+1) % 2 == 0)	sum += arr[i];
		else {
			avg += arr[i];
			oddCnt++;
		}
	}
	avg /= oddCnt;
	printf("sum : %d\n", sum);
	printf("avg : %.1f\n", avg);


	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}