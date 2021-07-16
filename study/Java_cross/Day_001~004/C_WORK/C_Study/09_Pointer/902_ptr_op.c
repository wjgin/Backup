#include <stdio.h>

/** 포인터 연산
*
*	명심:
*	  포인터 -> 주소
*	  *포인터 -> 그 주소가 가리키는 값
*	포인터 타입 -> 그 주소가 가리키는 값의 타입
*
*	포인터변수에 +, - 연산을 하는 것은
*	결국 주소값을 증감 하는 것인데,
*	주소값이 얼마만큼 증감 하느냐는 '포인터 타입' 에 따라 다르다
*
*	ex) int* 포인터 인 경우 가리키는 값의 타입이  int (4byte) 이기 때문에
*		포인터 값에 + 1 연산을 할 경우 주소값이 4증가한다.
*
**/


int main()
{
	int n = 555;
	int *p = &n;	// p에 n의 주소 저장

	printf("n = %d, *p = %d, p = %p\n", n, *p, p);

	// n, p에 각각 + 1 연산을 하면?
	printf("n + 1 = %d, *p = %d, p + 1 = %p\n", n + 1, *p + 1, p + 1);
	printf("\n");

	short s = 222;
	short *p2 = &s;	// p2의 타입은 ? short*

	printf("s = %d, p2 = %p\n", s, p2);
	printf("s + 1 = %d, p2 +1 = %p\n", s + 1 , p2 + 1);
	printf("s + 3 = %d, p2 + 3 = %p\n", s + 3, p2 + 3);
	



	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}