#include <stdio.h>

/*
	�Լ� ȣ��
	�Լ� ����

*/
void bbb() {
	printf("5. bbb()�Լ� ����\n");
	printf("6. bbb()�Լ� ����\n");
}


void aaa() {
	printf("3. aaa()�Լ� ����\n");
	bbb();	// aaa()����  bbb() ȣ��
	printf("4. aaa()�Լ� ����\n");
}

int main()
{
	printf("1. main() �Լ� ����\n");

	aaa();	// main()���� aaa() ȣ��

	printf("2. main() ����\nENTER�� ������ �����մϴ�.\n");
	(void)getchar();
	return 0;
}

// �Լ� ȣ�� ����
// main -> aaa -> bbb

// �Լ� ���� ����
// bbb -> aaa -> main