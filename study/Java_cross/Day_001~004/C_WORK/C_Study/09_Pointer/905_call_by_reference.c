#include <stdio.h>

/*
*  함수호출시 매개변수 전달 방식에 따라
*  1. Call By Value (값에 의한 호출)
*     : 기본적으로 매개변수 값의 '복사' 발생
*     : 호출한 원본은 변화 없다.
*  2. Call By Reference (참조에 의한 호출)
*     : 호출시 포인터(주소)를 함수에 넘겨준다
*	  : 기본적으로 매개변수(포인터, 주소) 값의 '복사' 발생
*     : 호출한 원본의 변화 발생
*/

void inc4(int* const p) {	// 포인터 상수 / 포인터 p가 상수 일 때
	*p += 1;	// p가 가르키고 있는 대상은 변경 가능
	printf("inc4() *p => %d\n", *p);
	int a = 100;
	//p = &a; // p 값은 변경 불가능
}

void inc3(const int* p) {	// 상수에 대한 포인터 / const int를 가르키는 포인터 p
	// *p += 1	// 에러,. 쓰기 불가 p가 가르키는 곳의 값은 변경 불가
	printf("inc3() *p => %d\n", *p);	// 읽기 가능

	int a = 100;
	p = &a;	// p 값 변화 가능
	printf("inc3() *p => %d\n", *p);
}

void inc1(int n)
{
	n += 1;
	printf("inc() n = %d\n", n);
}

void inc2(int* p) {
	*p += 1;
	printf("inc2() *p = %d\n", *p);
}
int main()
{
	int n = 10;
	inc1(n);	// 함수 호출
	printf("inc1() 리턴 후 n = %d\n", n);	// 호출한 원본의 값이 변화 x

	inc2(&n);	// 호출시 주소를 넘김
	printf("inc2() 리턴 후 n = %d\n", n);	// 호출한 원본의 값이 변화 o

	inc3(&n);
	/*
	int* p1;	// 포인터 변수
	const int* p2;	// 상수에 대한 포인터 변수

	int* const p3;	// 포인터 상수
	const int* const p4;	// 상수에 대한 포인터 상수

	int m = 10;
	int* q = &m;
	(*q)++;	// *q += 1와 같은
	// *q++; 은 *(q++)의 의미
	printf("%d\n", m);
	*/
	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}