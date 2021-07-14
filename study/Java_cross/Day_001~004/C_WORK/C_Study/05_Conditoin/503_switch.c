#include <stdio.h>

/*
* switch(정수)
* {
* case n1:
*	...
*	break;
* case n2:
*	...
*	break;
*
* ...
* default:
*	...
*	break;
*}
*/

int main()
{
	int n = 4;

	switch (n)	// switch(정수)
	{
	case 1:	// 위 정수 값이 1인 경우 아래 코드 수행
		printf("n 값은 1 입니다. \n");
		break;	// switch 문 종료
				// break 만나기 전 까지 모두 실행
	
	case 2:		// case 문 복수 가능
		printf("n 값은 2 입니다. \n");
		break;

	case 3:
		printf("n 값은 3 입니다. \n");
		break;

	default:	// 모든 case에 해당하지 않는 경우
		printf("해당 값이 없습니다.\n");
	}

	// TODO :  n값이 짝수이면 "짝수입니다" 출력
	// 홀수이면 "홀수입니다 " 출력
	// switch ~ case 문 사용
	n = 34;
	int num = n % 2;
	switch (num)
	{
	case 0:		// 짝수의 경우
		printf("짝수 입니다. \n");
		break;	

	case 1:		// 홀수의 경우
		printf("홀수 입니다. \n");
		break;

	default:	
		printf("해당 값이 없습니다.\n");
	}


	// 4점대 -> A
	// 3점대 -> B
	// 2점대 -> C
	// 1점대 -> D
	// 그 이하 -> F

	// 해당 케이스를 바로 찾아가기 때문에 상황에 따라 if 문 보다 효율적일 수도 있다.
	double point = 0.7;

	switch ((int)point)	// 형 변환을 통한 실수 -> 정수 (소수점 이하 제거)
	{
	case 4:		// 4점 대
		printf("A 입니다. \n");
		break;

	case 3:		// 3점 대
		printf("B 입니다. \n");
		break;

	case 2:		// 2점 대
		printf("C 입니다. \n");
		break;

	case 1:		// 1점 대
		printf("D 입니다. \n");
		break;

	default:
		printf("F\n");
	}





	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}