#include <stdio.h>

/** �����Ϳ� �迭
*  �迭�� �̸��� �����ʹ�!  ������ '���'��!
*	������ ������ ����ȴ�.
*
*	�迭÷�� ������ []  �� �ᱹ ������ �����̴�
*
*		arr[n] �� *(arr + n)   �ڡڡ�
*
**/

// �迭�� �Ű������� �޴� �Լ�, ������ �� ����, length ���� �Ű������� ����ؾ� �Ѵ�.

// �־��� �迭�� ���� ����ؼ� �������ִ� �Լ�
// p : int*, (�� int �迭�� ������ �ִ�)
// length : �迭������ ����
int calcTotal(int *p, int length)  
{	
	// �Ұ� p ũ��� 4, int ũ��� 4 => 1
	// int length = sizeof(p) / sizeof(int);

	int sum = 0;
	for (int i = 0; i < length; i++) {
		sum += p[i];
	}
	return sum;
}




int main()
{
	int arr[3] = { 10, 20, 30 };

	// �迭�̸��� �� �迭�� '�ּ�' ��.  �����Ϳ� ����(ó��) �����Ѵ�
	// Ÿ����?  int* Ÿ��
	// arr[1]�� �ּҴ� arr[0]���� 4ũ��(int Ÿ��)
	printf("arr = %p\n", arr);
	printf("*arr = %d\n", *arr);	// arr�� ù��° �ּ��� ��

	printf("arr + 0 = %p, *(arr + 0) = %d\n", arr + 0, *(arr + 0));
	printf("arr + 1 = %p, *(arr + 1) = %d\n", arr + 1, *(arr + 1));
	printf("arr + 2 = %p, *(arr + 2) = %d\n", arr + 2, *(arr + 2));

	printf("\n");
	printf("arr[0] = %d, *(arr + 0) = %d\n", arr[0], *(arr + 0));
	printf("arr[1] = %d, *(arr + 1) = %d\n", arr[1], *(arr + 1));
	printf("arr[2] = %d, *(arr + 2) = %d\n", arr[2], *(arr + 2));

	// ���� : * ���������� �켱������ �Ϲ����� ��������ں��� ����
	// *(arr + 1) 
	// *arr + 1  
	printf("\n");
	printf("*(arr + 1) = %d, *arr + 1 = %d\n", *(arr + 1), *arr + 1);
	printf("\n");

	// �ٸ� ������ ������ �迭�� ����ų �� �ִ�.
	int *p = arr;
	printf("p[0] = %d\n", p[0]);
	printf("p[1] = %d\n", p[1]);
	printf("p[2] = %d\n", p[2]);

	// ������ ������ �迭�� ������
	printf("sizeof(p) = %d\n", sizeof(p));	// 4byte
	printf("sizeof(arr) = %d\n", sizeof(arr));	// 4*3 byte

	printf("p = %p, &p = %p\n", p, &p);
	printf("arr = %p, &arr = %p\n", arr, &arr);

	int arr2[] = {100, 200, 300};
	p = arr2;
	// arr = arr2;		// �Ұ� �迭 �̸��� '���'. ���� �Ұ�.
	// arr2 = p;
	printf("\n");

	// �Լ� ȣ�� �� �Ű������� �迭�̸�(������) ����
	int total = calcTotal(arr, sizeof(arr) / sizeof(int));
	printf("������ = %d\n", total);


	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}