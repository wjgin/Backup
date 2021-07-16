#include <stdio.h>

/* �迭�� ���ڿ�(string)
*	 - C��� ���� "���ڿ�" �� ��ü�� 'char [] �迭' �̴�
*	 - C����� "���ڿ�"��
*		  ���� '\0' (null ����) �� ������ 'char [] �迭' �̴�
*/

int main()
{
	char str1[20] = "nice";	// 'n' 'i' 'c' 'e' '\0'	: 5byte		// ��ü�� 20byte

	printf("str1 = %s\n", str1);	// %s -> char�迭���� '\0' ���������� ���
	// str1 Ÿ����? => char[]
	// str1[0] Ÿ���� ? => char
	for (int i = 0; i < 4; i++) {
		printf("str1[%d] = %c\n", i, str1[i]);
	}

	// char str2[] = { 'n', 'i', 'c', 'e' };	// null ���ڰ� ���⿡ ��� ���(����)
	char str2[] = { 'n', 'i', 'c', 'e', '\0'};
	printf("str2 = %s\n", str2);	

	char str3[] = "nice";	// ���� 5�� ���ڿ� ���� �ڿ� null ���� �߰�
	printf("str3 = %s\n", str3);
	printf("str3 size = %d\n", sizeof(str3)); // 5byte

	str1[0] = 'D';
	printf("str1 = %s\n", str1);

	// str2[4] = '#';	// ���ڿ� �ǳ��� '\0' ���� ���� �ϸ�, %s ��½� �����Ⱚ ��µȴ�



	printf("\nENTER�� ������ �����մϴ�.\n");
	getchar();
	return 0;
}