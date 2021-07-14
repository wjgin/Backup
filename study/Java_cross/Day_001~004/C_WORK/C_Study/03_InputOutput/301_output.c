#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

/*

*/

int main()
{
	// printf: print에 서식 지원(format)
	// 최대 20개의 문자로 구성된 문자열을 담을 수 있는 str1 선언
	char str1[20] = "C Language";
	printf("str1 = %s\n", str1);

	// 선언한 문자열 만큼의 공간을 갖는 str2 선언
	char str2[] = "Java Language";	// 자동적으로 초기화 문자열의 문자의 개수만큼
	printf("str2 = %s\n", str2);

	// 포인터 사용
	char *str3 = "Python Language";
	printf("str3 = %s\n", str3);

	// -----------------------------
	// 폭 서식 지정자
	int a = 10, b = 123, c = 4567;
	printf("|%d|%d|%d|\n", a, b, c);
	printf("|%5d|%5d|%5d|\n", a, b, c);	// 5칸에 맞추어 출력(기본 우측 정렬)
	printf("|%-5d|%-5d|%-5d|\n", a, b, c);	// 좌측 정렬

	printf("|%s|\n", str1);
	printf("|%20s|\n", str1);

	printf("|%.6f|\n", 0.0123456789);	 // 소숫점 6자리까지 출력(반올림)
	printf("|%20.6f|\n", 0.0123456789);  // 전체 20자리, 소숫점 이하는 6자리

	//-------------------------------------
	// escape 문자
	// 문자열 안에서 (" ~ "  안에서) 사용하는 특수한 기능을 하는 문자 
	//  \  (back slash) 로 시작함
	//
	//  \n   : 줄바꿈
	//  \t   : 탭
	//  \"   : 쌍따옴표
	//  \\   : \ 출력
	//  \0   :  널(null) 문자

	printf("%d\t%d\t%d\n", 10, 20, 30);			// 출력글자를 포함해 8칸을 차지(윈도우 시)
	printf("%d\t%d\t%d\n", 1000, 2000, 3000);
	printf("%d\t%d\t%d\n", 10000, 20000, 30000);

	// say "hi"
	printf("say \"hi\"\n");

	// \\은 문자열 안에서 \출력하기 위한 ESC문자 입니다.
	printf("\\\\은 문자열 안에서 \\출력하기 위한 ESC문자 입니다.");

	printf("\nENTER을 누르면 종료합니다.\n");
	(void) getchar();	// C6031 반환 값이 무시되었습니다. 없애기 위해 void 추가
	return 0;
}