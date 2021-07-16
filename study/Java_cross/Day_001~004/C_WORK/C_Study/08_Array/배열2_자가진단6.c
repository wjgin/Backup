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
	int point[NUM_STU][NUM_SUBJ];	// 5명 x 4과목 점수

	for (int i = 0; i < NUM_STU; i++) {
		for (int j = 0; j < NUM_SUBJ; j++) {
			(void)scanf("%d", &point[i][j]);
		}
	}

	int success = 0;	// 합격한 학생

	// 학생별 평균
	for (int i = 0; i < NUM_STU; i++) {
		int sum = 0;	// 학생의 총점
		double avg = 0.0;	// 학생의 평균
			// 위 학생의 4과목 점수를 합산
			for (int j = 0; j < NUM_SUBJ; j++) {
				sum += point[i][j];
			}
			avg = (double)sum / NUM_SUBJ;	// 평균 계산

			// 합격 여부
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
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}