-- CUSTOM# TABLE
CREATE TABLE custom# (
	custom_id varchar2(20) NOT NULL, -- ����Ʈ ����
	custom_name varchar2(20),
	custom_email varchar2(20),
	custom_age number(3),
	custom_reg_date DATE,
	CONSTRAINT CUSTOM#_PK PRIMARY KEY (CUSTOM_ID)
);
ALTER TABLE custom# RENAME CONSTRAINT CUSTOM_id_PK TO CUSTOM#_PK;

-- PRODUCT# TABLE
CREATE TABLE product#(
	product_code varchar2(10) NOT NULL,
	product_cartegory char(2), -- ī�װ��� �Һ��� �� => �׻� ���� ���� 2����Ʈ
	product_name varchar2(50),
	product_price number(9),
	CONSTRAINT PRODUCT#_PK PRIMARY KEY(PRODUCT_CODE)
);
-- ���� ������ �߰��ϴ� ���
ALTER TABLE PRODUCT# ADD CHECK (PRODUCT_price > 0); -- ���������� �̸� ����
ALTER TABLE PRODUCT# ADD CONSTRAINT price_check CHECK (PRODUCT_price > 0); -- ���� ���� �̸� ����

-- BUY# TABLE
CREATE TABLE buy#(
	buy_no number(9) NOT NULL ,
	custom_id varchar2(20) NOT NULL,-- .�ܷ�Ű => �������Ἲ�� ���ؼ� �ݵ�� ���� �ʿ�
	product_code varchar2(10) NOT NULL,-- what
	buy_quantity NUMBER(5), -- how many
	buy_date DATE DEFAULT sysdate, -- WHEN
	CONSTRAINT BUY#_PK PRIMARY KEY(BUY_NO),
	CONSTRAINT BUY#_CUTOM#_FK FOREIGN KEY(CUSTOM_ID) REFERENCES CUSTOM#(CUSTOM_ID),
	CONSTRAINT BUY#_PRODUCT#_FK FOREIGN KEY(product_code) REFERENCES PRODUCT#(PRODUCT_CODE)
);

ALTER TABLE BUY# DROP PRIMARY KEY;
ALTER TABLE BUY# ADD CONSTRAINT buy#_pk PRIMARY KEY(buy_no);
ALTER TABLE BUY# MODIFY (buy_date DATE DEFAULT sysdate); 

INSERT INTO CUSTOM#(custom_id, custom_name, custom_email, custom_age) VALUES ('dahyeon',	'�����',	'da@naver.com',	33)	;
INSERT INTO PRODUCT# VALUES ('MU98',	12,	'USB 1TB',	14000);

-- buy# INSERT 
CREATE SEQUENCE buy#_seq;
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'jungYu', 'H49452', 1);
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'momo', 'MU98', 3);
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'dahyeon', 'ACH991', 3);
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'nayeon', 'MU98', 2);				
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'dahyeon', 'ACH991', 3);				
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'jungYu', 'LG98T2', 2);				
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'nayeon', 'LG98T2', 2);				
INSERT INTO BUY# (buy_no, CUSTOM_ID, PRODUCT_CODE, BUY_QUANTITY) VALUES (buy#_seq.nextval, 'jungYu', 'ACH991', 2);

SELECT * FROM BUY#;

-- ����Ŭ ������ ���̽� ��ü :  ������ - ������: n~m���� +- k ��� ����(nextval)
--							�� �������� ���� �ǵ��� �� ���� => drop �� ����� �ʿ�
CREATE SEQUENCE test_seq; -- n�� 1����, k�� +1�� ���(�⺻ ��)
CREATE TABLE tblseq# (
	 column1 number(3)
);
INSERT INTO tblseq#(column1) values(test_seq.nextval);
-- ������ ����
DROP SEQUENCE buy#_seq;
-- ������ ������ (9���� 1�� ����)
CREATE SEQUENCE buy#_seq
	INCREMENT BY 1
	START WITH 9;
-- ������ Ȯ��(��ü ������)
SELECT * FROM USER_SEQUENCES;
-- ���� ������ �� ��ȸ(��ȸ�� �ȵɶ� nextval�� �ѹ��� ���� ��ȸ���ְ� Ȯ�� : ù ��ȸ�� �� ���� �ȵ�)
SELECT buy#_seq.currval FROM DUAL;
-- ���̺� ������ ����
TRUNCATE TABLE TBLSEQ#; 

SELECT * FROM TBLSEQ#;

-- buy# ���̺� ��¥ ������ ����
UPDATE BUY# SET BUY_DATE = SYSDATE;
SELECT * FROM "BUY#";


/*
CUSTOM ���̺�				
				
custom_id	name	email	age	reg_date
nayeon	�ӳ���	na@korea.com	25	
jungYu	������	jung@daum.net	27	
momo	�����̸��	momo@gmail.com	24	
dahyeon	�����	da@naver.com	33	
				
				
				
PRODUCT ���̺�				
pcode	   category	       pname         price	
SAV1245-01	  10	     ����ũ û�ұ�   	176000	
ACH991	      11	     �����е����� 5	    270000	
H49452	      12	     ������������	     90400	
LG98T2	      10	     ��Ʈ��	        392300	
MU98	      12	     USB 1TB	     14000	
				
				
Buy ���̺�				
buy_no	custom_id	pcode	quantity	buy_date
1	jungYu	H49452	1	
2	momo	MU98	3	
3	dahyeon	SAV1245-01	2	
4	nayeon	MU98	2	
5	dahyeon	ACH991	3	
6	jungYu	LG98T2	2	
7	nayeon	LG98T2	2	
8	jungYu	ACH991	4	
 * */
