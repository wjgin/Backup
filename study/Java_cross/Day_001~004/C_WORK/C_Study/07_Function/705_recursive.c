#include <stdio.h>

/*
*	���ȣ�� (Recursive Call)
*	- �Լ��� �����߿� �ڽ��� �ٽ� ȣ���ϴ� ��.
*   - ������ ������ �ܼ�ȭ�Ͽ� �����ϴ� ����
*	- ������ ���ȣ���� �Ұ�
*	- ȣ�� ���� ������
*/

// n! = n * (n - 1) * (n - 2) * ...  * 1
//	  = n * (n - 1)! <- factorial�� factorial�� ����

int fac(int n) {
	if (n == 0) return 1;	// 0! == 1
	return n * fac(n - 1);	// ��� ȣ��
}
		

int func1(int n) {
	printf("func1(%d) ȣ��\n", n);

	return func1(n + 1);
	}

int main()
{
	// func1(1);  // ���� ����Լ� ����� stackOverflow �߻�

	int n = 5;
	printf("%d = %d\n", n, fac(n));

	/*
	factorial(5)
		��  5 * factorial(4)
				��  4 * factorial(3)
						��  3 * factorial(2)
								��  2 * factorial(1)
										��  1 * factorial(0)
	*/

	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}