-- 쇼핑몰 : 고객이 상품을 구매
-- 고객 테이블(custom) 생성 : 필드(column) 구성은 이름과 데이터 형식이 중요
CREATE TABLE custom# (
	-- 고객 아이디(문자열, var: 가변적인 char : 문자  2 : 버젼), (문자인코딩 uft-8) 
	-- 고객 이름(문자열)
	-- 이메일(문자열)
	-- 나이(정수, number) 3자리 *number : int, long, float, double 모두 가능
	-- 가입날짜(날짜 타입)
	custom_id varchar2(20), -- 바이트 지정
	custom_name varchar2(20),
	custom_email varchar2(20),
	
	custom_age number(3),
	custom_reg_date date
);

-- 상품(product) 테이블 : 상품코드, 카테고리(코드: 2자리), 상품명, 가격
--									  ㄴ 00: 전자제품, 10: 식품, 20: 생활용품...
CREATE TABLE product#(
	product_code varchar2(10),
	product_cartegory char(2), -- 카테고리는 불변의 값 => 항상 고정 길이 2바이트
	product_name varchar2(50),
	product_price number(9)
);

-- 구매(buy)테이블 : 고객 who, 상품 what 구매했는가?
CREATE TABLE buy#(
	custom_id varchar2(20),	-- who
	product_code varchar2(10), -- what
	buy_quantity NUMBER(5), -- how many
	buy_date DATE -- when
);

-- insert DML 형식 : 데이블에 새로운 데이터 추가
-- insert into 스키마이름.테이블이름 (컬림1, 컬럼2...)
-- values (컬럼1 값, 컬럽2 값...)
INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('sana0713','사나','sana@naver.com',24,'2021-07-31');

INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('mina2012','김미나','kim@gmail.com',20,'2020-05-21');

INSERT INTO JCPDEV.CUSTOM (CUSTOM_ID,CUSTOM_NAME,CUSTOM_EMAIL,CUSTOM_AGE,CUSTOM_REG_DATE)
	VALUES ('nana2012','김나나','kim@gmail.com',20, '2020-05-21');

-- 스키마 이름이 같으면, 생략 가능
INSERT INTO custom(custom_id) VALUES ('dayeon11');
INSERT INTO custom(custom_reg_date) VALUES ('2021-08-10');
INSERT INTO custom(custom_reg_date) VALUES (sysdate); -- 현재 날짜 : sysdate
INSERT INTO CUSTOM (custom_id, CUSTOM_NAME, CUSTOM_EMAIL)
			values('soon1234','도봉순', 'test@daum.net');

-- 문자열 '', 수치 값은 기호 없이 작성
INSERT INTO CUSTOM (CUSTOM_AGE) VALUES (33);
		
-- 모든 컬럼 값을 추가할 때, 테이블 이름 뒤에 컬럼 이름들을 생략 가능
INSERT INTO CUSTOM
		VALUES ('mina2012','김미나','lee@gmail.com',20, '2020-05-21');

-- 테이블에 저장된 데이터 변경 : update, delete
/*
 * update 테이블이름 set 컬럼이름=수정할값, 컬럼이름2=수정할값2,,, [where 조건];
 * */	
	
-- where 조건 없이 UPDATE 문 : 모든 row에 적용 => 매우 위험(바람직하지 않다)
UPDATE CUSTOM SET CUSTOM_REG_DATE = SYSDATE;

UPDATE CUSTOM SET CUSTOM_AGE = 25 WHERE CUSTOM_ID = 'dayeon11';

-- name 값이 null 인 경우 name = '손님'으로 UPDATE 
UPDATE CUSTOM SET CUSTOM_NAME = '손님' WHERE CUSTOM_NAME IS NULL;

-- custom_id가 null 인경우 'guest'
UPDATE  CUSTOM SET CUSTOM_ID  = 'guest' WHERE CUSTOM_ID IS NULL;

-- age값이 20보다 작으면 age =99
UPDATE CUSTOM SET CUSTOM_AGE = 999 WHERE CUSTOM_AGE <= 20;

