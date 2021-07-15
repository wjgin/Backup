#include <stdio.h>

// break, continue

// ��ȯ�� �ȿ��� break�� ������, �ڱ⸦ ���δ� ���� ����� ��ȯ�� ����.
// ��ȯ�� �ȿ��� continue�� ������, �ڱ⸦ ���δ� ���� ����� ��ȯ�� ���� ���ư�

int main()
{
	// break
	int i;
	for (i = 1; ;i++) {	// for������ ���ǽ� ���� ������ '��'
		
		if (i % 7 == 0) {
			break;
		}
		printf("i = %d\n", i);
	}
	
	printf("------\n");

	// continue
	i = 0;
	while (i <= 10) {
		i++;
		if (i % 2 == 0)  continue;
		printf("i = %d\n", i);
	}
	
	printf("------\n");
	
	// ������(�� ���� ���� ��ŭ�� ����)
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			if (j > i) break;
			printf("%d x %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}

	printf("------\n");
	
	// ������(�� ���� ���� ���� ��¾���)
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			if (i > j) continue;
			printf("%d x %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}
	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}