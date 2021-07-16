#include <stdio.h>
#include <string.h>
/*
*	문자열의 길이(문자의 개수)를 반환
*		strlen(문자열포인터);
*		strlen(문자배열);
*
*	문자열 비교 결과를 반환
*		strcmp(문자열1, 문자열2);
*		int strcmp(char const *_Str1, char const *_Str2);
*
*		-1: ASCII 코드 기준으로 문자열2(s2)가 클 때
*		0: ASCII 코드 기준으로 두 문자열이 같을 때
*		1: ASCII 코드 기준으로 문자열1(s1)이 클 때
*
*	문자열 복사
*		strcpy(대상문자열, 원본문자열);
*		char *strcpy(char *_Dest, char const *_Source);
*		대상문자열의 포인터를 반환
*
*	문자열 붙이기
*		strcat(최종문자열, 붙일문자열);
*		char *strcat(char *_Destination, char const *_Source);
*		최종 문자열의 포인터를 반환
*
*	문자열 안에서 '문자'로 검색
*		strchr(대상문자열, 검색할문자);
*		char *strchr(char * const _String, int const _Ch);
*		문자를 찾았으면 문자로 시작하는 문자열의 포인터를 반환, 문자가 없으면 NULL을 반환
*
*	문자열 안에서 '문자열'로 검색
*		strstr(대상문자열, 검색할문자열);
*		char *strstr(char * const _String, char const * const _SubString);
*		문자열을 찾았으면 문자열로 시작하는 문자열의 포인터를 반환, 문자열이 없으면 NULL을 반환
*
*  문자열 대소문자 변환
*		strupr(대상문자열)  : 주어진 대상문자열을 전부 대문자로 변환
*		strlwr(대상문자열)  : 주어진 대상문자열을 전부 소문자로 변환
*       원본문자열 변화됨 (주의!)
*/

int main()
{
	char* s1 = "Hello";	// 포인터 s1에 문자열 "Hello"의 주소 저장
	char s2[10] = "Hello";	// 길이가 10인 char[]을 선언하고 문자열 초기화

	printf("s1 = %s, s2 = %s\n", s1, s2);

	// s1[0] = 'K';	// 불가 직접 입력한 "Hello"는 직접 입력한 리터럴 상수 => 변경 불가
	s2[0] = 'K';
	printf("s1 = %s, s2 = %s\n", s1, s2);
	
	// 문자열의 길이 strlen()
	{
		printf("%d\n", strlen(s1));	// null문자를 제외한 문자의 길이 출력
		printf("%d\n", strlen(s2));
	}

	// 문자열 비교 strcmp()
	{
		int ret = strcmp(s1, s2);	// "Hello" < "Kello" => -1 리턴
		printf("%d\n", ret);
	}

	// 문자열 복사 strcpy()
	
	{
		char s1[10] = "Hello";
		// s1 = "bye"  불가능 / s1은 리터럴 상수
		char s2[10];

		printf("strcpy() 전 s2 = %s\n", s2);

		strcpy(s2, s1);	// s1을 s2에 복사
		printf("strcpy() 후 s2 = %s\n", s2);

		// 주의
		char* s1 = "Hello";
		char* s2 = "";
		// strcpy(s2, s1); // 불가능 상수의 주소를 가르키는 포인터 => 상수 값 변경 불가
	}
	

	// 문자열 연결 strcat()	string concatenation
	{
		char s1[10] = "world";
		char s2[10] = "Hello";

		strcat(s2, s1);	// s2뒤에 s1을 붙인다.	s2의 null문자 위치에서부터 이어붙힘
		printf("%s\n", s2);
	}
	
	// 문자열 안에서 문자로 검색 strchr()
	{
		char s1[30] = "A Garden Diary";
		char* ptr = strchr(s1, 'a');

		if (ptr) {
			printf("찾았다. %p\n", ptr);
			printf("%d 위치에서 찾았다. %p\n", ptr - s1, ptr);
		}
		else {
			printf("없다. \n");
		}

		// 모두 찾기
		while (ptr != NULL) {
			printf("%d 번째에서 발견 %s\n", ptr - s1, ptr);
			ptr = strchr(ptr + 1, 'a');
		}
	}

	// 문자열 안에서 문자열로 검색
	{
		char s1[30] = "A Garden Diary";
		char *ptr = strstr(s1, "den");	// 문자열 s1에서 "den"을 검색
		if (ptr) {
			printf("strstr()발견 %d번 째, %s\n", ptr - s1, ptr);
		}
		else {
			printf("strstr()발견 못함\n");
		}
	}

	// 문자열 대소문자 변환 strupr(), strlwr()
	// 원본 문자열의 변화
	{
		char s1[30] = "A Garden Diary";
		printf("strupr(s1) => %s\n", strupr(s1));
		printf("strlwr(s1) => %s\n", strlwr(s1));
	}

	printf("\nENTER을 누르면 종료합니다.\n");
	getchar();
	return 0;
}