-- java�� ���� sql �׽�Ʈ

-- ����� ��Ͻ� �̹� �����ϴ� id�� �Է����� ��,
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID = 'nana'; -- ���̵� ������ ��, ���� �� 1 
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID = 'nana2'; -- ���̵� �������� ���� ��, ���� �� 0
 
SELECT * FROM CUSTOM# WHERE CUSTOM_ID = 'nana'; -- ���̵� ������ ��, ROW 1��	NOT null
SELECT * FROM CUSTOM# WHERE CUSTOM_ID = 'nana2'; -- ���̵� �������� ���� ��, ROW  0��		NULL
--			�� java���� ��ȸ ����� null Ȯ��

UPDATE "CUSTOM#" SET CUSTOM_REG_DATE = SYSDATE ;