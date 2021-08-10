-- grant resource, connect to jcpdev
-- resource 권한이 있으므로 테이블 생성 가능
CREATE TABLE tblTest(
	col1 varchar2(20),
	col2 NUMBER(6)
);  -- 같은 테이블 이름으로 2개를 생성 못함
	-- 실행은 커서 위치부터 시작
SELECT * FROM TBLTEST;
