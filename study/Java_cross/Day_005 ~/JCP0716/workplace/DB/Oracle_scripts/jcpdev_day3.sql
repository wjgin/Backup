CREATE TABLE tbl#(
	col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,
	col2 varchar2(10) NOT NULL, -- CONSTRAINT Ű���� ���� : �� �������� ���
	col3 varchar2(10),
	col4 NUMBER(3)
);

INSERT INTO tbl#(col1) VALUES ('test1'); -- col2�� �������� ����
INSERT INTO tbl#(col1, col2) VALUES ('test1', 'test2');

-- 1)�÷��̸� ����
-- ALTER TABLE [���̺��] RENAME COLUMN [�����÷���] TO [�������÷���];
ALTER TABLE tbl# RENAME COLUMN �ٲٱ� �� TO �ٲ��̸�;

-- 2) �Ʒ� �÷� �߰��ϸ� ���� row�鵵 default ������ �����
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); -- �⺻�� 100
INSERT INTO tbl#(col1, col2) VALUES ('�׽�Ʈ1', '�׽�Ʈ2');


-- 3)�÷� �߰� : column6 ��������(20) �⺻�� 'guest' �� ����
ALTER TABLE tbl# ADD (column6 varchar2(20) DEFAULT 'guest');
INSERT INTO tbl#(col1, col2) VALUES ('�Խ�Ʈ1', '�Խ�Ʈ2');

-- 4) ���� �÷� ���� ���� 
-- ������ ũ�⸸ �ٲٱ�
ALTER TABLE tbl# MODIFY (col2 varchar(50)); 
-- ������ ũ��� null �������� �ٲٱ�
ALTER TABLE tbl# MODIFY (col2 varchar(50) null);

-- 5) ���� ���� �߰� : ������ ����� ������ ������ ���� �߻� ���ɼ� ����
 -- ����: �̹� col3�� null�� ����
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
-- null ���� ���� �� ���� / ���������� �̸��� �����ؾ���
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);
-- �������� �ϳ� �� �ϳ��� �÷��� ���� ���� drop������ �Ȼ��ܼ� ������
-- ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull4 CHECK (column5 IS NOT NULL AND column6 IS NOT NULL );

-- 7) �������� ����
ALTER TABLE TBL# DROP CONSTRAINT TBL#_NOTNULL4;
-- meta data�� �������� Ȯ���غ���(where ���� ������ ��� ��������)
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TBL#';



-- ���泻�� Ȯ��
SELECT * FROM tbl#;
-- [���泻�� Ű����] :
-- 1)�÷��̸� ����: rename column [�����÷�] to [�ٲ��÷��̸�] 
-- 2)���̺� �̸� ����: rename to 
-- 3)���ο� �÷� �߰�: add
-- 4)�÷� ������ ���� ����: modify
-- 5)�������� ����: add constraint
-- 6)�����÷� ����: drop
-- 7)���� �������� ����
-- ����Ŭ ��ҹ��ڰ� �ʿ��� ��� : ���ǰ� �˻�(ó���� ��� �빮�ڰ� ��)


-- ���̺�: ��ü/���踦 �����ͷ� ����.
-- student ��ü�� �䱸���׿� ���� �ʵ�(�Ӽ�)�� ����
--  �� �ʵ�: �й�, �̸�, �ּ�, ����, ����
-- �������� chck �߰�. 1
CREATE TABLE student (
	stu_no char(6) NOT NULL,
	stu_name varchar2(20) NOT NULL
	
	address varchar2(50),
	age number(3) CHECK (age BETWEEN 16 AND 20),
	gender char(1) CHECK(gender IN('M', 'F'))-- gender = 'M' OR gender = 'F'
);

-- INSERT �� �������� ���� �߻��� ��� �����ؼ� 10��
-- �й�: ��:) 2021A1
INSERT INTO STUDENT VALUES ('2021A1', 'Lee', 'Goyang', 17, 'M');
-- ���� �������� ����
INSERT INTO STUDENT VALUES ('2021A2', 'Kim', 'Seoul', 21, 'M'); 
INSERT INTO STUDENT VALUES ('2021A3', 'Choi', 'Chnagwon', 17, 'F');
INSERT INTO STUDENT VALUES ('2021A4', 'Shin', 'Paju', 16, 'F');
--  �й� �������� ����
INSERT INTO STUDENT VALUES (NULL, 'Park', 'Busan', 18, 'M'); 
INSERT INTO STUDENT VALUES ('2021B1', 'Woo', 'Uijeongbu', 19, 'F');
INSERT INTO STUDENT VALUES ('2021B2', 'Lim', 'Siheung', 20, 'M');
INSERT INTO STUDENT VALUES ('2021B3', 'Yoon', 'Okkcheon', 20, 'F');
-- ���� �������� ����
INSERT INTO STUDENT VALUES ('2021B4', 'Eulji', 'Yeoncheon', 18, 'Man'); 
INSERT INTO STUDENT VALUES ('2021B5', 'Han', 'Gangneung', 16, 'M');
-- ckeck ���� ���� null �� ��� Ȯ�� => �����
INSERT INTO STUDENT VALUES ('2021B6', 'Han', 'Gangneung', NULL, NULL);

