#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	// TODO
	int n;
	(void)scanf("%d", &n);
	
	switch(n)
	{
		case 1 :
			printf("Number? dog");
			break;
		case 2:
			printf("Number? cat");
			break;
		case 3:
			printf("Number? chick");
			break;
		default:
			printf("Number? I don't know.");
			break;
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}