#include <stdio.h>
#pragma warning(disable:4996)
/*

*/

int main()
{
	// for 무한루프
	// for (;;) {..}

	// while 무한루프
	//while (1) { ..}

	// 사용자로부터 정수를 계속 입력받다가
	// 0 이 입력되면 종료하고.
	// 그동안 입력받았던 점수의 '개수' 와 '합' 을 출력하세요.

	int count = 0;  // 개수
	int sum = 0;  // 합계

	while (1) {		// 무한루프
		int n;
		(void)scanf("%d\n", &n);

		// 무한루프의 종료조건
		if (n == 0) {
			//(void)getchar();
			break;
		}
		
		// 종료상황이 아니면
		count++;
		sum += n;
	}

	printf("개수: %d개\n", count);
	printf("합: %d개\n", sum);

	printf("\nENTER을 누르면 종료합니다.\n");
	(void)getchar();
	return 0;
}