#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int a, b, c;
	printf("정수 3개 입력하세요 :");
	(void)scanf("%d %d %d", &a, &b, &c);
	printf("입력 결과 a = %d, b = %d, c = %d\n", a, b, c);
	// ↑ 한 줄에 여러개 입력 가능, 여러줄에 걸쳐 입력도 가능

	printf("또 정수 3개 입력하기 : ");
	(void)scanf("%d", &a);
	(void)scanf("%d", &b);
	(void)scanf("%d", &c);
	
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}