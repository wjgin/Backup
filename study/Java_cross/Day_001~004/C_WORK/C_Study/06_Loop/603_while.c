#include <stdio.h>

/*
* ���ǽ��� '��' �� ���� while �� �ݺ�
*
*	while(���ǽ�){
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
										  
	// for <--> while ���� 100% ��ȯ ����	  
	// while ���� �̿��� ������ 2��		
	int n = 1;							  
	while (n <= 9) {					  
		printf("2 x %d = %d\n", n, n * 2);
		n++;
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}