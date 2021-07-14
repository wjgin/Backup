#include <stdio.h>
#pragma warning(disable:4996)

/*

*/

int main()
{
	// char를 입력 받을 떄, 주의
	char ch;
	int a;

	printf("문자 하나 입력 :");
	(void)scanf("%c", &ch);
	printf("입력한 문자는 = %c\n", ch);

	printf("정수 하나 입력:");
	(void)scanf("%d", &a);

	printf("또 다시 문자 하나 입력:");
	(void)getchar(); // 버퍼에 남아 있는 줄 바꿈 문자 제거
	(void)scanf("%c", &ch);

	printf("a = %d,ch = %c\n",a, ch);
	(void)getchar();

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;

/*
   입력 버퍼 비우기 참고

	1. while(getchar()!= '\n');

	2. fflush(stdin):  vs에서만 사용

	3. __fpurge(stdin) : 리눅스 환경에서만 사용
*/



}