#include <stdio.h>
#include <string.h>

/*
*	구조체 (struct)
*		여러개의 데이터들 (멤버) 로 구성된 사용자 정의 자료형
*
*
*	학생의 데이터
*		-학번 : char[]
*		-이름 : char[]
*		-나이 : unsigned char  (0 ~ 255)
*		-학년 : unsigned char
*		-성별 : 'M', 'F'  char
*		-키 : 173.4  float
*		...
*/

// 구조체 poit 정의
struct point {
	// 멤버변수들(member variable) 나열
	int x;
	int y;

};


int main()
{
	// point 구조체 타입의 변수 선언
	struct point p1;

	// 멤버 연산자( . )을 사용하여 구조체 멤버 사용
	p1.x = 100;
	p1.y = 200;

	printf("p1 = (%d, %d)\n", p1.x, p1.y);

	// person 구조체 정의
	struct person {
		char name[20];	// 이름
		int age;		// 나이
		double weight;	// 몸무게
	};

	struct person p2;
	p2.age = 32;
	p2.weight = 54.7;
	strcpy(p2.name, "홍길동");	// 배열은 포인터 상수이므로 변경 불가	/ 함수 사용
	printf("이름 : %s, 나이 : %d, 몸무게 : %.1f\n", p2.name, p2.age, p2.weight);

	// 구조체 선언과 동시에 초기화
	struct person p3 = { "아이언맨", 48, 87.663 };
	printf("이름 : %s, 나이 : %d, 몸무게 : %.1f\n", p3.name, p3.age, p3.weight);


	
	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}