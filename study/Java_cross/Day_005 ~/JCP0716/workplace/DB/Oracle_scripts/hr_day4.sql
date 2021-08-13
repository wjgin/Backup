/*
SQL : select ����

1. JOBS ���̺�

1) min_salary �ʵ尪�� 10000�̻��� Job_title ��ȸ
2) job_id �ʵ尪�� CLERK �� ���Ե� ���ڵ� ��ȸ
3) job_title �ʵ尪�� programmer �� ���ڵ� ��ȸ

2. LOCATIONS ���̺�
1) city �ʵ尪�� London �� postal_code ��ȸ
2) country_id �ʵ尪�� CA�� ���ڵ� ��ȸ

3. DEPARTMENTS ���̺�
1) LOCATION_ID ���� 1700 �� department_name ��ȸ
2) department_name �ʵ尪�� IT�� �����ϴ� location_id ��ȸ

4. JOB_HISTORY ���̺�
1) start_date �� 2005�⵵ ������ ���ڵ� ��ȸ
2) department_id �ʵ尪��  80�� ���ڵ� ��ȸ
*/

-- 1-1)
SELECT job_title FROM JOBS WHERE MIN_SALARY >= 10000;
-- 1-2)
SELECT JOB_TITLE FROM JOBS WHERE UPPER(JOB_ID) LIKE '%CLERK%';
-- count�Լ� : ���ǿ� �´� ���ڵ� ����
SELECT COUNT(*) FROM JOBS WHERE UPPER(JOB_ID) LIKE '%CLERK%'; 
-- 1-3)
SELECT * FROM JOBS WHERE JOB_TITLE LIKE 'Programmer';
-- 2-1)
SELECT POSTAL_CODE FROM LOCATIONS WHERE CITY = 'London';
-- 2-2)
SELECT * FROM LOCATIONS WHERE COUNTRY_ID = 'CA';
-- 3-1)
SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOCATION_ID = 1700;
-- �߰� location_id�� 1700�̰� manager_id�� null�� �ƴ� deparment_name
SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOCATION_ID = 1700 AND MANAGER_ID IS NOT NULL;
-- 3-2)
SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';
-- �߰� : ��ȸ��� �ߺ����� --> distinct
SELECT DISTINCT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';
-- 4-1) '2005/01/01', '20050101' ��� casting ��. TO_CHAR(date, 'yyyy-mm-dd') �Լ�(����1�� ����2 �������� ��ȯ)�� ���� 
-- to_char �Լ��� date, number Ÿ�Ե� ���ڿ��� ��ȯ
-- to_number �Լ��� char, varchar2 ���ڿ� Ÿ���� ��ġ(number)�������� ��ȯ
SELECT * FROM JOB_HISTORY WHERE START_DATE >= '2005-01-01'; 
-- 4-2)
SELECT * FROM JOB_HISTORY WHERE DEPARTMENT_ID = 80;

-- ����(���) �Լ� : �׷��Լ�, ������ �Ǵ� ��� �࿡ ���� �Լ��� ����ǰ� ������� �� ��
--   �� count, sum, avg, max, min
SELECT count(*) FROM EMPLOYEES; -- ������(���� ���̺��� ������ ����)
SELECT SUM(SALARY) FROM EMPLOYEES; -- �������� �޿� �հ�
SELECT AVG(SALARY) FROM EMPLOYEES; -- �������� ��� �޿�
SELECT MAX(SALARY) FROM EMPLOYEES; -- �������� �ְ� �޿� 
SELECT min(SALARY) FROM EMPLOYEES; -- �������� ���� �޿�
SELECT avg(SALARY) FROM EMPLOYEES WHERE JOB_ID = 'IT_PROG'; -- Ư�� �������� ��� �հ�
SELECT job_id, avg(SALARY) FROM EMPLOYEES WHERE JOB_ID = 'IT_PROG'; -- ���� : �׷�ȭ �ȵ� (�� �׷�ȭ �ʿ�)

-- �׷�ȭ : group by COLUMN => �÷� ���� �׷� ����
SELECT JOB_ID, COUNT(*) AS "EMP_CNT", avg(SALARY) AS "AVG_SAL" FROM EMPLOYEES GROUP BY JOB_ID ;
-- job_id 'IT_PROG'�� �׷� ��ȸ
SELECT JOB_ID, COUNT(*) AS "EMP_CNT", avg(SALARY) AS "AVG_SAL" 
	FROM EMPLOYEES 
	WHERE JOB_ID = 'IT_PROG'
	GROUP BY JOB_ID ;

-- sal_avg �� 9000 �̻��� ���� ���
-- where: ���� ���� -> �׷�ȭ	/ HAVING: �׷�ȭ ��� -> ���� ��ȸ
SELECT JOB_ID, COUNT(*) "EMP_CNT", avg(SALARY) "AVG_SAL" 
	FROM EMPLOYEES 
	GROUP BY JOB_ID HAVING AVG(SALARY) >= 9000 ;

-- �� ����� sal_avg �������� ����
SELECT JOB_ID, COUNT(*) "EMP_CNT", avg(SALARY) "AVG_SAL" 
	FROM EMPLOYEES 
	GROUP BY JOB_ID HAVING AVG(SALARY) >= 9000
	ORDER BY AVG(SALARY) DESC;
-- ��� : �׷�ȭ ���� from -> where -> GROUP -> HAVING -> ORDER BY


-- Employees ���̺� �׷�ȭ ������ COLUMN : job_id, manager_id, department_id
-- Ư�� ���� �̻� ����
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY FROM  EMPLOYEES
	WHERE SALARY >= 5000;
-- Ư�� �μ� �ο� ��
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) AS EMP_CNT
	FROM EMPLOYEES
	GROUP BY DEPARTMENT_ID
	HAVING DEPARTMENT_ID IN(30, 50);
-- Ŀ�̼��� ���� ���� �� ���� �ʰ� �Ի��� ������� ���
SELECT EMPLOYEE_ID, HIRE_DATE 
	FROM EMPLOYEES
	WHERE COMMISSION_PCT IS NOT NULL
	ORDER BY HIRE_DATE DESC ;
-- ��� ���� ������ ���� ������ �����ϴ� �Ŵ���
SELECT MANAGER_ID , count(MANAGER_ID) AS PERFOMANCE
	FROM EMPLOYEES
	WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES)
	GROUP BY MANAGER_ID 
	HAVING MANAGER_ID IS NOT NULL
	ORDER BY MANAGER_ID;
	
-- 2�� �̻��� ���̺�κ��� ������ ��ȸ 1) �������� 2) join
-- 1) �������� : ()�ȿ��� �ۼ�. ���������� ����� 1���� �÷�
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID = 100 
										GROUP BY DEPARTMENT_ID)
				ORDER BY SALARY;
-- job_id�� sk_clerk�� �������� �޿� �ִ밪 ���� ���� ���, max���
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY > ALL (SELECT SALARY FROM EMPLOYEES WHERE JOB_ID = 'ST_CLERK');
-- ���������� ��� ������ ���ų� ū ���� ���� => �ִ� ��(���� ���̺��̱⿡)
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY >= ALL (SELECT SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 100);
	
-- ����ID�� 100�� ����� �μ� ����(�μ����̺��� ��� �ʵ�) ��ȸ
SELECT * FROM DEPARTMENTS 
	WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = 100);
	
-- join �� �� �̻��� ���̺��� �÷��� ���� ������