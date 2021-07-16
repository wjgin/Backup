#include <stdio.h>

/*
*	배열의 크기 (size) : 배열의 용량크기 (byte)
*	배열의 길이 (length) : 배열원소의 개수
*/

int main()
{
	// sizeof() 연산자
	// 데이터의 크기를 byte (정수) 로 리턴
	printf("%d\n", sizeof(100));	// 정수 리터럴 / 정수의 용량(4byte)
	short s = 100;
	printf("%d\n", sizeof(s));	// short  타입의 size 2byte
	printf("%d\n", sizeof(double));	// 타입명의 사이즈도 확인 가능

	int arr[3];
	printf("sizeof(배열) : %d\n", sizeof(arr));		// 배열 이름으로 배열크기 계산 가능
	printf("arr[0]의 size : %d\n", sizeof(arr[0]));		// 배열 원소의 크기

	// 배열의 길이 구하는 공식
	// sizeof(배열이름) / sizeof(배열원소타입)
	// sizeof(배열이름) / sizeof(배열의 첫번째 원소)
	printf("arr의 length = %d\n", sizeof(arr) / sizeof(arr[0]));

	// c언어는 length가 0인 배열 선언 불가능

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}