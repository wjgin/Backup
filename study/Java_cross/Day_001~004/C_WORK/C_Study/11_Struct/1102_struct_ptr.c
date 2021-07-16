#include <stdio.h>
#include <string.h>
/*

*/

struct person {
	char name[20];	// 이름
	int age;		// 나이
	double weight;	// 몸무게
};

// typedef으로 간단히 사용
typedef struct person PS;

typedef struct _person {
	char name[20];	// 이름
	int age;		// 나이
	double weight;	// 몸무게
} Person;

char* Fmt = "이름 : %s, 나이 : %d, 몸무게 : %.1f\n";

void printPerson(Person *p) {
	printf(Fmt, p->name, p->age, p->weight);
}

int main()
{
	// struct person p1;
	PS p1;
	Person p2, p3 = { "토르", 100, 92.55};
	
	// 구조체의 크기
	printf("구조체 크기는 %d bytes\n", sizeof(Person));	// 일단 계산은 맞는다.

	// 구조체에 대한 포인터
	Person* ptr = &p3;

	printf(Fmt, p3.name, p3.age, p3.weight);
	printf(Fmt, (*ptr).name, (*ptr).age, (*ptr).weight);
	printf(Fmt, ptr->name, ptr->age, ptr->weight);

	printPerson(&p3);

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}