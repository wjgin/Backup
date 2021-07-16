#include <stdio.h>

/** 포인터와 배열
*  배열의 이름은 포인터다!  포인터 '상수'다!
*	포인터 연산이 적용된다.
*
*	배열첨자 연산자 []  ← 결국 포인터 연산이다
*
*		arr[n] ↔ *(arr + n)   ★★★
*
**/

// 배열을 매개변수로 받는 함수, 포인터 로 선언, length 값도 매개변수에 명시해야 한다.

// 주어진 배열의 합을 계산해서 리턴해주는 함수
// p : int*, (즉 int 배열을 받을수 있다)
// length : 배열원소의 개수
int calcTotal(int *p, int length)  
{	
	// 불가 p 크기는 4, int 크기는 4 => 1
	// int length = sizeof(p) / sizeof(int);

	int sum = 0;
	for (int i = 0; i < length; i++) {
		sum += p[i];
	}
	return sum;
}




int main()
{
	int arr[3] = { 10, 20, 30 };

	// 배열이름은 곧 배열의 '주소' 다.  포인터와 같이(처럼) 동작한다
	// 타입은?  int* 타입
	// arr[1]의 주소는 arr[0]보다 4크다(int 타입)
	printf("arr = %p\n", arr);
	printf("*arr = %d\n", *arr);	// arr의 첫번째 주소의 값

	printf("arr + 0 = %p, *(arr + 0) = %d\n", arr + 0, *(arr + 0));
	printf("arr + 1 = %p, *(arr + 1) = %d\n", arr + 1, *(arr + 1));
	printf("arr + 2 = %p, *(arr + 2) = %d\n", arr + 2, *(arr + 2));

	printf("\n");
	printf("arr[0] = %d, *(arr + 0) = %d\n", arr[0], *(arr + 0));
	printf("arr[1] = %d, *(arr + 1) = %d\n", arr[1], *(arr + 1));
	printf("arr[2] = %d, *(arr + 2) = %d\n", arr[2], *(arr + 2));

	// 주의 : * 참조연산자 우선순위가 일반적인 산술연산자보다 높다
	// *(arr + 1) 
	// *arr + 1  
	printf("\n");
	printf("*(arr + 1) = %d, *arr + 1 = %d\n", *(arr + 1), *arr + 1);
	printf("\n");

	// 다른 포인터 변수로 배열을 가리킬 수 있다.
	int *p = arr;
	printf("p[0] = %d\n", p[0]);
	printf("p[1] = %d\n", p[1]);
	printf("p[2] = %d\n", p[2]);

	// 포인터 변수와 배열의 차이점
	printf("sizeof(p) = %d\n", sizeof(p));	// 4byte
	printf("sizeof(arr) = %d\n", sizeof(arr));	// 4*3 byte

	printf("p = %p, &p = %p\n", p, &p);
	printf("arr = %p, &arr = %p\n", arr, &arr);

	int arr2[] = {100, 200, 300};
	p = arr2;
	// arr = arr2;		// 불가 배열 이름은 '상수'. 변경 불가.
	// arr2 = p;
	printf("\n");

	// 함수 호출 시 매개변수로 배열이름(포인터) 전달
	int total = calcTotal(arr, sizeof(arr) / sizeof(int));
	printf("총점은 = %d\n", total);


	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}