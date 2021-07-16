#include <stdio.h>

/*
	pointer to pointer
*/

int main()
{
	int num1 = 10;
	int *p = NULL;	// int 를 가르키기 위한 포인터, 초기값 NULL
	int** pp = NULL;	// int*를 가르키기 위한 포인터	/	2차원 포인터라고 함
	p = &num1;
	pp = &p;	// pointer p의 주소를 담은 pp

	printf("%d %p %p %p\n", num1, p, pp, *pp);

	printf("%d %d %d\n", num1, *p, **pp);

	// p의 타입은 int*
	// *p타입은 int

	// pp의 타입은 int**
	// *pp의 타입은 int*
	// **pp의 타입은 int

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}