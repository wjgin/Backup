#include <stdio.h>
#pragma warning(disable: 4996)
#define MAX 5
/*
���� 5���� ��� �迭 ����
����ڷκ��� 5�� �Է¹�����
�ִ񰪰� �ּڰ��� ����ϱ�
*/


int main()
{
	int score[MAX];

	printf("%d ���� ���� �Է��ϼ��� : ", MAX);
	
	for (int i = 0; i < MAX; i++) {
		(void)scanf("%d", &score[i]);
	}
	printf("�Է��� ���� ");

	for (int i = 0; i < MAX; i++) {
		printf("%d ", score[i]);
	}
	printf("\n");

	// �ִ� ���ϱ�
	int max = score[0];
	for (int i = 1; i < MAX; i++) {
		if (max < score[i]) max = score[i];
	}
	printf("�ִ� = %d\n", max);

	// �ּڰ� ���ϱ�
	int min = score[0];
	for (int i = 1; i < MAX; i++) {
		if (min > score[i]) min = score[i];
	}
	printf("�ּڰ� = %d\n", min);


	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}