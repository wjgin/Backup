#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	char sex;
	scanf("%c", &sex);
	int age;
	scanf("%d", &age);

	if (sex == 'M') {
		if (age >= 18) printf("MAN");
		else printf("BOY");
	}
	else if (sex == 'F') {
		if (age >= 18) printf("WOMAN");
		else printf("GIRL");
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}