#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int age;
	scanf("%d", &age);	// ���� �Է�
	int leftAge = 20 - age; // ���α��� ���� ����

	if (age >= 20)
		printf("adult");
	else
		printf("%d years later", leftAge);


	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}