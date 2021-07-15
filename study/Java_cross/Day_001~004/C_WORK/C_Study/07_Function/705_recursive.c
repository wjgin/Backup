#include <stdio.h>

/*
*	재귀호출 (Recursive Call)
*	- 함수가 실행중에 자신을 다시 호출하는 것.
*   - 복잡한 문제를 단순화하여 구현하는 장점
*	- 무한한 재귀호출은 불가
*	- 호출 스택 과부하
*/

// n! = n * (n - 1) * (n - 2) * ...  * 1
//	  = n * (n - 1)! <- factorial을 factorial로 정의

int fac(int n) {
	if (n == 0) return 1;	// 0! == 1
	return n * fac(n - 1);	// 재귀 호출
}
		

int func1(int n) {
	printf("func1(%d) 호출\n", n);

	return func1(n + 1);
	}

int main()
{
	// func1(1);  // 무한 재귀함수 실행시 stackOverflow 발생

	int n = 5;
	printf("%d = %d\n", n, fac(n));

	/*
	factorial(5)
		└  5 * factorial(4)
				└  4 * factorial(3)
						└  3 * factorial(2)
								└  2 * factorial(1)
										└  1 * factorial(0)
	*/

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}