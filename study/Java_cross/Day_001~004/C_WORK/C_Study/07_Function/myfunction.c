// 함수 정의 파일
int power(int base, int exp)
{
	int result = 1;
	for (int i = 0; i < exp; i++) {
		result *= base;
	}
	return result;
}

double doubleUp(double num) 
{
	return num * 2;
}