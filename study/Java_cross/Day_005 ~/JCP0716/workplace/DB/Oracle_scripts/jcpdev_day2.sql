-- ���θ� : ���� ��ǰ�� ����
-- �� ���̺�(custom) ���� : �ʵ�(column) ������ �̸��� ������ ������ �߿�
CREATE TABLE custom# (
	-- �� ���̵�(���ڿ�, var: �������� char : ����  2 : ����), (�������ڵ� uft-8) 
	-- �� �̸�(���ڿ�)
	-- �̸���(���ڿ�)
	-- ����(����, number) 3�ڸ� *number : int, long, float, double ��� ����
	-- ���Գ�¥(��¥ Ÿ��)
	custom_id varchar2(20), -- ����Ʈ ����
	custom_name varchar2(20),
	custom_email varchar2(20),
	
	custom_age number(3),
	custom_reg_date date
);

-- ��ǰ(product) ���̺� : ��ǰ�ڵ�, ī�װ�(�ڵ�: 2�ڸ�), ��ǰ��, ����
--									  �� 00: ������ǰ, 10: ��ǰ, 20: ��Ȱ��ǰ...
CREATE TABLE product#(
	product_code varchar2(10),
	product_cartegory char(2), -- ī�װ��� �Һ��� �� => �׻� ���� ���� 2����Ʈ
	product_name varchar2(50),
	product_price number(9)
);

-- ����(buy)���̺� : �� who, ��ǰ what �����ߴ°�?
CREATE TABLE buy#(
	custom_id varchar2(20),	-- who
	product_code varchar2(10), -- what
	buy_quantity NUMBER(5), -- how many
	buy_date DATE -- when
);

-- insert DML ���� : ���̺� ���ο� ������ �߰�
-- insert into ��Ű���̸�.���̺��̸� (�ø�1, �÷�2...)
-- values (�÷�1 ��, �÷�2 ��...)
INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('sana0713','�糪','sana@naver.com',24,'2021-07-31');

INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('mina2012','��̳�','kim@gmail.com',20,'2020-05-21');

INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('nana2012','�質��','kim@gmail.com',20, '2020-05-21');

-- ��Ű�� �̸��� ������, ���� ����
INSERT INTO custom(custom_id) VALUES ('dayeon11');
INSERT INTO custom(custom_reg_date) VALUES ('2021-08-10');
INSERT INTO custom(custom_reg_date) VALUES (sysdate); -- ���� ��¥ : sysdate
INSERT INTO CUSTOM (custom_id, CUSTOM_NAME, CUSTOM_EMAIL)
			values('soon1234','������', 'test@daum.net');

-- ���ڿ� '', ��ġ ���� ��ȣ ���� �ۼ�
INSERT INTO CUSTOM (CUSTOM_AGE) VALUES (33);
		
-- ��� �÷� ���� �߰��� ��, ���̺� �̸� �ڿ� �÷� �̸����� ���� ����
INSERT INTO CUSTOM
		VALUES ('mina2012','��̳�','lee@gmail.com',20, '2020-05-21');

-- ���̺� ����� ������ ���� : update, delete
/*
 * update ���̺��̸� set �÷��̸�=�����Ұ�, �÷��̸�2=�����Ұ�2,,, [where ����];
 * */	
	
-- where ���� ���� UPDATE �� : ��� row�� ���� => �ſ� ����(�ٶ������� �ʴ�)
UPDATE CUSTOM SET CUSTOM_REG_DATE = SYSDATE;

UPDATE CUSTOM SET CUSTOM_AGE = 25 WHERE CUSTOM_ID = 'dayeon11';

-- name ���� null �� ��� name = '�մ�'���� UPDATE 
UPDATE CUSTOM SET CUSTOM_NAME = '�մ�' WHERE CUSTOM_NAME IS NULL;

-- custom_id�� null �ΰ�� 'guest'
UPDATE  CUSTOM SET CUSTOM_ID  = 'guest' WHERE CUSTOM_ID IS NULL;

-- age���� 20���� ������ age =99
UPDATE CUSTOM SET CUSTOM_AGE = 999 WHERE CUSTOM_AGE <= 20;

