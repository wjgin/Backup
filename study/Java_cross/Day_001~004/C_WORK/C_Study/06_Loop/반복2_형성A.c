#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int n1, n2;
	(void)scanf("%d %d", &n1, &n2);
	if (n1 > n2) {
		for (int j = 1; j <= 9; j++) {
			for (int i = n1; i >= n2; i--) {
				printf("%d * %d =%3d   ", i, j, i * j);	// �ڸ����� %3d�� ���

			}
			printf("\n");
		}
	}
	else {
		for (int j = 1; j <= 9; j++) {
			for (int i = n1; i <= n2; i++) {
				printf("%d * %d =%3d   ", i, j, i * j);
				
			}
			printf("\n");
		}
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}