#include <stdio.h>
#pragma warning(disable:4996)

/*
85 67 95 65
80 95 86 56
100 98 67 86
95 76 84 65
67 86 90 76
*/
#define NUM_STU 5
#define NUM_SUBJ 4

int main()
{
	int point[NUM_STU][NUM_SUBJ];	// 5�� x 4���� ����

	for (int i = 0; i < NUM_STU; i++) {
		for (int j = 0; j < NUM_SUBJ; j++) {
			(void)scanf("%d", &point[i][j]);
		}
	}

	int success = 0;	// �հ��� �л�

	// �л��� ���
	for (int i = 0; i < NUM_STU; i++) {
		int sum = 0;	// �л��� ����
		double avg = 0.0;	// �л��� ���
			// �� �л��� 4���� ������ �ջ�
			for (int j = 0; j < NUM_SUBJ; j++) {
				sum += point[i][j];
			}
			avg = (double)sum / NUM_SUBJ;	// ��� ���

			// �հ� ����
			if (avg >= 80) {
				printf("pass\n");
				success++;
			}
			else {
				printf("fail\n");
			}
	}
	printf("Successful : %d\n", success);

	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}