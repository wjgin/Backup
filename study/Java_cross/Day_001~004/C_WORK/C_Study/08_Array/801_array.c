#include <stdio.h>

/* 배열(array)
*	동일한 타입의 데이터(들)을 '하나의 배열이름' 으로 담아놓은 집합데이터
*
*	배열 변수 선언
*		타입 배열변수명[배열크기];
*		타입 배열변수명[] = { 초기화 값(들)..};
*
*  배열 첨자(index)를 사용하여 각각의 배열원소(element) 사용.
*       배열 첨자는 0 부터 시작!
*/


int main()
{
	// TODO
	// 동일한 타입과 내용의 데이터를 위해 매번 다른 이름의 변수를 생성??  불가능!

	// 5개의 int 타입 데이터를 담는 배열 선언
	int korArr[5];
	// 배열 첨자(index)를 사용하여 각각의 배열원소(element) 사용.
	// 배열 첨자는 0 부터 시작!
	// korArr[0] ~ korArr[4]  
	
	korArr[0] = 100;
	korArr[1] = 97;
	korArr[2] = 88;
	korArr[3] = 77;
	korArr[4] = 65;

	printf("첫 번째 학생 점수 : %d\n", korArr[0]);
	printf("두 번째 학생 점수 : %d\n", korArr[1]);


	// 순환문 사용
	for (int i = 0; i < 5; i++) {
		printf("%d 번째 학생의 점수 : %d\n", i, korArr[i]);
	}

	// 5명 점수의 총점 구하기
	printf("--------------\n");

	int total = 0;
	for (int i = 0; i < 5; i++) {
		total += korArr[i];	// 누적합산
	}
	printf("총점 : %d\n", total);
	printf("평점 : %.1f\n", total / 5.0);

	// C언어 주의!
	// 배열 인덱스 범위!  벗어나도 에러 안냄.. .
	//    쓰레기값(garbage value) 나옴.
	printf("-------------------------------\n");

	// korArr의 타입은 ? int[] 인티저형 배열 not 인티저
	// korArr원소들의 타입은?  int 

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}