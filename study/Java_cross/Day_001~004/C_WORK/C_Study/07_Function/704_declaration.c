#include <stdio.h>
#include "myfuntion.h"	// 헤더 파일 가져오기
/*

*/

int main()
{
	printf("MAX = %d\n", MAX);	// 헤더 파일에서 정의된 변수 사용

	Data i = 3, j = 4;

	printf("power() 결과 : %d\n", power(i, j));
	printf("doubleUp() 결과 : %.1f\n", doubleUp(j));

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}