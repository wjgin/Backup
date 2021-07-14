#include <stdio.h>

/*
* switch(����)
* {
* case n1:
*	...
*	break;
* case n2:
*	...
*	break;
*
* ...
* default:
*	...
*	break;
*}
*/

int main()
{
	int n = 4;

	switch (n)	// switch(����)
	{
	case 1:	// �� ���� ���� 1�� ��� �Ʒ� �ڵ� ����
		printf("n ���� 1 �Դϴ�. \n");
		break;	// switch �� ����
				// break ������ �� ���� ��� ����
	
	case 2:		// case �� ���� ����
		printf("n ���� 2 �Դϴ�. \n");
		break;

	case 3:
		printf("n ���� 3 �Դϴ�. \n");
		break;

	default:	// ��� case�� �ش����� �ʴ� ���
		printf("�ش� ���� �����ϴ�.\n");
	}

	// TODO :  n���� ¦���̸� "¦���Դϴ�" ���
	// Ȧ���̸� "Ȧ���Դϴ� " ���
	// switch ~ case �� ���
	n = 34;
	int num = n % 2;
	switch (num)
	{
	case 0:		// ¦���� ���
		printf("¦�� �Դϴ�. \n");
		break;	

	case 1:		// Ȧ���� ���
		printf("Ȧ�� �Դϴ�. \n");
		break;

	default:	
		printf("�ش� ���� �����ϴ�.\n");
	}


	// 4���� -> A
	// 3���� -> B
	// 2���� -> C
	// 1���� -> D
	// �� ���� -> F

	// �ش� ���̽��� �ٷ� ã�ư��� ������ ��Ȳ�� ���� if �� ���� ȿ������ ���� �ִ�.
	double point = 0.7;

	switch ((int)point)	// �� ��ȯ�� ���� �Ǽ� -> ���� (�Ҽ��� ���� ����)
	{
	case 4:		// 4�� ��
		printf("A �Դϴ�. \n");
		break;

	case 3:		// 3�� ��
		printf("B �Դϴ�. \n");
		break;

	case 2:		// 2�� ��
		printf("C �Դϴ�. \n");
		break;

	case 1:		// 1�� ��
		printf("D �Դϴ�. \n");
		break;

	default:
		printf("F\n");
	}





	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}