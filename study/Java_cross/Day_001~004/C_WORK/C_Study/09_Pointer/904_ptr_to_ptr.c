#include <stdio.h>

/*
	pointer to pointer
*/

int main()
{
	int num1 = 10;
	int *p = NULL;	// int �� ����Ű�� ���� ������, �ʱⰪ NULL
	int** pp = NULL;	// int*�� ����Ű�� ���� ������	/	2���� �����Ͷ�� ��
	p = &num1;
	pp = &p;	// pointer p�� �ּҸ� ���� pp

	printf("%d %p %p %p\n", num1, p, pp, *pp);

	printf("%d %d %d\n", num1, *p, **pp);

	// p�� Ÿ���� int*
	// *pŸ���� int

	// pp�� Ÿ���� int**
	// *pp�� Ÿ���� int*
	// **pp�� Ÿ���� int

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}