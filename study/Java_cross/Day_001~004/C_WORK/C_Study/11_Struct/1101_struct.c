#include <stdio.h>
#include <string.h>

/*
*	����ü (struct)
*		�������� �����͵� (���) �� ������ ����� ���� �ڷ���
*
*
*	�л��� ������
*		-�й� : char[]
*		-�̸� : char[]
*		-���� : unsigned char  (0 ~ 255)
*		-�г� : unsigned char
*		-���� : 'M', 'F'  char
*		-Ű : 173.4  float
*		...
*/

// ����ü poit ����
struct point {
	// ���������(member variable) ����
	int x;
	int y;

};


int main()
{
	// point ����ü Ÿ���� ���� ����
	struct point p1;

	// ��� ������( . )�� ����Ͽ� ����ü ��� ���
	p1.x = 100;
	p1.y = 200;

	printf("p1 = (%d, %d)\n", p1.x, p1.y);

	// person ����ü ����
	struct person {
		char name[20];	// �̸�
		int age;		// ����
		double weight;	// ������
	};

	struct person p2;
	p2.age = 32;
	p2.weight = 54.7;
	strcpy(p2.name, "ȫ�浿");	// �迭�� ������ ����̹Ƿ� ���� �Ұ�	/ �Լ� ���
	printf("�̸� : %s, ���� : %d, ������ : %.1f\n", p2.name, p2.age, p2.weight);

	// ����ü ����� ���ÿ� �ʱ�ȭ
	struct person p3 = { "���̾��", 48, 87.663 };
	printf("�̸� : %s, ���� : %d, ������ : %.1f\n", p3.name, p3.age, p3.weight);


	
	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}