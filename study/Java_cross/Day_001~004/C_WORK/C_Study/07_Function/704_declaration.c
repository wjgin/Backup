#include <stdio.h>
#include "myfuntion.h"	// ��� ���� ��������
/*

*/

int main()
{
	printf("MAX = %d\n", MAX);	// ��� ���Ͽ��� ���ǵ� ���� ���

	Data i = 3, j = 4;

	printf("power() ��� : %d\n", power(i, j));
	printf("doubleUp() ��� : %.1f\n", doubleUp(j));

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}