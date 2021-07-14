#include <stdio.h>

/*
	삼항 연산자
	(조건식) ? 참의 경우 : 거짓의 경우
*/

int main()
{
	int result;
	result = 10 > 3 ? 200 : -100;
	printf("result = %d\n", result);	// output: result = 200

	result = 10 < 3 ? 200 : -100;
	printf("result = %d\n", result);	// output: result = -100c

	int a = 60;
	int b = 43;
	// a 와 b의 차이값 (difference)는?
	int diff = a > b ? a - b : b - a;
	printf("diff = %d\n", diff);	// 양수 값 출력

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}