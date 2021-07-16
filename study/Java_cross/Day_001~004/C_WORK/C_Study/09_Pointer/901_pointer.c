#include <stdio.h>

/**  포인터1 :
*	메모리
*		연속된 1byte 단위들의 공간
*		1 byte 단위로 데이터를 저장된다.
*		각 byte 데이터는 고유한 주소값을 통해 접근 가능
*		ex) int 값은 4byte 이므로 '연속된' 1byte x 4개 공간에 저장된다.
*
*	주소
*		: Windows 환경에선 주소는 4byte.  (Mac 이나 Linux 에선 8byte);
*
*	주소연산자 : &
*		변수가 저장된 주소값을 리턴하는 연산자
*		int 같이 여러byte 에 걸쳐 저장된 데이터의 경우 첫번째 byte 의 주소값
*
*	참조연산자 *
*       포인터를 사용해서, 담고 있는 주소값을 찾아가 그 주소 안의 '값'을 참조. (읽기, 쓰기)
**/

int main()
{
	printf("주소 연산자 & \n");

	int n = 100;

	// 주소값 출력시는 %p ㅊㅊ;
	// 변수명 앞에 & 사용하면 변수의 주소값 반환
	// %p 로 출력시 16진수 8자리로 표현 (32bit, 4byte) ※ 16진수 2자리를 1byte 분량에 해당

	printf("n = %d, n 의 주소는 %d, %x, %X, %p\n", n, &n, &n, &n, &n);
	printf("sizeof(n) = %d\n", sizeof(&n));

	// 포인터 변수, '주소'를 담는 주소
	int *p;	// defined int type pointer
			// p는 int 타입의 데이터를 가르키는 주소를 담는다.

	p = &n;	// int n 의 주소를 pointer p에 대입

	printf("p = %p, &n = %p\n", p, &n);
	
	// 참조 연산자(읽기 동작)
	printf("p = %d\n", *p);	// p의 주소를 찾아서 처음부터 모두 읽기

	*p = 500;	//p의 주소를 찾아가 값을 500으로 변경
	printf("n = %d, *p = %d\n", n, *p);
	printf("\nENTER을 누르면 종료합니다.\n");

	int *p2;	// p2의 타입은 int * (인티저형 포인터)
	
	p2 = p;		// p2변수에 p의 주소를 저장, 같은 메모리 주소에 저장되는 것은 x
				// 접근하면 안되는 메모리 영역을 포인터로 접근하려 하면 에러

	printf("p2 = %p, *p2 = %d\n", p2, *p2);
	// p, p2도 변수다. 서로 다른 주소의 메모리 공간에 자리 잡고 있다.
	printf("&p = %p, &p2 = %p\n", &p, &p2);


	(void)getchar();
	return 0;
}