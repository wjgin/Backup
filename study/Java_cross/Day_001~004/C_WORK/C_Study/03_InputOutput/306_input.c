#include <stdio.h>
#pragma warning(disable:4996)

/*

*/

int main()
{
	// char�� �Է� ���� ��, ����
	char ch;
	int a;

	printf("���� �ϳ� �Է� :");
	(void)scanf("%c", &ch);
	printf("�Է��� ���ڴ� = %c\n", ch);

	printf("���� �ϳ� �Է�:");
	(void)scanf("%d", &a);

	printf("�� �ٽ� ���� �ϳ� �Է�:");
	(void)getchar(); // ���ۿ� ���� �ִ� �� �ٲ� ���� ����
	(void)scanf("%c", &ch);

	printf("a = %d,ch = %c\n",a, ch);
	(void)getchar();

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;

/*
   �Է� ���� ���� ����

	1. while(getchar()!= '\n');

	2. fflush(stdin):  vs������ ���

	3. __fpurge(stdin) : ������ ȯ�濡���� ���
*/



}