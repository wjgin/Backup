#include <stdio.h>
#pragma warning(disable:4996)
/*
	���ڿ� �Է�
*/

int main()
{
	char name[20];	// �ִ� 20���� ���� �� �ִ� ���ڿ� name

	printf("�̸��� �Է��ϼ��� :");
	(void)scanf("%s", name);	// ���ڿ��� �Է¹��� ��, &�� ������ ����.
								// �� �ϴ� ���� ���� �Է¹޾ƾ� �Ѵ�.
								// %s : ������� ���ڿ� �Է�
	printf("���� �̸��� %s\n", name);

	int age;
	printf("���̸� �Է��ϼ��� :");
	(void)scanf("%d", &age);

	char nick[20];
	printf("���� �Է��ϼ��� :");
	(void)scanf("%s", nick);
	printf("���� : %d ���� : %s\n", age, nick);

	(void)getchar();
	// �� �� �Է�
	// gets()
	printf("full-name�� �Է��ϼ��� :");
	gets(name);		// ���� �����ؼ� ENTER �Է� ������ �� �� �Է�
	printf("Full-name�� %s �Դϴ�.\n", name);

	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}