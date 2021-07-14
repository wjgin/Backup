#include <stdio.h>


/*
*	제어문 (Control) : 프로그램의 흐름을 제어(변경)
*	1. 조건문(Conditional)
*	: if ~ else, switch ~ case
*
*	2. 순환문(loop)
*	: for, while, do ~ while
*/

int main()
{
	int n = 21;

	//if(조건식) <-- 조건식이 '참'이면
	//      그 다음의 '한 문장' 혹은 '한 블럭' 을 실행시킨다
	//      '거짓'이면 실행하지 않고 넘어간다

	// n 이 짝수이면 "짝수입니다" 라고 출력

	if (n % 2 == 0) {
		printf("작수 입니다.\n");
	}

	// n  이 3의 배수이면 "3의 배수 입니다." 출력
	if (n % 3 == 0)
	{
		// 위 조건식이 '참'일 때 수행
		printf("%d 는\n", n);
		printf("3의 배수 입니다.\n");
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}