CREATE TABLE userInfo(
	userInfo_id varchar2(32) PRIMARY KEY , -- ����, ���� �ִ� 16��
	userInfo_password varchar2(32) NOT NULL , -- ����, ���� �ִ� 16��
	userInfo_name varchar(30) NOT NULL -- ���� �̸� �ѱ� �ִ� 10��
);
DROP TABLE USERINFO ;

CREATE TABLE account (
	account_num number(20) PRIMARY  KEY, -- ���ڸ� '-' ����
	account_bank varchar2(30) NOT NULL , -- ����� �ִ� 10����
	account_owner varchar2(30)NOT NULL , -- ������ �ѱ� �ִ� 10����
	userInfo_id varchar2(32), -- �ܷ�Ű ���� ����
	CONSTRAINT account_userInfo_fk FOREIGN KEY (userInfo_id) REFERENCES userInfo(userInfo_id)
); 
DROP TABLE ACCOUNT ;

CREATE TABLE incomeExpense (
	ie_idx NUMBER(20) PRIMARY KEY, -- ie_seq, ���� ����
	ie_division varchar2(7) NOT NULL, -- IN('income', 'expense') ����, ���� ����
	ie_time DATE DEFAULT sysdate,
	ie_price NUMBER NOT NULL,
	USERINFO_id varchar(32), -- fk ���� ���̵�
	account_num number(20), -- fk ���¹�ȣ
	CONSTRAINT ie_userInfo FOREIGN KEY (USERINFO_id) REFERENCES USERINFO(USERINFO_id),
	CONSTRAINT ie_account FOREIGN KEY (ACCOUNT_num) REFERENCES account(ACCOUNT_num)
);
DROP TABLE INCOMEEXPENSE ;

CREATE SEQUENCE ie_seq;
DROP SEQUENCE ie_seq;

-- ��ü ��ȸ
SELECT ie.IE_DIVISION , ieFROM INCOMEEXPENSE ie WHERE ie.USERINFO_ID = "momo";


-- ���� ���̺� ���� ������ ����
INSERT INTO USERINFO VALUES ('springkim', 'kimkim123', '�躽');
INSERT INTO USERINFO VALUES ('fallpark', 'park1515@1s', '�ڰ���');
INSERT INTO USERINFO VALUES ('sunnychoi', 'hotpassword', '�ֿ���');
INSERT INTO USERINFO VALUES ('icedHan', 'Hhan1532@df%', '�Ѱܿ�');

-- ���� ���̺� ���� ������ ����
INSERT INTO ACCOUNT VALUES (558412354423, '��������', '�躽', 'springkim');
INSERT INTO ACCOUNT VALUES (01012345678, '��������', '�ڰ��� ', 'fallpark');
INSERT INTO ACCOUNT VALUES (110123567, 'īī����ũ', '�ڰ���', 'fallpark');
INSERT INTO ACCOUNT VALUES (110222555, 'īī����ũ', '�ֿ���', 'sunnychoi');
INSERT INTO ACCOUNT VALUES (525243435578, 'IBK', '�Ѱܿ�', 'icedHan');
INSERT INTO ACCOUNT VALUES (2245348654, '��������', '�Ѱܿ�', 'icedHan');
INSERT INTO ACCOUNT VALUES (01033335555, '����', '�Ѱܿ�', 'icedHan');

-- ���� �� ���� ���̺� ���� ������ ����
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', 3150,'sunnychoi',  110222555);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', -3150,'sunnychoi',  110222555);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', -150000,'fallpark',  110123567);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', 3000000,'icedHan',  525243435578);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', -1200000,'icedHan',  525243435578);
INSERT INTO INCOMEEXPENSE(ie_idx, ie_division, IE_PRICE ,USERINFO_id, account_num) VALUES(ie_seq.nextval, '����', 1200000,'icedHan',  01033335555);
