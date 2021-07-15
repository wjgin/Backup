#include <stdio.h>
#pragma warning(disable:4996)
/*

*/
void drawSquare(int); // 선언
int main()
{
	// TODO
	int n;
	(void)scanf("%d", &n);
	drawSquare(n);	// 함수 호출
	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}

void drawSquare(int n) {	//함수 정의
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", i + j * i);
		}
		printf("\n");
	}
}