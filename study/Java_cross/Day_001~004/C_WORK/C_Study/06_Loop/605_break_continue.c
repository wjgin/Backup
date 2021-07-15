#include <stdio.h>

// break, continue

// 순환문 안에서 break를 만나면, 자기를 감싸는 가장 가까운 순환문 종료.
// 순환문 안에서 continue를 만나면, 자기를 감싸는 가장 가까운 순환문 으로 돌아감

int main()
{
	// break
	int i;
	for (i = 1; ;i++) {	// for문에서 조건식 비우면 무조건 '참'
		
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
	
	// 구구단(각 단의 숫자 만큼만 곱셈)
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			if (j > i) break;
			printf("%d x %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}

	printf("------\n");
	
	// 구구단(단 보다 작은 수는 출력안함)
	for (int i = 2; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			if (i > j) continue;
			printf("%d x %d = %d\n", i, j, i * j);
		}
		printf("\n");
	}
	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}