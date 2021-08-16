/*
SQL 쿼리(select) 복습 문제

1. custom# 테이블에서 age 가 25세 이상 조회
2. custom# 테이블에서 custom_id 'momo' 의 email 조회
3. product# 테이블에서 category '12' 의 pname 조회
4. product# 테이블에서 price 의 최고값 조회
5. product# 테이블에서 category '10' 의 갯수 조회
6. buy# 테이블에서 custom_id 'nayeon' 의 모든 내용 조회
7. buy# 테이블에서 pcode 가 'LG'로 시작하는 것 조회
8. buy# 테이블에서 cusom_id 'momo' 가 구매한 상품의 이름과 가격 조회(서브쿼리 사용)

*/
-- 1
SELECT * FROM "CUSTOM#" WHERE CUSTOM_AGE >=25;
-- 2
SELECT CUSTOM_EMAIL FROM "CUSTOM#" WHERE CUSTOM_ID = 'momo';
-- 3
SELECT PRODUCT_NAME FROM "PRODUCT#" WHERE PRODUCT_CARTEGORY = 12;
-- 4
SELECT MAX(PRODUCT_PRICE) max_price FROM "PRODUCT#";
-- 5
SELECT count(*)Cnt_category10 FROM "PRODUCT#" WHERE PRODUCT_CARTEGORY = 10;
-- 6
SELECT * FROM "BUY#" WHERE CUSTOM_ID = 'nayeon';
-- 7
SELECT * FROM "BUY#" WHERE PRODUCT_CODE LIKE 'LG%';
-- 8
SELECT PRODUCT_NAME, PRODUCT_PRICE FROM "PRODUCT#" WHERE PRODUCT_CODE = (SELECT PRODUCT_CODE FROM "BUY#" WHERE CUSTOM_ID = 'momo'); 
-- 8. 가져올 데이터가 2개 이상이라면 = 를 사용할 수 없음. => IN 연산자를 사용해야함
SELECT PRODUCT_NAME, PRODUCT_PRICE FROM "PRODUCT#" WHERE PRODUCT_CODE IN (SELECT PRODUCT_CODE FROM "BUY#" WHERE CUSTOM_ID = 'nayeon'); 


-- <<Join>>
-- 동등 조인(내부 조인) : 두 개의 테이블을 조인해서 테이블간 참조가 필요한 값을 가져 올 수 있음

-- 1) from [테이블1, 테이블2] WHERE [테이블1.중복 컬럼] = [테이블2.중복 컬럼]
SELECT * FROM "BUY#", "PRODUCT#" WHERE buy#.PRODUCT_CODE  = product#.PRODUCT_CODE; -- 기본 조인

-- 테이블명, 컬럼을 alias(별칭) 으로 설정 -> 코드의 간결화
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE; -- 조인 후 특정 컬럼만 조회

SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY 
		FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

-- buy# 테이블에서 pcode 값으로 price를 알고싶다. pcode = 'MU98' => 조인조건 AND 추가조건
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY AS total
		FROM BUY# b, "PRODUCT#" p  -- 테이블명에는 AS를 사용하면 오류
		WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE AND b.PRODUCT_CODE = 'MU98';

-- buy# 테이블에서 각 buy_no 별로 구매 금액 계산 : price * quantity
SELECT b.PRODUCT_CODE, product_price, b.BUY_QUANTITY, product_price * BUY_QUANTITY total
		FROM "BUY#" b, "PRODUCT#" p WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

-- 2) 조인결과 그룹화 with 문 이용 
--	ㄴ 고객별 총 구매금액 -> sum(total)
WITH sale AS ( -- 임시 테이블 -> 단 한 번 사용
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total -- 1회만 사용하는 select결과(인라인 뷰)
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE
) 
SELECT CUSTOM_ID, sum(total) FROM sale GROUP BY CUSTOM_ID ;

-- 	ㄴ 상품별 총 판매금액	-> sum(total)
WITH sale AS ( -- 임시 테이블 -> 단 한 번 사용
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE
) 
SELECT p_code, sum(total) FROM sale GROUP BY p_code;


-- 3) view 활용 : 가상 테이블 => 실제 저장공간 x
-- CREATE, DROP view만 가능
-- 제한적인 데이터 수정은 가능하지만 잘 사용하지 않음(데이터 조회 용)
CREATE VIEW v_slae
AS 
	SELECT CUSTOM_ID, b.PRODUCT_CODE AS p_code, BUY_QUANTITY, product_price * BUY_QUANTITY AS total
	FROM "BUY#" b, "PRODUCT#" p 
	WHERE b.PRODUCT_CODE  = p.PRODUCT_CODE;

SELECT * FROM V_SLAE; 

select * from role_sys_privs where role='RESOURCE';  -- 시스템테이블(관리자 권한)


-- outer join : 외부조인(+) 연산 기호 표시
-- 정상적인 조인조건을 만족하지 않는 행들도 조인결과에 포함 시킴
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ; -- 동등조인(equal)
DELETE FROM "BUY#" b WHERE CUSTOM_ID = 'momo';
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID = c.CUSTOM_ID ; -- 'momo' 내용이 보이지 않게됌

-- cutom# table 에는 momo가 있고 buy# table에는 momo가 없음(구매 없음) -> 포함해서 조인 => outer join
SELECT * FROM buy# b, "CUSTOM#" c WHERE b.CUSTOM_ID(+) = c.CUSTOM_ID; -- b에 없어도 표시

-- nvl(column, null일 경우 표시할 value)
SELECT c.CUSTOM_ID AS id , c.CUSTOM_AGE , NVL(PRODUCT_CODE, '구매 없음') AS "구매 코드", NVL(BUY_QUANTITY, 0) "구매 수량"
FROM "BUY#" b , "CUSTOM#" c WHERE b.CUSTOM_ID(+)  = c.CUSTOM_ID;
