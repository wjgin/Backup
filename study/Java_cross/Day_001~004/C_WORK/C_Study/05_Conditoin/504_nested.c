#include <stdio.h>
#pragma warning(disable:4996)
/*
	중첩 조건문(nested - if, nested - swtch)
*/

int main()
{
	// 정수 하나 입력 받아서
	// 짝수이면 "짝수입니다" 를 출력하고
	//      짝수이면서 3의 배수이면 "3의 배수입니다" 라고 출력하세요
	//      짝수이면서 3의 배수가 아니면 "짝수이지만 3의 배수는 아닙니다" 라고 출력하세요
	// 홀수이면 "홀수입니다" 를 출력해보세요

	int n;
	printf("정수하나 입력하세요: ");
	(void)scanf("%d", &n);

	if (n % 2 == 0) {
		printf("짝수 입니다.\n");
		n % 3 == 0 ? printf("3의 배수입니다.\n") : printf("짝수이지만 3의 배수는 아닙니다.\n");
	}
	else {
		printf("홀수 입니다.\n");
	}

	// swich 문 중첩
	printf("----------");
	switch (n % 2)
	{
	case 0 :
		printf("짝수 입니다.\n");

		switch (n % 3)
		{
		case 0:
			printf("3의 배수 입니다.\n");
			break;
		default:
			printf("짝수 이지만 3의 배수는 아닙니다.\n");
		}
		break;
	case 1:
		printf("홀수 입니다.\n");
		break;
	}

	(void)getchar();
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}