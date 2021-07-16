#include <stdio.h>
#pragma warning(disable:4996)
/*
15 2 35
33 1 6
5 10 19
1 8 55
*/
#define STU 3
#define CLASS 4


int main()
{	
	int score[STU][CLASS];
	int classScore[CLASS];
	for (int i = 0; i < CLASS; i++) {
		for (int j = 0; j < STU; j++) {
			(void)scanf("%d", &score[i][j]);
		}
	}

	for (int i = 0; i < CLASS; i++) {
		int sum = 0;
		for (int j = 0; j < STU; j++) {
			sum += score[i][j];
		}
		classScore[i] = sum;
	}

	for (int i = 0; i < CLASS; i++) {
		printf("%dclass : %d\n", i+1, classScore[i]);
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}