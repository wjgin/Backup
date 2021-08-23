CREATE TABLE userInfo(
	userInfo_id varchar2(32) PRIMARY KEY , -- 영문, 숫자 최대 16자
	userInfo_password varchar2(32) NOT NULL , -- 영문, 숫자 최대 16자
	userInfo_name varchar(30) NOT NULL -- 유저 이름 한글 최대 10자
);
DROP TABLE USERINFO ;

CREATE TABLE account (
	account_num number(20) PRIMARY  KEY, -- 숫자만 '-' 제외
	account_bank varchar2(30) NOT NULL , -- 은행명 최대 10글자
	account_owner varchar2(30)NOT NULL , -- 예금주 한글 최대 10글자
	userInfo_id varchar2(32), -- 외래키 유저 정보
	CONSTRAINT account_userInfo_fk FOREIGN KEY (userInfo_id) REFERENCES userInfo(userInfo_id)
); 
DROP TABLE ACCOUNT ;

CREATE TABLE incomeExpense (
	ie_idx NUMBER(20) PRIMARY KEY, -- ie_seq, 생성 순번
	ie_division varchar2(7) NOT NULL, -- IN('income', 'expense') 수입, 지출 구분
	ie_time DATE DEFAULT sysdate,
	ie_price NUMBER NOT NULL,
	USERINFO_id varchar(32), -- fk 유저 아이디
	account_num number(20), -- fk 계좌번호
	CONSTRAINT ie_userInfo FOREIGN KEY (USERINFO_id) REFERENCES USERINFO(USERINFO_id),
	CONSTRAINT ie_account FOREIGN KEY (ACCOUNT_num) REFERENCES account(ACCOUNT_num)
);
DROP TABLE INCOMEEXPENSE ;

CREATE SEQUENCE ie_seq;
DROP SEQUENCE ie_seq;

-- 전체 조회
SELECT ie.IE_DIVISION , ieFROM INCOMEEXPENSE ie WHERE ie.USERINFO_ID = "momo";


-- 유저 테이블 에시 데이터 삽입
INSERT INTO USERINFO VALUES ('springkim', 'kimkim123', '김봄');
INSERT INTO USERINFO VALUES ('fallpark', 'park1515@1s', '박가을');
INSERT INTO USERINFO VALUES ('sunnychoi', 'hotpassword', '최여름');
INSERT INTO USERINFO VALUES ('icedHan', 'Hhan1532@df%', '한겨울');

-- 계좌 테이블 예시 데이터 삽입
INSERT INTO ACCOUNT VALUES (558412354423, '국민은행', '김봄', 'springkim');
INSERT INTO ACCOUNT VALUES (01012345678, '신한은행', '박가을 ', 'fallpark');
INSERT INTO ACCOUNT VALUES (110123567, '카카오뱅크', '박가을', 'fallpark');
INSERT INTO ACCOUNT VALUES (110222555, '카카오뱅크', '최여름', 'sunnychoi');
INSERT INTO ACCOUNT VALUES (525243435578, 'IBK', '한겨울', 'icedHan');
INSERT INTO ACCOUNT VALUES (2245348654, '농협은행', '한겨울', 'icedHan');
INSERT INTO ACCOUNT VALUES (01033335555, '신한', '한겨울', 'icedHan');

-- 수입 및 지출 테이블 예시 데이터 삽입
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '수입', 3150,'sunnychoi',  110222555);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '지출', -3150,'sunnychoi',  110222555);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '지출', -150000,'fallpark',  110123567);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '수입', 3000000,'icedHan',  525243435578);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '지출', -1200000,'icedHan',  525243435578);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '수입', 1200000,'icedHan',  01033335555);
