#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	// 10 15 36 99 100 19 46 88 87 13 (10개의 정수)입력 받기
	int n;
	int mul3 = 0, mul5 = 0;	// 3의 배수와 5의 배수의 개수를 담을 변수
	for (int i = 0; i < 10; i++) {
		(void)scanf("%d", &n);
		if (n % 3 == 0) mul3++;
		if (n % 5 == 0) mul5++;	// 3, 5 모두의 배수일 수도 있으니 else if 사용  x
	}
	printf("Multiples of 3 : %d\n", mul3);
	printf("Multiples of 5 : %d\n", mul5);

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}