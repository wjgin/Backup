#include <stdio.h>

/* ������ �迭 (n-dimensional array)
*	�迭 ÷��(index)��
*	�ϳ� ����ϸ� --> 1���� �迭
*	�ΰ� ����ϸ� --> 2���� �迭
*	..
*	n ���� �迭�� n - 1 ���� �迭�� �迭
*/




int main()
{
	// 2���� �迭 ����
	int arr1[4][3];		// 4 x 3, 4�� 3��

	// ���������� �ʱ�ȭ(���ʴ��_
	arr1[0][0] = 1;
	arr1[0][1] = 2;
	arr1[0][2] = 3;
	arr1[1][0] = 4;

	int arr2[4][3] = {	// ����� ���ÿ� �ʱ�ȭ
		{1, 2, 3},
		{4, 5, 6},
		{7, 8, 9},
		{10, 11, 12}
	};

	int arr3[4][3] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };	// ������� ���� ��
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

	int arr4[4][3] = { 0 }; // ��ü�� 0���� �ʱ�ȭ
	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 3; j++) {
			printf("%3d", arr4[i][j]);
		}
		printf("\n");
	}
						
	
	printf("%d\n", arr2[2][2]);

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}