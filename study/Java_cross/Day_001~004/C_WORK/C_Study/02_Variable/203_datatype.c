#include <stdio.h>

/*
*	C����� ������ Ÿ��
*
*	 char : 1byte, �����ϳ�(����)
*	 short : 2byte  ����
*	 int  : 4byte   ����
*	 long : 4byte   ���� (�ý��۸��� �ٸ�)
*	 float : 4byte  �Ǽ�
*	 double : 8byte �Ǽ�
*
*/

int main()
{
	printf("������ Ÿ�� \n");

	// ����Ÿ�� ����
	int i = 0;	// 4byte
	int a = 100, b = 200, c = 300;	// ���� 4byte

	short s1, s2, s3, s4 = 300;	//  ���� 2byte
	long l1, l2 = 10000, l3;

	char c1, c2 = 100;
	
	//  ���� Ÿ�� ����
	char ch1;	// 1byte (8 bit), 256�� ǥ�� ������ �뷮
	ch1 = 'a';	// Ȭ ����ǥ
				// 'a' ������ �ڵ尪(����)�� ch1 �� ����
				// char �����ϳ� --> Ȧ����ǥ ���

	// ASCII code
	printf("ch1 = %d\n", ch1);	// 'a'�� �ڵ� �� => 97
	printf("ch1 = %c\n", ch1);	// %c�� ����(�ϳ�)�� ���
	printf("ch1 = %c\n", 98);	// 'b' => 98
	printf("ch1 = %c\n", ch1 + 2);	// 'c' => 99


	// printf�� ���˹��ڿ� �ȿ� ���� ����������(format specifier) ��
	// %d : 10���� ������ ���
	// %c : ���ڷ� ���
	// %f : �Ǽ��� ���
	// %x : 16���� ������ ���
	// %% : % ���

	printf("%d, %x, %c\n", 65, 65, 65);

	{
		// ����Ÿ��, �뷮�� ����
		// 1byte / 8bit = 2�� 8�� = 256��(����)
		//       0 ~ 255 ���� ������ �ִ� �뷮

		// char : -128 ~ +127
		// short : -32768 ~ +32767
		// int : -2,147,483,648~ 2,147,483,647

		char ch2 = 127;
		printf("ch2 = %d\n", ch2);

		ch2 = 128;
		printf("ch2 = %d\n", ch2);

		ch2 = 129;
		printf("ch2 = %d\n", ch2);
	
		ch2 = 200;
		printf("ch2 = %d\n", ch2);

		// ����Ÿ���� ������ �����÷ο�(overflow), ����÷ο�(underflow) �߻�
		// https://dojang.io/pluginfile.php/75/mod_page/content/34/unit7-2.png
	}

	{
		// singend(��ȣ�� �ִ�) vs. unsigned(��ȣ�� ����) Ÿ��
		signed char ch1 = 200;	// char ch1�� ����, signed �Ϲ������� ����
		unsigned char ch2 = 200;	// 0 ~ +255���� ǥ��

		printf("ch1 = %d\n", ch1);
		printf("ch2 = %d\n", ch2);

		unsigned short s2;	// 0 ~ 65535
		unsigned int i2;	// 0 ~ 4.2��

		// �� ���� �뷮�� ������ ������ Ÿ���� ? ==> �뷮 ==> ���.
	}

	{
		// �Ǽ� Ÿ��
		float f1 = 3.141592;	// 4byte
		double d1 = 3.141592;	// 8byte

		printf("f1 = %f\n", f1);
		printf("d1 = %f\n", d1);

		printf("f1 = %.2f\n", f1);	// %.2f �Ҽ��� 2�ڸ����� ���(���� �ݿø�)
		printf("d1 = %.4f\n", d1);
	}

	{
		// �Ǽ� Ÿ�Կ����� �뷮�� ����
		// ���е�(precision)�� ���̰� �ִ�
		// float : �Ҽ��� 6 ~ 9 �ڸ�
		// double : �Ҽ��� 15 ~ 18�ڸ�
		float f2 = 0.0123456789;
		double d2 = 0.0123456789;

		// %f�� ����ϸ� �⺻������ �Ҽ��� 6�ڸ����� ���
		printf("f2 = %f, d2 = %f\n", f2, d2);

		printf("f2 = %.10f, d2 = %.10f\n", f2, d2);
	}
	printf("ENTER�� ������ ���� �˴ϴ�.");
	getchar();
	return 0;
}