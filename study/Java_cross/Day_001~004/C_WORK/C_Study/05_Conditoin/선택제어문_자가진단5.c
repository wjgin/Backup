#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	float num1, num2;
	scanf("%f %f", &num1, &num2);

	if (num1 >= 4.0 && num2 >= 4.0) printf("A");
	else if (num1 >= 3.0 && num2 >= 3.0) printf("B");
	else printf("C");

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}