#include <stdio.h>
#pragma warning (disable: 4996)
/*

*/

int main()
{
	float score;
	scanf("%f", &score);
	int s = (int)score;

	switch (s)
	{
	case 4:
		printf("scholarship");
		break;
	case 3:
		printf("next semester");
		break;
	case 2:
		printf("seasonal semester");
		break;
	default :
		printf("retake");
	}

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}