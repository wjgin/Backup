#include <stdio.h>

/*
*	if(���ǽ�)
*		'��'�϶� ����
*	else
*		'����'�϶� ����
*
*
*	if(���ǽ�1)
*		���ǽ�1 �� '��' �϶� ����
*	else if (���ǽ�2)
*		���ǽ�2 �� '��' �϶� ����
*	else if (���ǽ�3)
*		���ǽ�3 �� '��' �϶� ����
*	..
*	else
*		�� ���ǽĵ� ��� �����϶� ����
*/



int main()
{
	int n = 48;

	if (n % 2 == 0)
	{
		// '��' �� �� �����ϴ� �ڵ�
		printf("¦�� �Դϴ�.\n");
	}
	else
	{
		// '����'�� �� �����ϴ� �ڵ�
		printf("���� �Դϴ�.\n");
	}

	//--------------------------------------
	// if .. else if .. else if...

	double point = 2.8;

	if (point >= 4.0) {
		printf("A����\n");
	}
	else if (point >= 3.0) {
		printf("B����\n");
	}
	else if (point >= 2.0) {
		printf("C����\n");
	}
	else if (point >= 1.0) {
		printf("D����\n");
	}
	else {
		printf("F �Դϴ�.\n");
	}
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}