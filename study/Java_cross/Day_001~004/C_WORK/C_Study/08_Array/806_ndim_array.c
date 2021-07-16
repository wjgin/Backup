#include <stdio.h>

/* 다차원 배열 (n-dimensional array)
*	배열 첨자(index)를
*	하나 사용하면 --> 1차원 배열
*	두개 사용하면 --> 2차원 배열
*	..
*	n 차원 배열은 n - 1 차원 배열의 배열
*/




int main()
{
	// 2차원 배열 선언
	int arr1[4][3];		// 4 x 3, 4행 3열

	// 개별적으로 초기화(차례대로_
	arr1[0][0] = 1;
	arr1[0][1] = 2;
	arr1[0][2] = 3;
	arr1[1][0] = 4;

	int arr2[4][3] = {	// 선언과 동시에 초기화
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
		{10, 11, 12}
	};

	int arr3[4][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };	// 순서대로 저장 됨
					// arr3[0][0], arr3[0][1], arr3[0][2] ...


	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			printf("arr2[%d][%d] = %d\n", i, j, arr2[i][j]);
		}
		printf("\n");
	}

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			printf("%3d", arr2[i][j]);
		}
		printf("\n");
	}
	printf("\n");

	int arr4[4][3] = { 0 }; // 전체를 0으로 초기화
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			printf("%3d", arr4[i][j]);
		}
		printf("\n");
	}
						
	
	printf("%d\n", arr2[2][2]);

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}