#include <stdio.h>
#pragma warning(disable:4996)
/*

*/
void drawSquare(int); // ����
int main()
{
	// TODO
	int n;
	(void)scanf("%d", &n);
	drawSquare(n);	// �Լ� ȣ��
	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}

void drawSquare(int n) {	//�Լ� ����
	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < n; j++) {
			printf("%d ", i + j * i);
		}
		printf("\n");
	}
}