-- CREATE table

CREATE TABLE member (
	idx NUMBER(5) NOT NULL ,
	stuname varchar2(20)NOT NULL,
	email varchar(20)NOT NULL,
	tel varchar(20),
	password varchar(10),
	CONSTRAINT member_PK PRIMARY KEY (idx)
); 

CREATE TABLE book (
	bcode char(5) NOT NULL ,
	title varchar2(30)NOT NULL,
	writer varchar(20),
	publisher varchar(20),
	cdate DATE,
	CONSTRAINT book_PK PRIMARY KEY (bcode)
); 

CREATE TABLE bookrent (
	idx NUMBER(5) NOT NULL ,
	bcode char(5) NOT NULL ,
	rent_date DATE NOT NULL,
	exp_date DATE NOT NULL ,
	state char(1) DEFAULT 'F',
	return_date DATE,
	CONSTRAINT bookrent_PK PRIMARY KEY (idx, bcode)
); 

DROP TABLE BOOKRENT ;

-- CREATE sequence
CREATE SEQUENCE mem_seq;


-- INSERT data to member table
INSERT INTO MEMBER VALUES (mem_seq.nextval, '���ϴ�', 'honey@naver.com', '010-9889-0567', '1122');
INSERT INTO MEMBER VALUES (mem_seq.nextval, '�̼���', 'jong@daum.net', '010-2354-6773', '2345');
INSERT INTO MEMBER VALUES (mem_seq.nextval, '�����', 'lucky@korea.com', '010-5467-8792', '9876');
INSERT INTO MEMBER VALUES (mem_seq.nextval,'���浿', 'nadong@kkk.net', '010-3456-8765', '3456');
INSERT INTO MEMBER VALUES (mem_seq.nextval, '������', 'haha@korea.net', '010-3987-9087', '1234');

SELECT * FROM "MEMBER" ;


-- INSERT data to book table
INSERT INTO BOOK VALUES ('A1101', '�ڽ���', 'Į���̰�', '���̾𽺺Ͻ�', '2006-12-01');
INSERT INTO BOOK VALUES ('B1101', '��Ŀ������', '����Ŀ', '��Ŀ����', '2018-7-10');
INSERT INTO BOOK VALUES ('C1101', 'Ǫ�� ���ڿ� �ϴ�', '���� ', 'â��', '2015-6-20');
INSERT INTO BOOK VALUES ('A1102', '�佺Ʈ', '�˺���Ʈ �', '������', '2011-3-1');

SELECT * FROM BOOK ;


-- INSERT data to bookrent table
INSERT INTO BOOKRENT VALUES (1, 'A1101', '2020-10-11', '2020-10-25', 'F', NULL );
INSERT INTO BOOKRENT VALUES ('1', 'B1101', '2020-09-01', '2020-09-15', 'F', '2020-09-14');
INSERT INTO BOOKRENT VALUES ('2', 'C1101', '2020-09-12', '2020-09-26', 'T', '2020-09-29');
INSERT INTO BOOKRENT VALUES ('3', 'A1102', '2020-10-04', '2020-10-18', 'F', NULL);
INSERT INTO BOOKRENT VALUES ('3', 'B1101', '2020-09-03', '2020-09-17', 'F', '2020-09-17');
INSERT INTO BOOKRENT VALUES ('4', 'C1101', '2020-10-02', '2020-10-16', 'F', NULL );

SELECT * FROM BOOKRENT;


-- ȭ�� ����

-- ���� ���� ����
UPDATE BOOKRENT SET STATE = 'T' WHERE EXP_DATE < '2020-10-19';

CREATE VIEW b_rent
AS 
	SELECT b.BCODE , b.TITLE, b.PUBLISHER, b2.RENT_DATE , b2.IDX, b2.RETURN_DATE , b2.EXP_DATE , b2.STATE 
	FROM BOOK b , BOOKRENT b2 
	WHERE b.BCODE = b2.BCODE ;

SELECT * FROM b_rent; 

DROP VIEW B_RENT ;

-- ���� ���� ���� ����
SELECT m.IDX ȸ����ȣ , m.STUNAME ȸ���̸�, br.TITLE ������, br.PUBLISHER ���ǻ�, br.rent_date �뿩��, br.exp_date �ݳ�������, DECODE(br.STATE , 'T', '��ü ��', 'F', NULL) ��üȮ
	FROM "MEMBER" m , B_RENT br WHERE m.IDX = br.idx AND br.RETURN_DATE IS NULL ;

UPDATE BOOKRENT SET STATE = 'F' WHERE RETURN_DATE < EXP_DATE ;


-- ȸ���� �뿩����
SELECT * FROM BOOKRENT b, MEMBER m WHERE b.IDX (+) = m.IDX ;

-- ȸ���� �뿩 ����
WITH rent AS (
	SELECT m.IDX, m.STUNAME , b.BCODE
	FROM BOOKRENT b, MEMBER m 
	WHERE b.IDX (+) = m.IDX) 
SELECT IDX, STUNAME, COUNT(BCODE)  from rent GROUP BY IDX, STUNAME ORDER BY IDX ;


-- ȸ���� ��ü ����
SELECT m.IDX, m.STUNAME, NVL(cnt, 0) 
FROM "MEMBER" m, 
	(SELECT idx, COUNT(*) cnt  FROM BOOKRENT b WHERE state = 'T' GROUP BY idx) rcnt
	WHERE m.IDX = rcnt.idx(+)
	ORDER BY m.IDX ;

