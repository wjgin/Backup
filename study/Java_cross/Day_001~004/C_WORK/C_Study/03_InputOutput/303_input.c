#include <stdio.h>
#pragma warning(disable:4996)

/*

*/

int main()
{
	float height, weight;
	printf("키를 입력세요(cm) : "); 
	(void)scanf("%f", &height);	// %f, 키보드로부터 실수 입력 받아서 float변수 대입
	
	printf("체중을 입력세요(kg) : ");
	(void)scanf("%f", &weight);

	printf("키  : %.1fcm 체중: %.1fkg\n", height, weight);

	double d1;
	printf("실수를 입력하세요 :");
	// (void)scanf("%f", &d1);	// double 타입 입력 받을 때는 %lf 사용
	(void)scanf("%lf", &d1);
	printf("입력하신 실수는 %.12f입니다.\n", d1);

	(void)getchar();
	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}