#include <stdio.h>
// 변수 (Variable) 
// 프로그램에서 데이터를 담기 위한 공간
// 이 공간에 '이름' 을 붙여서 관리.  이 이름을 변수명(variable name) 이라 함.

// 변수는 사용하기 전에 반드시 선언(declaration) 해야 함.
// 변수 선언 구문
//    [변수 타입]  [변수명];

// 변수는 '사용'하기 전에 반드시 초기화 (initialization) 해야 함.
// 초기화 란 '최초' 에 값을 대입(assign)하는 것

// 특정 블럭(block) 안에서 선언한 변수를 지역변수(local variable) 이라 함


int main()
{
	printf("변수(variable)\n");

	int a;	// int 타입의 변수 a 선언, int 타입: 정수 타입(intger)
	int b;
	int c;
	int mike, jane; // 한번에 여러개 변수 선언 가능.

	// printf("서식문자열")
	// 서식문자열(format string) 안에 서식지정자(format specifier) : %d, %f..
	printf("제 나이는 23살 입니다.\n");
	printf("제 나이는 %d살 입니다.\n", 34);
	printf("제 나이는 %d살 입니다.\n", 10 + 9);
	printf("%d년은 제가 %d살이 되는 해 입니다. \n", 2021, 23);

	a = 100;	// a 변수에 100 값을 대입 (assign)
	            // 변수에 최초로 대입하는 것을 '초기화' 라 한다.
				// = : 대입 연산자 (assignment operator)
	printf("a = %d\n", a);
	printf("a x a = %d\n", a * a);

	a = 200;	// a 변수에 200 값을 대입(덮어쓰기, 변경)

	printf("%d + %d = %d\n", a, a, a + a);

	//printf("x = %d\n", x);	// 선언되지 않은 변수는 사용 불가.
	//int x; // 변수는 선언한 이후 부터 사용 가능.
	
	//printf("mike = %d, jane = %d\n", mike, jane);	// 초기화 되지 않은 변수 사용 불가.

	// 변수명 작성시 주의
	// 영문자, 숫자, _ 로 구성가능
	// 숫자로 시작하면 안됨!
	// 띄어쓰기 안됨!
	// 대소문자 구분함!  (ex: mike, Mike <-- 다른변수다) 
	// 키워드(예약어)는 사용 불가 (ex: for, if, return...)

	int hello_my_world2021;
	// int a; // 동일한 이름의 지역변수 선언 불가

	int aaaa, AAAA, Aaaa, aaaA; // 대소문자 구분 -> 모두 다른 변수
	int _total_;
	// int 2021football; // 숫자로 시작하면 안됨
	// int return; // 키워드 사용 불가
	// int my world; // 띄어쓰기 안됨
	
	getchar();
	return 0;
}

// 주석: CTRL + K + C
// 주석해제: CNTRL + K + U