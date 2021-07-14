#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int num1, num2, num3;
	scanf("%d %d %d", &num1, &num2, &num3);
	
	int min = num1 <= num2 ? num1 : num2;
	min = min <= num3 ? min : num3;
	
	printf("%d", min);

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}