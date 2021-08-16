-- CUSTOM# TABLE
CREATE TABLE custom# (
	custom_id varchar2(20) NOT NULL, -- 바이트 지정
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
	product_cartegory char(2), -- 카테고리는 불변의 값 => 항상 고정 길이 2바이트
	product_name varchar2(50),
	product_price number(9),
	CONSTRAINT PRODUCT#_PK PRIMARY KEY(PRODUCT_CODE)
);
-- 제약 조건을 추가하는 방법
ALTER TABLE PRODUCT# ADD CHECK (PRODUCT_price > 0); -- 제약조건의 이름 없음
ALTER TABLE PRODUCT# ADD CONSTRAINT price_check CHECK (PRODUCT_price > 0); -- 제약 조건 이름 있음

-- BUY# TABLE
CREATE TABLE buy#(
	buy_no number(9) NOT NULL ,
	custom_id varchar2(20) NOT NULL,-- .외래키 => 참조무결성에 의해서 반드시 값이 필요
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

INSERT INTO CUSTOM#(custom_id, custom_name, custom_email, custom_age) VALUES ('dahyeon',	'김다현',	'da@naver.com',	33)	;
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

-- 오라클 데이터 베이스 객체 :  시퀀스 - 정수값: n~m까지 +- k 계산 리턴(nextval)
--							ㄴ 시퀀스는 값을 되돌릴 수 없음 => drop 후 재생성 필요
CREATE SEQUENCE test_seq; -- n은 1부터, k는 +1씩 계산(기본 값)
CREATE TABLE tblseq# (
	 column1 number(3)
);
INSERT INTO tblseq#(column1) values(test_seq.nextval);
-- 시퀀스 삭제
DROP SEQUENCE buy#_seq;
-- 시퀀스 재정의 (9부터 1씩 증가)
CREATE SEQUENCE buy#_seq
	INCREMENT BY 1
	START WITH 9;
-- 시퀀스 확인(전체 시퀀스)
SELECT * FROM USER_SEQUENCES;
-- 현재 시퀀스 값 조회(조회가 안될때 nextval을 한번만 먼저 조회해주고 확인 : 첫 조회는 값 증가 안됨)
SELECT buy#_seq.currval FROM DUAL;
-- 테이블 데이터 삭제
TRUNCATE TABLE TBLSEQ#; 

SELECT * FROM TBLSEQ#;

-- buy# 테이블 날짜 데이터 갱신
UPDATE BUY# SET BUY_DATE = SYSDATE;
SELECT * FROM "BUY#";


/*
CUSTOM 테이블				
				
custom_id	name	email	age	reg_date
nayeon	임나연	na@korea.com	25	
jungYu	유정연	jung@daum.net	27	
momo	히라이모모	momo@gmail.com	24	
dahyeon	김다현	da@naver.com	33	
				
				
				
PRODUCT 테이블				
pcode	   category	       pname         price	
SAV1245-01	  10	     비스포크 청소기   	176000	
ACH991	      11	     아이패드프로 5	    270000	
H49452	      12	     블루투스헤드폰	     90400	
LG98T2	      10	     노트북	        392300	
MU98	      12	     USB 1TB	     14000	
				
				
Buy 테이블				
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
