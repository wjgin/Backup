#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	int a, b, c;
	printf("���� 3�� �Է��ϼ��� :");
	(void)scanf("%d %d %d", &a, &b, &c);
	printf("�Է� ��� a = %d, b = %d, c = %d\n", a, b, c);
	// �� �� �ٿ� ������ �Է� ����, �����ٿ� ���� �Էµ� ����

	printf("�� ���� 3�� �Է��ϱ� : ");
	(void)scanf("%d", &a);
	(void)scanf("%d", &b);
	(void)scanf("%d", &c);
	
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}