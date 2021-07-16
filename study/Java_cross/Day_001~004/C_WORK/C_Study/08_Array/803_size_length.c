#include <stdio.h>

/*
*	�迭�� ũ�� (size) : �迭�� �뷮ũ�� (byte)
*	�迭�� ���� (length) : �迭������ ����
*/

int main()
{
	// sizeof() ������
	// �������� ũ�⸦ byte (����) �� ����
	printf("%d\n", sizeof(100));	// ���� ���ͷ� / ������ �뷮(4byte)
	short s = 100;
	printf("%d\n", sizeof(s));	// short  Ÿ���� size 2byte
	printf("%d\n", sizeof(double));	// Ÿ�Ը��� ����� Ȯ�� ����

	int arr[3];
	printf("sizeof(�迭) : %d\n", sizeof(arr));		// �迭 �̸����� �迭ũ�� ��� ����
	printf("arr[0]�� size : %d\n", sizeof(arr[0]));		// �迭 ������ ũ��

	// �迭�� ���� ���ϴ� ����
	// sizeof(�迭�̸�) / sizeof(�迭����Ÿ��)
	// sizeof(�迭�̸�) / sizeof(�迭�� ù��° ����)
	printf("arr�� length = %d\n", sizeof(arr) / sizeof(arr[0]));

	// c���� length�� 0�� �迭 ���� �Ұ���

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}