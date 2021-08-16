SELECT * FROM JOBS j ;
SELECT * FROM EMPLOYEES e ;

-- ���޺� ��� ����
SELECT j.JOB_TITLE , AVG(e.SALARY) AS avg_sal 
	FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
	GROUP BY j.JOB_TITLE ;
-- ���޺� ��� ����
SELECT j.JOB_ID , AVG(e.SALARY) AS avg_sal 
	FROM JOBS j , EMPLOYEES e WHERE j.JOB_ID = e.JOB_ID  
	GROUP BY j.JOB_ID ;

-- ���� ������ ������ �ӱ� Ȯ��
SELECT e.SALARY, jh.START_DATE 
	FROM EMPLOYEES e , JOB_HISTORY jh 
	WHERE e.EMPLOYEE_ID = jh.EMPLOYEE_ID 
	AND jh.START_DATE =  (SELECT MIN(start_date) FROM JOB_HISTORY);

-- 'IT' �μ����� ���� ���� �޿��� �޴� ������ last, first name
SELECT LAST_NAME, FIRST_NAME , SALARY 
	FROM EMPLOYEES
	WHERE SALARY = 
		(SELECT MAX(salary) 
		FROM DEPARTMENTS d , EMPLOYEES e 
		WHERE d.DEPARTMENT_ID = e.DEPARTMENT_ID
		AND DEPARTMENT_NAME = 'IT');

-- last name�� Taylor�� last name, hire date, start date, end date, job id ��ȸ
	SELECT e.LAST_NAME , e.FIRST_NAME, e.HIRE_DATE, jh.START_DATE , jh.END_DATE , jh.JOB_ID 
		FROM JOB_HISTORY jh, EMPLOYEES e 
		WHERE jh.EMPLOYEE_ID = e.EMPLOYEE_ID 
		AND e.LAST_NAME = 'Taylor'; 
		
	
-- outer join 