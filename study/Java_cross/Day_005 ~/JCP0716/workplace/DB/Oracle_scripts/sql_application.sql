SELECT * FROM "BOOKRENT#" ;

UPDATE "BOOKRENT#" SET STATE = 'T'
WHERE EXP_DATE < '2021-10-19' AND RETURN_DATE IS NULL ;

ROLLBACK ; -- 디비버 설정에서 auto_commit => ROLLBACK 효과 없음

-- 디비버 auto_commit 해제 : 윈도우 설정 - 연결유형 - auto commit
--					ㄴ 데이터베이스 - 트랜잭션 모드 - manual commit로 변경
UPDATE "BOOKRENT#" SET STATE = 'T'
WHERE EXP_DATE < '2021-10-19' AND RETURN_DATE IS NULL ;

-- 트랜잭선 시작
DELETE FROM "BOOKRENT#" b WHERE IDX = 2 AND BCODE = 'C1101';
DELETE FROM "BOOKRENT#" b WHERE IDX = 3 AND BCODE = 'A1102';
DELETE FROM "BOOKRENT#" b WHERE IDX = 3 AND BCODE = 'B1101';
SELECT * FROM "BOOKRENT#" b ;
ROLLBACK; -- 직전 테이블 변경을 취소
-- 트랜잭선 종료

-- 새로운 트랜잭선
DELETE FROM "BOOKRENT#" b WHERE IDX = 2 AND BCODE = 'C1101';
SELECT * FROM "BOOKRENT#" b ;
COMMIT;
-- 트랜잭션 끝
ROLLBACK; -- COMMIT 후 ROLLBACK 적용 내용 없음



-- 프로시저 기본 문법
-- 익명 프로시저
DECLARE
-- 변수 선언
	v_code char(5);	-- 일반적인 선언(변수 타입 직접 지정)
	v_title book#.title%TYPE; -- book# 테이블의 title 컬럼 참조 => 더 자주쓰는 방법
BEGIN -- 프로시저 시작
	SELECT BCODE, TITLE INTO v_code, v_title -- 조회 결과를 변수에 저장함(into) 
	FROM "BOOK#" WHERE BCODE = 'A1101';	-- 실행결과 행이 1개, 다중행은 다른 방법으로
	dbms_output.put_line('테스트...');
	dbms_output.put_line(v_code || '-' || v_title);	-- 문자열 연결 ||
END; -- 프로시저 종료

-- tbltemp 테이블을 book#테이블과 동일하게 생성(제약 조건은 가져오지 못함, null 조건만 가져옴)
CREATE TABLE tbltemp
AS 
SELECT * FROM "BOOK#" WHERE BCODE = ''; -- 행이 없는 조건을 넣어서 컬럼만 가져와 생성

SELECT * FROM tbltemp;



-- book# 테이블에서 select 한 결과 1행을 다른 테이블(tbltemp)에 추가
DECLARE
	v_code char(5) := 'A1101';	-- 변수 선언과 동시에 정의(대입 :=)
	v_row book#%ROWTYPE;	-- 행 참조 변수
BEGIN
	SELECT * INTO v_row
	FROM "BOOK#" WHERE bcode = v_code;
	INSERT INTO tbltemp VALUES v_row;
END ;
COMMIT; -- insert를 반영하기 위해선 commit을 해줘야함



-- 저장 프로시저
CREATE OR REPLACE PROCEDURE search_book(	-- 프로시저 이름(식별자) 부여
	-- 매개 변수 선언
	v_code book#.bcode%TYPE	-- 인자로 사용할 변수
)
IS -- 매개 변수 이외의 변수 선언 (일반 변수 선언)
	v_row book#%rowtype;
BEGIN
	SELECT * INTO v_row
	FROM "BOOK#" WHERE bcode = v_code;
	INSERT INTO tbltemp VALUES v_row;
	COMMIT;	-- 선택적 추가
	EXCEPTION
	when no_data_found THEN NULL;
END ;


-- view, porcedure, trigger -> create or replace : 없으면 생성 있으면 대체
-- 저장 프로시저 실행
BEGIN
	SEARCH_book('B1101');	-- 프로시저 실행에 필요한 인자 전달(v_code에 'B1101'을 전달해서 실행)
END;

ROLLBACK;	

SELECT * FROM TBLTEMP ;




-- 문제 : bookrent 테이블에서 실행하는 프로시저
BEGIN
	RETURN_update(4, 'C1101', '2020-10-20');	-- idx 4번 회원의 C1101 도서를 2020-10-20에 반납 -> 연체
END;
BEGIN
	RETURN_update(4, 'C1101', '2020-10-02');	-- idx 4번 회원의 C1101 도서를 2020-10-02에 반납 -> 연체 아님
END;


-- 프로시저 실행 내용 : update 반납날짜, update 연체 여부(state = 'T')
CREATE OR REPLACE PROCEDURE RETURN_update(
	v_idx bookrent.IDX%TYPE,
	v_bcode bookrent.BCODE%TYPE,
	v_return_date bookrent.RETURN_DATE%TYPE
)
IS 
BEGIN
	UPDATE BOOKRENT SET RETURN_DATE = v_return_date WHERE IDX = v_idx AND BCODE = v_bcode;
	UPDATE BOOKRENT SET STATE = 'TT' WHERE IDX = v_idx AND BCODE = v_bcode AND EXP_DATE < v_return_date ;
	UPDATE BOOKRENT SET STATE = 'FF' WHERE IDX = v_idx AND BCODE = v_bcode AND EXP_DATE >= v_return_date ;
END;

ROLLBACK;
SELECT * FROM BOOKRENT b ;

-- 프로시저에서 첫 줄 업데이트가 완료되고 두번째 업데이트에서 오류가 난다면 자동으로 rollback 됨


-- SQL응용 시험
--문제 1 =============================================
--1)
CREATE OR REPLACE PROCEDURE search_book(	
	v_code book#.bcode%TYPE	
)
IS 
	v_row book#%rowtype;
BEGIN
	SELECT * INTO v_row
	FROM "BOOK#" WHERE bcode = v_code;
	INSERT INTO tbltemp VALUES v_row;
	EXCEPTION
	when no_data_found THEN NULL;
END ;

--2)
BEGIN
	search_book('A1101');
END;

SELECT * FROM TBLTEMP;



--문제 2 =============================================
--1)
CREATE OR REPLACE TRIGGER backup_member
	AFTER DELETE ON MEMBER#
	FOR EACH ROW 
	BEGIN 
		INSERT INTO DELMEMBER VALUES(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password);
	END;

--2)
CREATE TABLE delmember AS SELECT * FROM "MEMBER" WHERE IDX = 0;

--3)
ALTER TABLE DELMEMBER ADD del_date DATE DEFAULT sysdate;

--4)
CREATE OR REPLACE TRIGGER backup_member
	AFTER DELETE ON MEMBER#
	FOR EACH ROW 
	BEGIN 
		INSERT INTO DELMEMBER VALUES(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password, sysdate);
	END;

--5)
DELETE FROM "MEMBER#" WHERE IDX = 5;


SELECT * FROM "MEMBER#";
SELECT * FROM DELMEMBER;


--문제 3 =============================================
--1)
CREATE USER dev1 IDENTIFIED BY 9876;

--2)
GRANT resource, CONNECT TO dev1;

--3)
conn sys/1234 AS sysdba;
