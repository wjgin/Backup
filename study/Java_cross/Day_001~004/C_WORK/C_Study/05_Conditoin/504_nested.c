#include <stdio.h>
#pragma warning(disable:4996)
/*
	��ø ���ǹ�(nested - if, nested - swtch)
*/

int main()
{
	// ���� �ϳ� �Է� �޾Ƽ�
	// ¦���̸� "¦���Դϴ�" �� ����ϰ�
	//      ¦���̸鼭 3�� ����̸� "3�� ����Դϴ�" ��� ����ϼ���
	//      ¦���̸鼭 3�� ����� �ƴϸ� "¦�������� 3�� ����� �ƴմϴ�" ��� ����ϼ���
	// Ȧ���̸� "Ȧ���Դϴ�" �� ����غ�����

	int n;
	printf("�����ϳ� �Է��ϼ���: ");
	(void)scanf("%d", &n);

	if (n % 2 == 0) {
		printf("¦�� �Դϴ�.\n");
		n % 3 == 0 ? printf("3�� ����Դϴ�.\n") : printf("¦�������� 3�� ����� �ƴմϴ�.\n");
	}
	else {
		printf("Ȧ�� �Դϴ�.\n");
	}

	// swich �� ��ø
	printf("----------");
	switch (n % 2)
	{
	case 0 :
		printf("¦�� �Դϴ�.\n");

		switch (n % 3)
		{
		case 0:
			printf("3�� ��� �Դϴ�.\n");
			break;
		default:
			printf("¦�� ������ 3�� ����� �ƴմϴ�.\n");
		}
		break;
	case 1:
		printf("Ȧ�� �Դϴ�.\n");
		break;
	}

	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}