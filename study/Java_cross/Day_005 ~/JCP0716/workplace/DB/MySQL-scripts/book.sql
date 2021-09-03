CREATE TABLE member (
	idx int auto_increment primary key, -- auto_increment �ٷ� ���� ����
	stuname varchar(20)NOT NULL,
	email varchar(20)NOT NULL,
	tel varchar(20),
	password varchar(10)
);

-- mysql�� ������ ��ü�� ����. �÷� �ڵ����� auto_increment
-- insert �� ��, auto_increment �÷��� ����
-- INSERT data to member table
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('���ϴ�', 'honey@naver.com', '010-9889-0567', '1122');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('�̼���', 'jong@daum.net', '010-2354-6773', '2345');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('�����', 'lucky@korea.com', '010-5467-8792', '9876');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('���浿', 'nadong@kkk.net', '010-3456-8765', '3456');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('������', 'haha@korea.net', '010-3987-9087', '1234');


create table book (
	bcode char(5) primary key ,
	title varchar(30)not null,
	writer varchar(20),
	publisher varchar(20),
	cdate DATE
); 

-- INSERT data to book table
INSERT INTO BOOK VALUES ('A1101', '�ڽ���', 'Į���̰�', '���̾𽺺Ͻ�', '2006-12-01');
INSERT INTO BOOK VALUES ('B1101', '��Ŀ������', '����Ŀ', '��Ŀ����', '18/07/10');
INSERT INTO BOOK VALUES ('C1101', 'Ǫ�� ���ڿ� �ϴ�', '���� ', 'â��', '15/6/20');
INSERT INTO BOOK VALUES ('A1102', '�佺Ʈ', '�˺���Ʈ �', '������', '11/03/01');

select * from book;

-- ��¥ ������ Ȱ�� : �⵵, ��, ��, ��, ��, �� �� ����
select bcode,  year(cdate) from book;
select bcode,  date_format(cdate, '%Y') from book; -- ex 2006
select bcode,  date_format(cdate, '%Y-%m') from book; -- ex 2006-12
select bcode,  date_format(cdate, '%y') from book; -- ex 06
select bcode,  date_format(cdate, '%M') from book; -- ex March
select bcode,  date_format(cdate, '%m') from book; -- ex 12


-- �Լ� �̸� SQL���� to_xxx => ����Ŭ �Լ�

CREATE TABLE bookrent (
	idx int NOT NULL ,
	bcode char(5) NOT NULL ,
	rent_date timestamp default current_timestamp, -- mysql�� ���� ��¥ + �ð�
	exp_date DATE NOT NULL ,
	state char(1) DEFAULT 'F',
	return_date DATE,
	CONSTRAINT bookrent_PK2 PRIMARY KEY (idx, bcode)
); 

-- INSERT data to bookrent table
INSERT INTO BOOKRENT(idx, bcode, rent_date, exp_date, state, return_date) 
	VALUES (1, 'B1101', '2020-09-01', '2020-09-15', 'F', '2020-09-14');
INSERT INTO BOOKRENT(idx, bcode, rent_date, exp_date, state, return_date) 
	VALUES ('2', 'C1101', '2020-09-12', '2020-09-26', 'T', '2020-09-29');
INSERT INTO BOOKRENT(idx, bcode, rent_date, exp_date, state, return_date) 
	VALUES ('3', 'A1102', '2020-10-04', '2020-10-18', 'F', NULL);
INSERT INTO BOOKRENT(idx, bcode, rent_date, exp_date, state, return_date) 
	VALUES ('3', 'B1101', '2020-09-03', '2020-09-17', 'F', '2020-09-17');
INSERT INTO BOOKRENT(idx, bcode, rent_date, exp_date, state, return_date) 
	VALUES ('4', 'C1101', '2020-10-02', '2020-10-16', 'F', NULL );


alter table bookrent add constraint rent_idx_fk foreign key (idx) references member(idx);
alter table bookrent add constraint rent_bcode_fk foreign key (bcode) references book(bcode);

select * from bookrent;

select b.bcode , b.title , b2.idx as ȸ����ȣ, b2.rent_date from book b , bookrent b2 where b.bcode = b2.bcode ;

select idx, count(idx) from bookrent b group by idx ;

select m.idx , stuname, ifnull(cnt, 0)
	from `member` m ,(select idx, count(*) cnt from bookrent b group by idx ) r_cnt
	where m.idx = r_cnt.idx	-- ���� ����
	order by idx;

select m.idx , stuname, ifnull(cnt, 0)	-- ����Ŭ�� nvl ��� ifnull ���
	from `member` as m  left outer join -- ���� ���̺��� ��� �� ����
		(select idx, count(*) cnt from bookrent b group by idx ) r_cnt
	on m.idx = r_cnt.idx	-- �ܺ� ����
	order by idx;

select idx, (case state when 'T' then '��ü' when 'F' then '����' end) as ����  
	from bookrent; -- ����Ŭ�� decode ��ü ���
	
select * from book;
