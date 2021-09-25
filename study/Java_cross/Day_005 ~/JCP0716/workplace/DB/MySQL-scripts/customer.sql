-- 테이블 생성 영역
CREATE TABLE customer (
	idx int auto_increment primary key, -- auto_increment 바로 대입 가능
	name varchar(20)NOT NULL,
	password varchar(20)NOT NULL,
	email varchar(30)NOT NULL,
	address varchar(30),
	gender varchar(10) not null ,
	age tinyint,
	hobby varchar(30)
);


-- varchar의 크기는 글자수(한 영 모두 동일)

-- 데이터 삽입 영역
insert into customer(name, password, email, address, gender, age, hobby)
	values ("길동좌", "qlalfwjsgh", "kingdong@gmail.com", "반도", "남자", 33, "축지법, 도술, 참교육");
insert into customer(name, password, email, address, gender, age, hobby)
	values ("홍길동", "ghdrkfghdrkf", "kingdong@naver.com", "강남", "여자", 55, "농구, 축구");


-- 고객정보 수정 요구사항: email, address 변경
-- 검색조건: idx(primary key)
update customer set email = 'kingdong@naver.com', address = 'LA' where idx = 1;

delete from customer where idx = 2;

select * from customer;
commit;