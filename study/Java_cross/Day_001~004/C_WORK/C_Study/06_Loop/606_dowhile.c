#include <stdio.h>

/*
	do ~ while
	일단 '한번'은 수행하고 조건식 검사
*/

int main()
{
	int i = 1;
	 while(i < 0) {
		 printf("whle문 수행 중\n");	// 조건식 false 수행 x
	}

	 i = 0;
	 do {
		 printf("do ~ while문 수행 중\n");	// 한번은 수행
	 } while (i < 0);

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}