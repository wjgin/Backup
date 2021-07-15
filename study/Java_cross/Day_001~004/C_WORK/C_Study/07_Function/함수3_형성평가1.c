#include <stdio.h>
#pragma warning(disable:4996)
/*

*/
void solution(int);
int main()
{
	int N;
	(void)scanf("%d", &N);
	solution(N);
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}

void solution(int n) {
	if (n < 1) return; //종료조건
	solution(n / 2);
	printf("%d ", n);
}