CREATE TABLE userinfo( --가계부 회원
   userinfo_id varchar2(20) PRIMARY KEY,   --아이디 pk
   userinfo_password varchar2(8)NOT null, --비번
   userinfo_phone varchar2(11)NOT null,
   userinfo_name varchar2(20)NOT null, --이름
   input_date date DEFAULT sysdate-- 가입 일짜
);
--DROP TABLE USERINFO ;

CREATE TABLE account( --계좌 테이블
   account_num varchar2(20) PRIMARY KEY,    --계좌번호
   account_bank varchar2(20)NOT null,     --은행명
   account_owner varchar2(20)NOT null,     --예금주 
   userinfo_id varchar2(20)NOT null, --fk
   CONSTRAINT fk_acc_id FOREIGN KEY(userinfo_id) 
   REFERENCES userinfo(userinfo_id) ON DELETE CASCADE
);
--DROP TABLE ACCOUNT ;

CREATE TABLE incomeexpense( --수입,지출
   ie_idx number(5) PRIMARY KEY,
   ie_division char(1) CHECK(ie_division IN('I','E')),
   ie_category varchar2(30),
   ie_time DATE DEFAULT sysdate, --수입,지출 날짜
   ie_price number(10),
   userinfo_id varchar2(20), --fk
   account_num varchar2(20),    --fk 계좌번호
   ie_memo varchar2(100),
   CONSTRAINT fk_ie_id FOREIGN KEY(userinfo_id) 
   		REFERENCES userinfo(userinfo_id) ON DELETE CASCADE
);
--DROP TABLE INCOMEEXPENSE ;

CREATE SEQUENCE ie_seq;
--DROP SEQUENCE ie_seq;

INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('momo','1234','01012341234','김모모');
INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('sana','1111','01012341235','김사나');
INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('mina','2222','01052461447','이미나');
   
INSERT INTO ACCOUNT values('35902380825','우리','김모모','momo');   
INSERT INTO ACCOUNT values('4994493827','농협','김사나아빠','sana');   
INSERT INTO ACCOUNT values('3294973967','국민','이미나','mina');   
      
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','생활비',300000,'momo','35902380825','월세');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','미용',200000,'momo','35902380825','염색');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','식대',7000,'momo','35902380825','점심 메밀국수');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'I','월급',3000000,'momo','35902380825','7월 월급');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','자기계발',20000,'momo','35902380825','영어인강');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','문화',12000,'momo','35902380825','영화관람');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','생활비',30000,'momo','35902380825','전기세');

--==================================

SELECT * FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_CATEGORY LIKE '생활비';
SELECT decode(ie_division,'E','지출','I','수입'), ie_time, ie_price, ie_category, ie_memo, account_num, ie_idx FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_CATEGORY LIKE '%생%';
SELECT decode(ie_division,'E','지출','I','수입'), ie_time, ie_price, ie_category, ie_memo, account_num, ie_idx 
FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_DIVISION = 'I'
