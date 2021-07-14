#include <stdio.h>

/*
*	if(조건식)
*		'참'일때 수행
*	else
*		'거짓'일때 수행
*
*
*	if(조건식1)
*		조건식1 이 '참' 일때 수행
*	else if (조건식2)
*		조건식2 가 '참' 일때 수행
*	else if (조건식3)
*		조건식3 가 '참' 일때 수행
*	..
*	else
*		위 조건식들 모두 거짓일때 수행
*/



int main()
{
	int n = 48;

	if (n % 2 == 0)
	{
		// '참' 일 때 수행하는 코드
		printf("짝수 입니다.\n");
	}
	else
	{
		// '거짓'일 때 수행하는 코드
		printf("거짓 입니다.\n");
	}

	//--------------------------------------
	// if .. else if .. else if...

	double point = 2.8;

	if (point >= 4.0) {
		printf("A학점\n");
	}
	else if (point >= 3.0) {
		printf("B학점\n");
	}
	else if (point >= 2.0) {
		printf("C학점\n");
	}
	else if (point >= 1.0) {
		printf("D학점\n");
	}
	else {
		printf("F 입니다.\n");
	}
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}