#include <stdio.h>
#pragma warning(disable:4996)
/*
	문자열 입력
*/

int main()
{
	char name[20];	// 최대 20문자 담을 수 있는 문자열 name

	printf("이름을 입력하세요 :");
	(void)scanf("%s", name);	// 문자열을 입력받을 때, &를 붙이지 않음.
								// ※ 일단 띄어쓰기 없이 입력받아야 한다.
								// %s : 공백없는 문자열 입력
	printf("너의 이름은 %s\n", name);

	int age;
	printf("나이를 입력하세요 :");
	(void)scanf("%d", &age);

	char nick[20];
	printf("별명도 입력하세요 :");
	(void)scanf("%s", nick);
	printf("나이 : %d 별명 : %s\n", age, nick);

	(void)getchar();
	// 한 줄 입력
	// gets()
	printf("full-name을 입력하세요 :");
	gets(name);		// 공백 포함해서 ENTER 입력 전까지 한 줄 입력
	printf("Full-name은 %s 입니다.\n", name);

	(void)getchar();
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}