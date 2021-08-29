CREATE TABLE userinfo( --����� ȸ��
   userinfo_id varchar2(20) PRIMARY KEY,   --���̵� pk
   userinfo_password varchar2(8)NOT null, --���
   userinfo_phone varchar2(11)NOT null,
   userinfo_name varchar2(20)NOT null, --�̸�
   input_date date DEFAULT sysdate-- ���� ��¥
);
--DROP TABLE USERINFO ;

CREATE TABLE account( --���� ���̺�
   account_num varchar2(20) PRIMARY KEY,    --���¹�ȣ
   account_bank varchar2(20)NOT null,     --�����
   account_owner varchar2(20)NOT null,     --������ 
   userinfo_id varchar2(20)NOT null, --fk
   CONSTRAINT fk_acc_id FOREIGN KEY(userinfo_id) 
   REFERENCES userinfo(userinfo_id) ON DELETE CASCADE
);
--DROP TABLE ACCOUNT ;

CREATE TABLE incomeexpense( --����,����
   ie_idx number(5) PRIMARY KEY,
   ie_division char(1) CHECK(ie_division IN('I','E')),
   ie_category varchar2(30),
   ie_time DATE DEFAULT sysdate, --����,���� ��¥
   ie_price number(10),
   userinfo_id varchar2(20), --fk
   account_num varchar2(20),    --fk ���¹�ȣ
   ie_memo varchar2(100),
   CONSTRAINT fk_ie_id FOREIGN KEY(userinfo_id) 
   		REFERENCES userinfo(userinfo_id) ON DELETE CASCADE
);
--DROP TABLE INCOMEEXPENSE ;

CREATE SEQUENCE ie_seq;
--DROP SEQUENCE ie_seq;

INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('momo','1234','01012341234','����');
INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('sana','1111','01012341235','��糪');
INSERT INTO USERINFO (USERINFO_ID,USERINFO_PASSWORD,USERINFO_PHONE,USERINFO_NAME)
      values('mina','2222','01052461447','�̹̳�');
   
INSERT INTO ACCOUNT values('35902380825','�츮','����','momo');   
INSERT INTO ACCOUNT values('4994493827','����','��糪�ƺ�','sana');   
INSERT INTO ACCOUNT values('3294973967','����','�̹̳�','mina');   
      
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','��Ȱ��',300000,'momo','35902380825','����');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','�̿�',200000,'momo','35902380825','����');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','�Ĵ�',7000,'momo','35902380825','���� �޹б���');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'I','����',3000000,'momo','35902380825','7�� ����');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','�ڱ���',20000,'momo','35902380825','�����ΰ�');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','��ȭ',12000,'momo','35902380825','��ȭ����');
INSERT INTO incomeexpense (ie_idx,ie_division,ie_category,ie_price,userInfo_id,account_num,ie_memo) 
VALUES(ie_seq.nextval,'E','��Ȱ��',30000,'momo','35902380825','���⼼');

--==================================

SELECT * FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_CATEGORY LIKE '��Ȱ��';
SELECT decode(ie_division,'E','����','I','����'), ie_time, ie_price, ie_category, ie_memo, account_num, ie_idx FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_CATEGORY LIKE '%��%';
SELECT decode(ie_division,'E','����','I','����'), ie_time, ie_price, ie_category, ie_memo, account_num, ie_idx 
FROM INCOMEEXPENSE WHERE USERINFO_ID = 'momo' AND IE_DIVISION = 'I'
