#include <stdio.h>

/* ■ 지역변수 (local variable)
*   블럭 :  {  .... }
*
*   블럭 안에서 선언된 변수는 선언이후 블럭안에서만 사용가능함
*   블럭이 끝나면 해당 이름의 변수는 사용 불가
*
*   이러한 변수를 지역변수(local variable) 이라 하고
*    local scope (지역 범위) 를 갖는다 라고 말합니다.
*    scope 는 해당 이름을 사용할수 있는 범위
*
*  ■ 전역변수 (global variable)
*    함수 밖에서 선언된 변수
*    선언된 이후 어느 곳에서나 사용 가능.
*    global scope 를 갖는다.
*/

int YEAR = 2021; // 전역변수 YEAR 선언 및 초기화.

int main()
{
	int grade = 4;

	printf("YEAR = %d\n", YEAR);

	{
		int a = 100; // 변수 선언과 동시에 초기화.
					 // 선언된 블럭에서만 사용 가능한 지역변수 a
		printf("a = %d\n", a);
		printf("grade = %d\n", grade);
		YEAR = 1988;	// 선역변수는 어느 위치에서든 수정 가능.
	}	// 블럭의 끝. 블럭 안에서 선언된 변수는 더 이상 사용 불가.

	// printf("a = %d\n", a);
	
	printf("YEAR = %d\n", YEAR);

	int age = 32;

	{
		age = 42;	// 블록 바깥 변수 값을 저장
		int age = 60; // 안쪽 블럭에서 생성시 새로운 변수로 취급(JAVA의 경우 불가능)
		printf("age = %d\n", age);
	}

	printf("age = %d\n", age);

	printf("ENTER를 누르면 종료합니다.\n");
	getchar();
	return 0;
}