#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	char ch;
	scanf("%c", &ch);
	
	if (ch == 'A') printf("Excellent");
	else if (ch == 'B') printf("Good");
	else if (ch == 'C') printf("Usually");
	else if (ch == 'D') printf("Effort");
	else if (ch == 'F') printf("Failure");
	else printf("error");

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}