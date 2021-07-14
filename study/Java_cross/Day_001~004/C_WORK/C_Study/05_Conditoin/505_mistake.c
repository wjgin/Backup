#include <stdio.h>
#define GOOD  1
#define BAD 0
/*

*/

int main()
{
	if (10 < 4); // 순환문 뒤에 ;를 붙이지 않기
	{
		printf("실행 되면 안되는 문장\n");
	}

	int mind = BAD;

	if(mind = GOOD)	// 대입 연산자 실수
		{
			// 문장
		}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}