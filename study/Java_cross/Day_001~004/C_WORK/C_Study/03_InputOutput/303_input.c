#include <stdio.h>
#pragma warning(disable:4996)

/*

*/

int main()
{
	float height, weight;
	printf("Ű�� �Է¼���(cm) : "); 
	(void)scanf("%f", &height);	// %f, Ű����κ��� �Ǽ� �Է� �޾Ƽ� float���� ����
	
	printf("ü���� �Է¼���(kg) : ");
	(void)scanf("%f", &weight);

	printf("Ű  : %.1fcm ü��: %.1fkg\n", height, weight);

	double d1;
	printf("�Ǽ��� �Է��ϼ��� :");
	// (void)scanf("%f", &d1);	// double Ÿ�� �Է� ���� ���� %lf ���
	(void)scanf("%lf", &d1);
	printf("�Է��Ͻ� �Ǽ��� %.12f�Դϴ�.\n", d1);

	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}