-- Ư�� �̸��� �л��� �ּҸ� ����
UPDATE STUDENT SET address = 'Seoul' WHERE sut_name = 'Lee';
-- �÷� �̸� ����
ALTER TABLE STUDENT RENAME COLUMN sut_name TO stu_name;
-- student�� ����� �л��̸��� ����, ������ �����ֱ�
SELECT stu_name, age, gender FROM STUDENT;
-- ��°� ����(�����͸� ���� x)
-- decode �Լ� ����
SELECT stu_name, age, DECODE(GENDER, 'M', '����', 'F', '����', 'unknown') FROM STUDENT;
-- nvl(�ʵ�, 'null ��ü ��')
SELECT stu_name, NVL(age, 0), DECODE(GENDER, 'M', '����', 'F', '����', 'unknown') FROM STUDENT;
SELECT * FROM STUDENT;

-- Primary key : ��ü �ν��Ͻ�(row) �ĺ�
-- �⺻Ű ���� ���� : null ������, ���ϼ� ����
ALTER TABLE STUDENT ADD CONSTRAINT student_pk PRIMARY KEY (stu_no);

-- score ���̺�
--  �� �ʵ� : �й�, subject_id, mid_score, final_score, grade
CREATE TABLE score(
	stu_no char(6) NOT NULL, -- PK������ �ڵ����� NOT NULL, UNIQUE ����(�׷��� ����)
	subject_id char(5) NOT NULL,
	mid_score NUMBER(3) NOT NULL, 
	final_score NUMBER(3) NOT NULL, 
	grade char(1), 
	-- �⺻Ű ����
	CONSTRAINT score_pk PRIMARY KEY(stu_no, subject_id),
	-- �ܷ�Ű ����(���̺� ������ ���� ����)
	CONSTRAINT score_stuno_fk FOREIGN KEY (stu_no) -- score ���̺� �÷�
		REFERENCES student(stu_no) 				   -- �����ϴ� ���̺�(�÷�)
);

-- �⺻Ű �������� not null
ALTER TABLE SCORE MODIFY stu_no char(6) NOT NULL;
ALTER TABLE SCORE MODIFY subject_id char(5) NOT NULL;

INSERT INTO score VALUES('2021A1', 'KO211', 80, 90, NULL);
INSERT INTO score VALUES('2021B2', 'KO211', 87, 76, NULL);
INSERT INTO score VALUES('2021B5', 'KO211', 67, 76, NULL);
INSERT INTO score VALUES('2021A1', 'EN211', 84, 89, NULL);
INSERT INTO score VALUES('2021B2', 'EN211', 78, 79, NULL);
INSERT INTO score VALUES('2021B5', 'EN211', 92, 92, NULL);
INSERT INTO score VALUES('2021A1', 'EC211', 85, 95, NULL);
INSERT INTO score VALUES('2021B2', 'EC211', 85, 95, NULL);
INSERT INTO score VALUES('2021B5', 'EC211', 56, 75, NULL);
INSERT INTO score VALUES('2021A1', 'PR211', 79, 95, NULL);
INSERT INTO score VALUES('2021B2', 'PR211', 88, 85, NULL);
INSERT INTO score VALUES('2021B5', 'PR211', 69, 78, NULL);


-- ���� �־��
UPDATE SCORE SET GRADE = CASE 
	WHEN (((MID_SCORE + FINAL_SCORE) / 2) >= 90) THEN 'A'
	WHEN (((MID_SCORE + FINAL_SCORE) / 2) >= 80) THEN 'B'
	ELSE 'C'
	END;
INSERT INTO score VALUES('2021B5', 'PR211', 90, 90, 'C');

-- INSERT , UPDATE : FK �������� ���� �߻� ����
INSERT INTO score VALUES('2021A1', 'KO211', 88, 85, 'B');
INSERT INTO score VALUES('2021B2', 'EN211', 94, 95, 'A'); 
INSERT INTO score VALUES('2021A1', 'PR211', 78, 83, 'B'); 

-- FK ����(���Ἲ ����, �����ϴ� ���̺� �ʵ�(�θ�)�� ���� ��)
-- integrity constraint (JCPDEV.SCORE_STUNO_FK) violated - partent key not found
-- INSERT INTO score VALUES('2021A6', 'KO211', 88, 85, 'B');
-- �����ǰ� �ִ� �����͸� ������ ���, ����(�ڽ� ���ڵ尡 ����) 
-- integrity constraint (JCPDEV.SCORE_STUNO_FK) violated - child record found
-- DELETE FROM STUDENT WHERE STU_NAME = 'Lee';


SELECT * FROM SCORE;

-- ���̺� ����
DROP TABLE score;

UPDATE CUSTOM# SET CUSTOM_EMAIL = 'momo@naver.com' WHERE CUSTOM_ID = 'momo';
