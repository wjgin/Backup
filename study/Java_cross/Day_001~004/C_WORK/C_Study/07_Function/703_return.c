#include <stdio.h>

// 리턴타입 함수이름(매개변수..)
// 리턴값 : 함수는 자기를 호출한 함수에 값 1개를 돌려줄수 있다. 
//          이를 리턴값(return value) 라 함
// 매개변수(argument)
//      함수를 호출하는 쪽에서 넘겨주는 값을 받을 변수.
//      (타입 변수명, 타입 변수명...) 형식

// 함수이름 : add
// 매개변수 : int, int
// 리턴값 : int (두 매개변수를 덧셈한 결과를 리턴)

int add(int a, int b) {
	int sum = a + b;
	return sum;	// return 값 : 함수 종료하고 호출한 쪽으로 값을 돌려줌
}

// 함수이름 : sub
// 매개변수 : int, int
// 리턴값 : int  (두 매개변수를 뺀 결과값 리턴)

int sub(int a, int b) {
	return a - b;
}

void mul(int a, int b) {
	printf("mul() 호출\n");
	return;	// 함수 실행 중에 return을 만나면 바로 종료, 리턴
	printf("%d x %d = %d\n", a, b, a * b);
	// 마지막 문장 끝나면 return을 명시 안해도 자동으로 return 된다.
}

// 함수 선언 (function declaration)
// 함수 정의가 호출부 이후에 있거나, 혹은 다른 파일에 있는 경우
// 미리 함수 선언을 해주어 컴파일 가능케 함.
// 함수선언구문
//     리턴타입 함수명 (매개변수 ...);    <-- 함수의 프로토타입(원형: prototype) 이라고도 함

double half(double);	// 함수 선언부 매개변수명은 생략 가능 

int main()
{
	int result = add(100, 40);
	printf("result = %d\n", result);
	printf("40 + 30 = %d\n", add(40, 30));
	printf("40 - 30 = %d\n", sub(40, 30));

	result = add(add(10, 20), sub(40, 80));
	printf("result = %d\n", result);
	
	mul(40, 30);

	printf("41을 2로 나눈 결과는 %.1lf\n", half(41));

	



	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;	// 시스템이 메인함수를 호출하고 0을 리턴해줌 / 정상 종료의 코드 값은 0
}

// C언어는 
// 함수 호출(사용)하기 전에 반.드.시 먼저 '정의' 되어 있거나 혹은 '선언' 되어 있어야 한다.

double half(double arg) {
	return arg / 2;
}