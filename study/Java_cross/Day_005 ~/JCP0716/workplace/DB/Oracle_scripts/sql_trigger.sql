/*

TRIGGER secure_employees -- Ʈ���� �̸�
  BEFORE INSERT OR UPDATE OR DELETE ON employees	
  -- �̺�Ʈ: insert, update, delete�� employees ���̺��� �߻��ϱ� ���� begin~end ����
BEGIN
  secure_dml;	-- ���ν��� �̸�
END secure_employees;	-- Ʈ������ ��



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
  -- �̺�Ʈ: employees ���̺� job_id, department_id �÷��� update�� ���� �Ŀ� begin ~ end ����
  FOR EACH ROW
BEGIN
  add_job_history(:old.employee_id, :old.hire_date, sysdate,	-- ���ν��� �̸� ȣ��
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

-- ���� �ۼ��� Ʈ���� ���
SELECT * FROM user_triggers;

-- Ʈ��Ŀ ��Ȱ��ȭ / Ȱ��ȭ
ALTER TRIGGER update_job_history disable;
ALTER TRIGGER update_job_history enable;


-- trigger �׽�Ʈ 1 : member ���̺� update, delete 08:00 ~ 14:00 ���̿��� ����
-- trigger �׽�Ʈ 2 : member ���̺� delete �߻��� ��� �÷��� delmember ���̺�� �߰�



--1)
CREATE OR REPLACE TRIGGER secure_member -- Ʈ���� �̸�
  BEFORE UPDATE OR DELETE ON MEMBER	
  -- �̺�Ʈ: insert, update, delete�� employees ���̺��� �߻��ϱ� ���� begin~end ����
BEGIN
  secure_dml;	-- ���ν��� �̸�
END secure_member;	-- Ʈ������ ��


CREATE OR REPLACE PROCEDURE secure_dml
IS
BEGIN
  IF TO_CHAR (SYSDATE, 'HH24:MI') NOT BETWEEN '08:00' AND '20:00'
       THEN RAISE_APPLICATION_ERROR (-20205, 'You may only make changes during normal office hours');
  END IF;
END secure_dml;



--2) 
CREATE TABLE delmember AS SELECT * FROM "MEMBER" m WHERE IDX = 0; -- delmember ���̺� ����

-- ���ν���
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

-- Ʈ����
CREATE OR REPLACE TRIGGER del_trigger
  AFTER DELETE ON MEMBER
  FOR EACH ROW
BEGIN
	  del_member_pro(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password); -- MEMBER ���̺��� ���� �� �÷��� ���ڷ� �����ϱ�
--    INSERT INTO delmember 
--  		VALUES(:old.idx, :old.stuname, :OLD.email, :old.tel, :old.password); -- ���μ������� �ٷ� ����
END;


SELECT * FROM "MEMBER" m ;
SELECT * FROM DELMEMBER d ;

DELETE FROM "MEMBER" WHERE IDX = 5;

ROLLBACK;
