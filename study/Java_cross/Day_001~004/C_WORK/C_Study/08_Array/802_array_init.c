#include <stdio.h>

/*
	�迭�� �ʱ�ȭ
*/

int main()
{
	// TODO
	int arr1[4];

	// �迭 ���� �ʱ�ȭ ���� ����ϸ� �����Ⱚ(garbage value) ����.
	for (int i = 0; i < 4; i++) {
		printf("arr1[%d] = %d\n", i, arr1[i]);
	}


	// �迭���� �ʱ�ȭ 
	// ���1 : ���� �ʱ�ȭ
	arr1[0] = 100;
	arr1[1] = 200;
	arr1[2] = 300;
	arr1[3] = 400;
	for (int i = 0; i < 4; i++) {
		printf("arr1[%d] = %d\n", i, arr1[i]);
	}

	printf("\n");
	

	// ��� 2: �迭����� ���ÿ� �ʱ�ȭ
	short arr2[3] = { 10, 20, 30 };
	for (int i = 0; i < 4; i++) {
		printf("arr2[%d] = %d\n", i, arr2[i]);
	}

	// ���3 : �ʱ�ȭ ���� ������ �迭�� ���̺��� �۴ٸ�?? (�迭�� ���� => �迭�����ǰ���)
	// �������� 0���� �ʱ�ȭ ��.
	double arr3[3] = { 3.14 };
	for (int i = 0; i < 3; i++) {
		printf("arr3[%d] = %f\n", i, arr3[i]);
	}

	printf("\n");

	// ���4 : �迭�� ���� ��� ���� �ʱ갪������ �����Ͽ� �ʱ�ȭ
	// char arr4[];	// �迭����� �迭�� ���̸� ��þ��ϸ� ����
	char arr4[] = {'a', 'b', 'c'};	// arr4�� ���� 3¥�� �迭�� �����
	int i = 0;
	while (i < 3) {
		printf("arr4[%d] = %c\n", i, arr4[i]);
		i++;
	}
	// �迭�� �뷮(size)
	// arr1 -> 16 byte
	// arr2 -> 6 byte
	// arr3 -> 24 byte
	// arr4 -> 3 byte



	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}