-- and(&&), or(||) --> ���� ������ �˻� (ex: 20���� ũ�� 30���� �۴�)
UPDATE CUSTOM SET CUSTOM_AGE = 30 WHERE CUSTOM_AGE < 25 AND CUSTOM_AGE >20;

-- ���� ���������� �˻� : --> in
UPDATE CUSTOM SET CUSTOM_AGE = 98 WHERE CUSTOM_AGE in(25, 33); -- age�� 25, 33 �� ���

UPDATE CUSTOM SET CUSTOM_AGE = '100' WHERE CUSTOM_AGE IS NULL;

-- set �ڿ� �������� �÷� ������ �� ����.
 UPDATE CUSTOM SET CUSTOM_AGE = 37, CUSTOM_NAME '�Ӹ�' WHERE ~

 -- DELETE ����
DELETE FROM CUSTOM; -- ���̺� ��� ������ ����
DELETE FROM CUSTOM WHERE CUSTOM_AGE = '999';

-- ��¥�� ���̺��� �����͸� ��� �����ϰ� �ʹٸ�...
TRUNCATE TABLE CUSTOM;

 -- Ư�� �÷��� ����
SELECT CUSTOM_ID, CUSTOM_AGE FROM CUSTOM;

-- �˻� ���ǿ� �´� Ư�� row --> where
-- �������� : 40�� �̸�
SELECT * FROM CUSTOM WHERE CUSTOM_AGE < 40;
SELECT * FROM CUSTOM WHERE CUSTOM_AGE IN(30, 98);
SELECT * FROM CUSTOM WHERE CUSTOM_AGE NOT IN(30, 98); -- NULL�� ����
-- �̸� ����
SELECT * FROM CUSTOM WHERE CUSTOM_NAME = '�մ�';
SELECT * FROM CUSTOM WHERE CUSTOM_NAME NOT IN('�մ�');

-- ���� �� : i�� mina�� �����ϴ� ������
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE 'mina%'; 
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE '%mina';  -- mina�� ������ ������
SELECT * FROM CUSTOM  WHERE CUSTOM_ID LIKE '%mina%' 
	ORDER BY CUSTOM_EMAIL DESC ; -- mina�� ���Ե� ������ �̸��� ��������
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE '%Mina%'; -- Mina�� ���Ե� ������(����)

-- dual ���̺� : � ���ѿ����� ��� ������ �ӽ� ���̺�
SELECT 22*23 AS RESULT FROM DUAL; -- AS �� ��Ī(RESULT) (AS�� ��������)
SELECT LOWER('MiNa') FROM DUAL ;	-- �ҹ��� ��ȯ
SELECT SYSDATE FROM DUAL ;

-- �����ִ� ���� ���ϱ� : order by �÷��̸� [asc || desc]
SELECT * FROM CUSTOM ORDER BY CUSTOM_NAME;
-- ���̰� ���� ������� ~ ���� ���
SELECT * FROM CUSTOM ORDER BY CUSTOM_AGE DESC;
SELECT * FROM CUSTOM ORDER BY CUSTOM_AGE DESC, CUSTOM_NAME ; 
				-- ���� ���� : ���� �������� -> (���� ����)�̸� ��������

SELECT * FROM CUSTOM;


/* ���̺� ���̿� ���� ������ ���̺� �� �÷��� �������� �䱸���� ���� �ʿ���
 *  ���� ����(contraints) --> �������� ���Ἲ ����
 *      �� not null
 * 		�� �⺻�� ���� : custom_reg_date, buy_date�� ���� ��¥��
 * 		�� ���� ���� : quantity(����)�� 1���� ū ��
 * 		�� ������ ��(unique) : custom_id, product_code (���̺��� ����ũ �÷��� 1�� �̻�)
 * 		�� �⺻Ű(primary key) : �˻�, rows �ĺ� column ǥ�� -> unique column ��
 * 							 : �⺻Ű�� 2�� �̻� �÷��� �׷�ȭ ����
 * 		�� �ܷ�Ű(foreign key) : ����Ű, �ٸ� ���̺��� �÷��� �����ϰ� �ִ�Ű
 * 				: buy ���̺��� custim_id�� custom ���̺� ����
 * 				: �������� �ߺ����� / �ϰ��� ������ ���� ���
*/