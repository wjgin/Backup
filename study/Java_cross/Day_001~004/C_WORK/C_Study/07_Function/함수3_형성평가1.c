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
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}

void solution(int n) {
	if (n < 1) return; //��������
	solution(n / 2);
	printf("%d ", n);
}