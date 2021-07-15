#include <stdio.h>

// ����Ÿ�� �Լ��̸�(�Ű�����..)
// ���ϰ� : �Լ��� �ڱ⸦ ȣ���� �Լ��� �� 1���� �����ټ� �ִ�. 
//          �̸� ���ϰ�(return value) �� ��
// �Ű�����(argument)
//      �Լ��� ȣ���ϴ� �ʿ��� �Ѱ��ִ� ���� ���� ����.
//      (Ÿ�� ������, Ÿ�� ������...) ����

// �Լ��̸� : add
// �Ű����� : int, int
// ���ϰ� : int (�� �Ű������� ������ ����� ����)

int add(int a, int b) {
	int sum = a + b;
	return sum;	// return �� : �Լ� �����ϰ� ȣ���� ������ ���� ������
}

// �Լ��̸� : sub
// �Ű����� : int, int
// ���ϰ� : int  (�� �Ű������� �� ����� ����)

int sub(int a, int b) {
	return a - b;
}

void mul(int a, int b) {
	printf("mul() ȣ��\n");
	return;	// �Լ� ���� �߿� return�� ������ �ٷ� ����, ����
	printf("%d x %d = %d\n", a, b, a * b);
	// ������ ���� ������ return�� ��� ���ص� �ڵ����� return �ȴ�.
}

// �Լ� ���� (function declaration)
// �Լ� ���ǰ� ȣ��� ���Ŀ� �ְų�, Ȥ�� �ٸ� ���Ͽ� �ִ� ���
// �̸� �Լ� ������ ���־� ������ ������ ��.
// �Լ����𱸹�
//     ����Ÿ�� �Լ��� (�Ű����� ...);    <-- �Լ��� ������Ÿ��(����: prototype) �̶�� ��

double half(double);	// �Լ� ����� �Ű��������� ���� ���� 

int main()
{
	int result = add(100, 40);
	printf("result = %d\n", result);
	printf("40 + 30 = %d\n", add(40, 30));
	printf("40 - 30 = %d\n", sub(40, 30));

	result = add(add(10, 20), sub(40, 80));
	printf("result = %d\n", result);
	
	mul(40, 30);

	printf("41�� 2�� ���� ����� %.1lf\n", half(41));

	



	printf("\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;	// �ý����� �����Լ��� ȣ���ϰ� 0�� �������� / ���� ������ �ڵ� ���� 0
}

// C���� 
// �Լ� ȣ��(���)�ϱ� ���� ��.��.�� ���� '����' �Ǿ� �ְų� Ȥ�� '����' �Ǿ� �־�� �Ѵ�.

double half(double arg) {
	return arg / 2;
}