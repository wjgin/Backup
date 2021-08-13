/*
SQL : select 연습

1. JOBS 테이블

1) min_salary 필드값이 10000이상인 Job_title 조회
2) job_id 필드값이 CLERK 이 포함된 레코드 조회
3) job_title 필드값이 programmer 인 레코드 조회

2. LOCATIONS 테이블
1) city 필드값이 London 인 postal_code 조회
2) country_id 필드값이 CA인 레코드 조회

3. DEPARTMENTS 테이블
1) LOCATION_ID 값이 1700 인 department_name 조회
2) department_name 필드값이 IT를 포함하는 location_id 조회

4. JOB_HISTORY 테이블
1) start_date 가 2005년도 이후인 레코드 조회
2) department_id 필드값이  80인 레코드 조회
*/

-- 1-1)
SELECT job_title FROM JOBS WHERE MIN_SALARY >= 10000;
-- 1-2)
SELECT JOB_TITLE FROM JOBS WHERE UPPER(JOB_ID) LIKE '%CLERK%';
-- count함수 : 조건에 맞는 레코드 개수
SELECT COUNT(*) FROM JOBS WHERE UPPER(JOB_ID) LIKE '%CLERK%'; 
-- 1-3)
SELECT * FROM JOBS WHERE JOB_TITLE LIKE 'Programmer';
-- 2-1)
SELECT POSTAL_CODE FROM LOCATIONS WHERE CITY = 'London';
-- 2-2)
SELECT * FROM LOCATIONS WHERE COUNTRY_ID = 'CA';
-- 3-1)
SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOCATION_ID = 1700;
-- 추가 location_id가 1700이고 manager_id가 null이 아닌 deparment_name
SELECT DEPARTMENT_NAME FROM DEPARTMENTS WHERE LOCATION_ID = 1700 AND MANAGER_ID IS NOT NULL;
-- 3-2)
SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';
-- 추가 : 조회결과 중복제거 --> distinct
SELECT DISTINCT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME LIKE '%IT%';
-- 4-1) '2005/01/01', '20050101' 모두 casting 됌. TO_CHAR(date, 'yyyy-mm-dd') 함수(인자1을 인자2 형식으로 변환)가 적용 
-- to_char 함수는 date, number 타입도 문자열로 변환
-- to_number 함수는 char, varchar2 문자열 타입을 수치(number)형식으로 변환
SELECT * FROM JOB_HISTORY WHERE START_DATE >= '2005-01-01'; 
-- 4-2)
SELECT * FROM JOB_HISTORY WHERE DEPARTMENT_ID = 80;

-- 집계(통계) 함수 : 그룹함수, 여러행 또는 모든 행에 대해 함수가 실행되고 결과값은 한 개
--   ㄴ count, sum, avg, max, min
SELECT count(*) FROM EMPLOYEES; -- 직원수(직원 데이블의 데이터 개수)
SELECT SUM(SALARY) FROM EMPLOYEES; -- 직원들의 급여 합계
SELECT AVG(SALARY) FROM EMPLOYEES; -- 직원들의 평균 급여
SELECT MAX(SALARY) FROM EMPLOYEES; -- 직원들의 최고 급여 
SELECT min(SALARY) FROM EMPLOYEES; -- 직원들의 최저 급여
SELECT avg(SALARY) FROM EMPLOYEES WHERE JOB_ID = 'IT_PROG'; -- 특정 직원들의 평균 합계
SELECT job_id, avg(SALARY) FROM EMPLOYEES WHERE JOB_ID = 'IT_PROG'; -- 오류 : 그룹화 안됨 (행 그룹화 필요)

-- 그룹화 : group by COLUMN => 컬럼 별로 그룹 묶기
SELECT JOB_ID, COUNT(*) AS "EMP_CNT", avg(SALARY) AS "AVG_SAL" FROM EMPLOYEES GROUP BY JOB_ID ;
-- job_id 'IT_PROG'만 그룹 조회
SELECT JOB_ID, COUNT(*) AS "EMP_CNT", avg(SALARY) AS "AVG_SAL" 
	FROM EMPLOYEES 
	WHERE JOB_ID = 'IT_PROG'
	GROUP BY JOB_ID ;

-- sal_avg 가 9000 이상인 값만 출력
-- where: 조건 먼저 -> 그룹화	/ HAVING: 그룹화 결과 -> 조건 조회
SELECT JOB_ID, COUNT(*) "EMP_CNT", avg(SALARY) "AVG_SAL" 
	FROM EMPLOYEES 
	GROUP BY JOB_ID HAVING AVG(SALARY) >= 9000 ;

-- 위 결과를 sal_avg 오름차순 정렬
SELECT JOB_ID, COUNT(*) "EMP_CNT", avg(SALARY) "AVG_SAL" 
	FROM EMPLOYEES 
	GROUP BY JOB_ID HAVING AVG(SALARY) >= 9000
	ORDER BY AVG(SALARY) DESC;
-- 결론 : 그룹화 순서 from -> where -> GROUP -> HAVING -> ORDER BY


-- Employees 테이블에 그룹화 가능한 COLUMN : job_id, manager_id, department_id
-- 특정 봉급 이상 직원
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY FROM  EMPLOYEES
	WHERE SALARY >= 5000;
-- 특정 부서 인원 수
SELECT DEPARTMENT_ID, COUNT(EMPLOYEE_ID) AS EMP_CNT
	FROM EMPLOYEES
	GROUP BY DEPARTMENT_ID
	HAVING DEPARTMENT_ID IN(30, 50);
-- 커미션을 받은 직원 중 가장 늦게 입사한 사람부터 출력
SELECT EMPLOYEE_ID, HIRE_DATE 
	FROM EMPLOYEES
	WHERE COMMISSION_PCT IS NOT NULL
	ORDER BY HIRE_DATE DESC ;
-- 평균 높은 연봉을 가진 직원들 관리하는 매니저
SELECT MANAGER_ID , count(MANAGER_ID) AS PERFOMANCE
	FROM EMPLOYEES
	WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES)
	GROUP BY MANAGER_ID 
	HAVING MANAGER_ID IS NOT NULL
	ORDER BY MANAGER_ID;
	
-- 2개 이상의 테이블로부터 데이터 조회 1) 서브쿼리 2) join
-- 1) 서브쿼리 : ()안에서 작성. 서브쿼리의 결과는 1개의 컬럼
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEES WHERE DEPARTMENT_ID = 100 
										GROUP BY DEPARTMENT_ID)
				ORDER BY SALARY;
-- job_id가 sk_clerk인 직원들의 급여 최대값 보다 많은 사람, max대신
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY > ALL (SELECT SALARY FROM EMPLOYEES WHERE JOB_ID = 'ST_CLERK');
-- 서브쿼리의 모든 값보다 같거나 큰 값이 조건 => 최대 값(같은 테이블이기에)
SELECT LAST_NAME , SALARY, DEPARTMENT_ID FROM EMPLOYEES
	WHERE SALARY >= ALL (SELECT SALARY FROM EMPLOYEES WHERE DEPARTMENT_ID = 100);
	
-- 직원ID가 100인 사람의 부서 정보(부서테이블의 모든 필드) 조회
SELECT * FROM DEPARTMENTS 
	WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = 100);
	
-- join 두 개 이상의 테이블의 컬럼을 같이 보여줌