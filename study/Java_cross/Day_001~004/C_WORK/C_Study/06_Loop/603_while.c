#include <stdio.h>

/*
* 조건식이 '참' 인 동안 while 블럭 반복
*
*	while(조건식){
*		..
*		..
*	}
*
*/


int main()
{
	int i = 0;
	while (i < 5) {
		printf("i = %d\n", i);
		i++;
	}									  
										  
	// for <--> while 구문 100% 전환 가능	  
	// while 문을 이용한 구구단 2단		
	int n = 1;							  
	while (n <= 9) {					  
		printf("2 x %d = %d\n", n, n * 2);
		n++;
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}