#include <stdio.h>

/*
	do ~ while
	�ϴ� '�ѹ�'�� �����ϰ� ���ǽ� �˻�
*/

int main()
{
	int i = 1;
	 while(i < 0) {
		 printf("whle�� ���� ��\n");	// ���ǽ� false ���� x
	}

	 i = 0;
	 do {
		 printf("do ~ while�� ���� ��\n");	// �ѹ��� ����
	 } while (i < 0);

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}