-- and(&&), or(||) --> 값을 범위로 검사 (ex: 20보다 크고 30보다 작다)
UPDATE CUSTOM SET CUSTOM_AGE = 30 WHERE CUSTOM_AGE < 25 AND CUSTOM_AGE >20;

-- 값을 개별적으로 검사 : --> in
UPDATE CUSTOM SET CUSTOM_AGE = 98 WHERE CUSTOM_AGE in(25, 33); -- age가 25, 33 인 경우

UPDATE CUSTOM SET CUSTOM_AGE = '100' WHERE CUSTOM_AGE IS NULL;

-- set 뒤에 여러개의 컬럼 변경할 수 있음.
 UPDATE CUSTOM SET CUSTOM_AGE = 37, CUSTOM_NAME '머머' WHERE ~

 -- DELETE 형식
DELETE FROM CUSTOM; -- 테이블 모든 데이터 삭제
DELETE FROM CUSTOM WHERE CUSTOM_AGE = '999';

-- 진짜로 테이블의 데이터를 모두 삭제하고 싶다면...
TRUNCATE TABLE CUSTOM;

 -- 특정 컬럼만 보기
SELECT CUSTOM_ID, CUSTOM_AGE FROM CUSTOM;

-- 검색 조건에 맞는 특정 row --> where
-- 나이조건 : 40세 미만
SELECT * FROM CUSTOM WHERE CUSTOM_AGE < 40;
SELECT * FROM CUSTOM WHERE CUSTOM_AGE IN(30, 98);
SELECT * FROM CUSTOM WHERE CUSTOM_AGE NOT IN(30, 98); -- NULL은 제외
-- 이름 조건
SELECT * FROM CUSTOM WHERE CUSTOM_NAME = '손님';
SELECT * FROM CUSTOM WHERE CUSTOM_NAME NOT IN('손님');

-- 유사 비교 : i가 mina로 시작하는 데이터
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE 'mina%'; 
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE '%mina';  -- mina로 끝나는 데이터
SELECT * FROM CUSTOM  WHERE CUSTOM_ID LIKE '%mina%' 
	ORDER BY CUSTOM_EMAIL DESC ; -- mina가 포함된 데이터 이메일 내림차순
SELECT * FROM CUSTOM WHERE CUSTOM_ID LIKE '%Mina%'; -- Mina가 포함된 데이터(없음)

-- dual 테이블 : 어떤 권한에서나 사용 가능한 임시 테이블
SELECT 22*23 AS RESULT FROM DUAL; -- AS 뒤 별칭(RESULT) (AS는 생략가능)
SELECT LOWER('MiNa') FROM DUAL ;	-- 소문자 변환
SELECT SYSDATE FROM DUAL ;

-- 보여주는 순서 정하기 : order by 컬럼이름 [asc || desc]
SELECT * FROM CUSTOM ORDER BY CUSTOM_NAME;
-- 나이가 많은 사람부터 ~ 적은 사람
SELECT * FROM CUSTOM ORDER BY CUSTOM_AGE DESC;
SELECT * FROM CUSTOM ORDER BY CUSTOM_AGE DESC, CUSTOM_NAME ; 
				-- 정렬 기준 : 나이 내림차순 -> (같은 나이)이름 오름차순

SELECT * FROM CUSTOM;


/* 테이블 사이에 관계 설정과 테이블 각 컬럼에 여러가지 요구사항 적용 필요함
 *  제약 조건(contraints) --> 데이터의 무결성 유지
 *      ㄴ not null
 * 		ㄴ 기본값 설정 : custom_reg_date, buy_date를 현재 날짜로
 * 		ㄴ 값의 제한 : quantity(수량)이 1보다 큰 값
 * 		ㄴ 유일한 값(unique) : custom_id, product_code (테이블에서 유니크 컬럼은 1개 이상)
 * 		ㄴ 기본키(primary key) : 검색, rows 식별 column 표시 -> unique column 중
 * 							 : 기본키는 2개 이상 컬럼을 그룹화 가능
 * 		ㄴ 외래키(foreign key) : 참조키, 다른 테이블의 컬럼을 참조하고 있는키
 * 				: buy 테이블의 custim_id는 custom 테이블 참조
 * 				: 데이터의 중복제거 / 일관성 유지를 위한 방법
*/