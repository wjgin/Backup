/*

TRIGGER secure_employees -- 트리거 이름
  BEFORE INSERT OR UPDATE OR DELETE ON employees	
  -- 이벤트: insert, update, delete가 employees 테이블에서 발생하기 전에 begin~end 실행
BEGIN
  secure_dml;	-- 프로시저 이름
END secure_employees;	-- 트리거의 끝



CREATE OR REPLACE PROCEDURE HR.secure_dml
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '18:00' OR TO_CHAR (SYSDATE, 'DY') IN ('SAT', 'SUN') 
        THEN 
       		RAISE_APPLICATION_ERROR (-20205, 'You may only make changes during normal office hours');
  END IF;
END secure_dml;




TRIGGER update_job_history
  AFTER UPDATE OF job_id, department_id ON employees
  -- 이벤트: employees 테이블에 job_id, department_id 컬럼에 update가 생기 후에 begin ~ end 실행
  FOR EACH ROW
BEGIN
  add_job_history(:old.employee_id, :old.hire_date, sysdate,	-- 프로시저 이름 호출
                  :old.job_id, :old.department_id);
END;




CREATE OR REPLACE PROCEDURE HR.add_job_history
  (  p_emp_id          job_history.employee_id%type
   , p_start_date      job_history.start_date%type
   , p_end_date        job_history.end_date%type
   , p_job_id          job_history.job_id%type
   , p_department_id   job_history.department_id%type
   )
IS
BEGIN
  INSERT INTO job_history (employee_id, start_date, end_date, job_id, department_id)
    VALUES(p_emp_id, p_start_date, p_end_date, p_job_id, p_department_id);
END add_job_history;

*/

-- 현재 작성된 트리거 목록
SELECT * FROM user_triggers;

-- 트리커 비활성화 / 활성화
ALTER TRIGGER update_job_history disable;
ALTER TRIGGER update_job_history enable;


-- trigger 테스트 1 : member 테이블 update, delete 08:00 ~ 14:00 사이에만 가능
-- trigger 테스트 2 : member 테이블 delete 발생시 모든 컬럼을 delmember 테이블로 추가



--1)
CREATE OR REPLACE TRIGGER secure_member -- 트리거 이름
  BEFORE UPDATE OR DELETE ON MEMBER	
  -- 이벤트: insert, update, delete가 employees 테이블에서 발생하기 전에 begin~end 실행
BEGIN
  secure_dml;	-- 프로시저 이름
END secure_member;	-- 트리거의 끝


CREATE OR REPLACE PROCEDURE secure_dml
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '20:00'
       THEN RAISE_APPLICATION_ERROR (-20205, 'You may only make changes during normal office hours');
  END IF;
END secure_dml;



--2) 
CREATE TABLE delmember AS SELECT * FROM "MEMBER" m WHERE IDX = 0; -- delmember 테이블 생성

-- 프로시저
CREATE OR REPLACE PROCEDURE del_member_pro
  (  p_mem_idx         MEMBER.IDX%type
   , p_mem_stuname     MEMBER.STUNAME%type
   , p_mem_email       MEMBER.EMAIL%type
   , p_mem_tel         MEMBER.TEL%type
   , p_mem_password    MEMBER.PASSWORD%type
   )
IS
BEGIN
  INSERT INTO delmember VALUES(p_mem_idx, p_mem_stuname, p_mem_email, p_mem_tel, p_mem_password);
END del_member_pro;

-- 트리거
CREATE OR REPLACE TRIGGER del_trigger
  AFTER DELETE ON MEMBER
  FOR EACH ROW
BEGIN
	  del_member_pro(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password); -- MEMBER 테이블의 삭제 전 컬럼을 인자로 전달하기
--    INSERT INTO delmember 
--  		VALUES(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password); -- 프로세서없이 바로 삽입
END;


SELECT * FROM "MEMBER" m ;
SELECT * FROM DELMEMBER d ;

DELETE FROM "MEMBER" WHERE IDX = 5;

ROLLBACK;
