#include <stdio.h> // 표준입출력 (standard input/output) 헤더(header)
                   // printf() 등의 함수를 사용할수 있게 한다.

// 한줄 주석 (line comment) : 코드 실행과는 관계 없음. 메모를 남길 수 있다.

/*
	블럭주석 (block comment)
	이 영역의 내뇽은 주석으로 처리됨.
*/

int main() // main() 함수,  C  프로그램의 시작점
{
	// main()함수 부터 시작
	// 문장을 하나하나 차례로 실행한다.
	
	// printf("화면에 출력할 내용")
	printf("Hello World\n");	// 명령(문장:  statement). 문장의 끝은 반드시 세미콜론(;)으로 마무리
	printf("안녕하세요\n");	// \n 출바꿈 문자
	printf("C언어\n");
	getchar();	// 키 입력 전 까지 결과창 대기 용도로 사용


	//  main() 함수가 끝나면 프로그램 종료
}

// 블럭 { .. } 
// 괄호 ( .. ) 
// 따옴표 " .. " 
//   이들의 쌍이 맞아야 한다.