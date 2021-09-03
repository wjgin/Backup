CREATE TABLE member (
	idx int auto_increment primary key, -- auto_increment 바로 대입 가능
	stuname varchar(20)NOT NULL,
	email varchar(20)NOT NULL,
	tel varchar(20),
	password varchar(10)
);

-- mysql은 시퀀스 객체가 없음. 컬럼 자동증가 auto_increment
-- insert 할 때, auto_increment 컬럼은 제외
-- INSERT data to member table
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('이하니', 'honey@naver.com', '010-9889-0567', '1122');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('이세종', 'jong@daum.net', '010-2354-6773', '2345');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('최행운', 'lucky@korea.com', '010-5467-8792', '9876');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('나길동', 'nadong@kkk.net', '010-3456-8765', '3456');
INSERT INTO MEMBER(stuname, email, tel, password) VALUES ('강감찬', 'haha@korea.net', '010-3987-9087', '1234');


create table book (
	bcode char(5) primary key ,
	title varchar(30)not null,
	writer varchar(20),
	publisher varchar(20),
	cdate DATE
); 

-- INSERT data to book table
INSERT INTO BOOK VALUES ('A1101', '코스모스', '칼세이건', '사이언스북스', '2006-12-01');
INSERT INTO BOOK VALUES ('B1101', '해커스토익', '이해커', '해커스랩', '18/07/10');
INSERT INTO BOOK VALUES ('C1101', '푸른 사자와 니니', '이현 ', '창비', '15/6/20');
INSERT INTO BOOK VALUES ('A1102', '페스트', '알베르트 까뮈', '민음사', '11/03/01');

select * from book;

-- 날짜 데이터 활용 : 년도, 월, 일, 시, 분, 초 만 추출
select bcode,  year(cdate) from book;
select bcode,  date_format(cdate, '%Y') from book; -- ex 2006
select bcode,  date_format(cdate, '%Y-%m') from book; -- ex 2006-12
select bcode,  date_format(cdate, '%y') from book; -- ex 06
select bcode,  date_format(cdate, '%M') from book; -- ex March
select bcode,  date_format(cdate, '%m') from book; -- ex 12


-- 함수 이름 SQL에서 to_xxx => 오라클 함수

CREATE TABLE bookrent (
	idx int NOT NULL ,
	bcode char(5) NOT NULL ,
	rent_date timestamp default current_timestamp, -- mysql의 현재 날짜 + 시간
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

select b.bcode , b.title , b2.idx as 회원번호, b2.rent_date from book b , bookrent b2 where b.bcode = b2.bcode ;

select idx, count(idx) from bookrent b group by idx ;

select m.idx , stuname, ifnull(cnt, 0)
	from `member` m ,(select idx, count(*) cnt from bookrent b group by idx ) r_cnt
	where m.idx = r_cnt.idx	-- 동등 조인
	order by idx;

select m.idx , stuname, ifnull(cnt, 0)	-- 오라클의 nvl 대신 ifnull 사용
	from `member` as m  left outer join -- 왼쪽 테이블의 모든 행 포함
		(select idx, count(*) cnt from bookrent b group by idx ) r_cnt
	on m.idx = r_cnt.idx	-- 외부 조인
	order by idx;

select idx, (case state when 'T' then '연체' when 'F' then '정상' end) as 상태  
	from bookrent; -- 오라클의 decode 대체 방법
	
select * from book;
