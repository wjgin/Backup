#include <stdio.h>
#pragma warning(disable:4996) // scanf() ��� ���� ���� ����

/*
// �Է�: (input) - Ű����(�⺻ standard input), ���콺, ��Ʈ��ũ, ����...
// ���: (output) - �����(�⺻ standard output), ������, ��Ʈ��ũ, ����...
*/

int main()
{
	printf("scanf() �Է�\n");

	int kor, eng, math;
	printf("���� ������ �Է� �ϼ���. :");
	(void)scanf("%d", &kor);	// Ű����κ��� ���� �Ѱ� �Է� -> kor ������ ����
						// ���� ���� ������ �տ��� & ���̱�

	printf("���� ������ �Է� �ϼ���. :");
	(void)scanf("%d", &eng);

	printf("���� ������ �Է� �ϼ���. :");
	(void)scanf("%d", &math);


	printf("�Է��� ������ %d, %d, %d �Դϴ�. \n", kor, eng, math);

	// ������ ��� ���ϱ�
	int total = kor + eng + math;
	printf("������ : %d��\n", total);

	// float avg = total / 3;	// ������ ������ �������� '����' �Ʒ��ڸ� �Ҽ��� ���ŵ� 
	// float avg = total / 3.0;	// �Ǽ��� ����� ���ؼ� �ϳ� �̻��� �Ǽ������� �����Ѵ�.
	float avg = (float)total / 3;	// ����ȯ������ ����Ͽ�  total�� float Ÿ������ ����

	printf("����� : %.1f��\n", avg);

	(void)getchar();
	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}