/*
SQL ����(select) ���� ����

1. custom# ���̺��� age �� 25�� �̻� ��ȸ
2. custom# ���̺��� custom_id 'momo' �� email ��ȸ
3. product# ���̺��� category '12' �� pname ��ȸ
4. product# ���̺��� price �� �ְ� ��ȸ
5. product# ���̺��� category '10' �� ���� ��ȸ
6. buy# ���̺��� custom_id 'nayeon' �� ��� ���� ��ȸ
7. buy# ���̺��� pcode �� 'LG'�� �����ϴ� �� ��ȸ
8. buy# ���̺��� cusom_id 'momo' �� ������ ��ǰ�� �̸��� ���� ��ȸ(�������� ���)

*/
-- 1
SELECT * FROM "CUSTOM#" WHERE CUSTOM_AGE >=25;
-- 2
SELECT CUSTOM_EMAIL FROM "CUSTOM#" WHERE CUSTOM_ID = 'momo';
-- 3
SELECT PRODUCT_NAME FROM "PRODUCT#" WHERE PRODUCT_CARTEGORY = 12;
-- 4
SELECT MAX(PRODUCT_PRICE) max_price FROM "PRODUCT#";
-- 5
SELECT count(*)Cnt_category10 FROM "PRODUCT#" WHERE PRODUCT_CARTEGORY = 10;
-- 6
SELECT * FROM "BUY#" WHERE CUSTOM_ID = 'nayeon';
-- 7
SELECT * FROM "BUY#" WHERE PRODUCT_CODE LIKE 'LG%';
-- 8
SELECT PRODUCT_NAME, PRODUCT_PRICE FROM "PRODUCT#" WHERE PRODUCT_CODE = (SELECT PRODUCT_CODE FROM "BUY#" WHERE CUSTOM_ID = 'momo'); 
-- 8. ������ �����Ͱ� 2�� �̻��̶�� = �� ����� �� ����. => IN �����ڸ� ����ؾ���
SELECT PRODUCT_NAME, PRODUCT_PRICE FROM "PRODUCT#" WHERE PRODUCT_CODE IN (SELECT PRODUCT_CODE FROM "BUY#" WHERE CUSTOM_ID = 'nayeon'); 


-- <<Join>>
-- ���� ����(���� ����) : �� ���� ���̺��� �����ؼ� ���̺� ������ �ʿ��� ���� ���� �� �� ����

-- 1) from [���̺�1, ���̺�2] WHERE [���̺�1.�ߺ� �÷�] = [���̺�2.�ߺ� �÷�]
SELECT * FROM "BUY#", "PRODUCT#" WHERE buy#.PRODUCT_CODE  = product#.PRODUCT_CODE; -- �⺻ ����

-- ���̺��, �÷��� alias(��Ī) ���� ���� -> �ڵ��� ����ȭ
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE; -- ���� �� Ư�� �÷��� ��ȸ

SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY 
		FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

-- buy# ���̺��� pcode ������ price�� �˰�ʹ�. pcode = 'MU98' => �������� AND �߰�����
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY AS total
		FROM BUY# b, "PRODUCT#" p  -- ���̺���� AS�� ����ϸ� ����
		WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE AND b.PRODUCT_CODE = 'MU98';

-- buy# ���̺��� �� buy_no ���� ���� �ݾ� ��� : price * quantity
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY total
		FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

-- 2) ���ΰ�� �׷�ȭ with �� �̿� 
--	�� ���� �� ���űݾ� -> sum(total)
WITH sale AS ( -- �ӽ� ���̺� -> �� �� �� ���
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total -- 1ȸ�� ����ϴ� select���(�ζ��� ��)
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE
) 
SELECT CUSTOM_ID, sum(total) FROM sale GROUP BY CUSTOM_ID ;

-- 	�� ��ǰ�� �� �Ǹűݾ�	-> sum(total)
WITH sale AS ( -- �ӽ� ���̺� -> �� �� �� ���
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE
) 
SELECT p_code, sum(total) FROM sale GROUP BY p_code;


-- 3) view Ȱ�� : ���� ���̺� => ���� ������� x
-- CREATE, DROP view�� ����
-- �������� ������ ������ ���������� �� ������� ����(������ ��ȸ ��)
CREATE VIEW v_slae
AS 
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

SELECT * FROM V_SLAE; 

select * from role_sys_privs where role='RESOURCE';  -- �ý������̺�(������ ����)


-- outer join : �ܺ�����(+) ���� ��ȣ ǥ��
-- �������� ���������� �������� �ʴ� ��鵵 ���ΰ���� ���� ��Ŵ
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ; -- ��������(equal)
DELETE FROM "BUY#" b WHERE CUSTOM_ID = 'momo';
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ; -- 'momo' ������ ������ �ʰԉ�

-- cutom# table ���� momo�� �ְ� buy# table���� momo�� ����(���� ����) -> �����ؼ� ���� => outer join
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID; -- b�� ��� ǥ��

-- nvl(column, null�� ��� ǥ���� value)
SELECT c.CUSTOM_ID AS id , c.CUSTOM_AGE , NVL(PRODUCT_CODE, '���� ����') AS "���� �ڵ�", NVL(BUY_QUANTITY, 0) "���� ����"
FROM "BUY#" b , "CUSTOM#" c WHERE b.CUSTOM_ID(+)  = c.CUSTOM_ID;
