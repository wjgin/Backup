#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	int age;
	scanf("%d", &age);	// 나이 입력
	int leftAge = 20 - age; // 성인까지 남은 나이

	if (age >= 20)
		printf("adult");
	else
		printf("%d years later", leftAge);


	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}