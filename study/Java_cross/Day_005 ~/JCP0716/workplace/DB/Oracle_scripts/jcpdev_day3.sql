CREATE TABLE tbl#(
	col1 varchar2(30) CONSTRAINT tbl#_notnull1 NOT NULL,
	col2 varchar2(10) NOT NULL, -- CONSTRAINT 키워드 생략 : 더 보편적인 방법
	col3 varchar2(10),
	col4 NUMBER(3)
);

INSERT INTO tbl#(col1) VALUES ('test1'); -- col2의 제약조건 위배
INSERT INTO tbl#(col1, col2) VALUES ('test1', 'test2');

-- 1)컬럼이름 변경
-- ALTER TABLE [테이블명] RENAME COLUMN [현재컬럼명] TO [변경할컬럼명];
ALTER TABLE tbl# RENAME COLUMN 바꾸기 전 TO 바꿀이름;

-- 2) 아래 컬럼 추가하면 기존 row들도 default 값으로 변경됨
ALTER TABLE tbl# ADD (column5 NUMBER(5) DEFAULT 100); -- 기본값 100
INSERT INTO tbl#(col1, col2) VALUES ('테스트1', '테스트2');


-- 3)컬럼 추가 : column6 가변문자(20) 기본값 'guest' 로 변경
ALTER TABLE tbl# ADD (column6 varchar2(20) DEFAULT 'guest');
INSERT INTO tbl#(col1, col2) VALUES ('게스트1', '게스트2');

-- 4) 기존 컬럼 형식 변경 
-- 데이터 크기만 바꾸기
ALTER TABLE tbl# MODIFY (col2 varchar(50)); 
-- 데이터 크기와 null 가능으로 바꾸기
ALTER TABLE tbl# MODIFY (col2 varchar(50) null);

-- 5) 제약 조건 추가 : 기존에 저장된 데이터 때문에 오류 발생 가능성 있음
 -- 오류: 이미 col3에 null이 존재
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull2 CHECK (col3 IS NOT NULL);
-- null 값을 수정 후 생성 / 제약조건의 이름도 변경해야함
ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull3 CHECK (col4 IS NOT NULL);
-- 제약조건 하나 당 하나의 컬럼만 묶는 것이 drop문제가 안생겨서 보편적
-- ALTER TABLE tbl# ADD CONSTRAINT tbl#_notnull4 CHECK (column5 IS NOT NULL AND column6 IS NOT NULL );

-- 7) 제약조건 제거
ALTER TABLE TBL# DROP CONSTRAINT TBL#_NOTNULL4;
-- meta data로 제약조건 확인해보기(where 조건 없으면 모든 제약조건)
SELECT CONSTRAINT_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'TBL#';



-- 변경내용 확인
SELECT * FROM tbl#;
-- [변경내용 키워드] :
-- 1)컬럼이름 변경: rename column [현재컬럼] to [바뀔컬럼이름] 
-- 2)테이블 이름 변경: rename to 
-- 3)새로운 컬럼 추가: add
-- 4)컬럼 데이터 형식 변경: modify
-- 5)제약조건 변경: add constraint
-- 6)기존컬럼 삭제: drop
-- 7)기존 제약조건 삭제
-- 오라클 대소문자가 필요한 경우 : 조건값 검색(처리는 모두 대문자가 됨)


-- 테이블: 개체/관계를 데이터로 저장.
-- student 개체를 요구사항에 따라 필드(속성)을 구성
--  ㄴ 필드: 학번, 이름, 주소, 나이, 성별
-- 제약조건 chck 추가. 1
CREATE TABLE student (
	stu_no char(6) NOT NULL,
	stu_name varchar2(20) NOT NULL
	
	address varchar2(50),
	age number(3) CHECK (age BETWEEN 16 AND 20),
	gender char(1) CHECK(gender IN('M', 'F'))-- gender = 'M' OR gender = 'F'
);

-- INSERT 문 제약조건 위반 발생의 경우 포함해서 10개
-- 학번: 예:) 2021A1
INSERT INTO STUDENT VALUES ('2021A1', 'Lee', 'Goyang', 17, 'M');
-- 나이 제약조건 위배
INSERT INTO STUDENT VALUES ('2021A2', 'Kim', 'Seoul', 21, 'M'); 
INSERT INTO STUDENT VALUES ('2021A3', 'Choi', 'Chnagwon', 17, 'F');
INSERT INTO STUDENT VALUES ('2021A4', 'Shin', 'Paju', 16, 'F');
--  학번 제약조건 위배
INSERT INTO STUDENT VALUES (NULL, 'Park', 'Busan', 18, 'M'); 
INSERT INTO STUDENT VALUES ('2021B1', 'Woo', 'Uijeongbu', 19, 'F');
INSERT INTO STUDENT VALUES ('2021B2', 'Lim', 'Siheung', 20, 'M');
INSERT INTO STUDENT VALUES ('2021B3', 'Yoon', 'Okkcheon', 20, 'F');
-- 성별 제약조건 위배
INSERT INTO STUDENT VALUES ('2021B4', 'Eulji', 'Yeoncheon', 18, 'Man'); 
INSERT INTO STUDENT VALUES ('2021B5', 'Han', 'Gangneung', 16, 'M');
-- ckeck 범위 조건 null 값 허용 확인 => 허용함
INSERT INTO STUDENT VALUES ('2021B6', 'Han', 'Gangneung', NULL, NULL);

-- 특정 이름이 학생의 주소를 변경
UPDATE STUDENT SET address = 'Seoul' WHERE sut_name = 'Lee';
-- 컬럼 이름 변경
ALTER TABLE STUDENT RENAME COLUMN sut_name TO stu_name;
-- student에 저장된 학생이름과 나이, 성별만 보여주기
SELECT stu_name, age, gender FROM STUDENT;
-- 출력값 변경(데이터를 수정 x)
-- decode 함수 적용
SELECT stu_name, age, DECODE(GENDER, 'M', '남자', 'F', '여자', 'unknown') FROM STUDENT;
-- nvl(필드, 'null 대체 값')
SELECT stu_name, NVL(age, 0), DECODE(GENDER, 'M', '남자', 'F', '여자', 'unknown') FROM STUDENT;
SELECT * FROM STUDENT;

-- Primary key : 개체 인스턴스(row) 식별
-- 기본키 제약 조건 : null 허용안함, 유일성 만족
ALTER TABLE STUDENT ADD CONSTRAINT student_pk PRIMARY KEY (stu_no);

-- score 테이블
--  ㄴ 필드 : 학번, subject_id, mid_score, final_score, grade
CREATE TABLE score(
	stu_no char(6) NOT NULL, -- PK설정시 자동으로 NOT NULL, UNIQUE 적용(그래도 설정)
	subject_id char(5) NOT NULL,
	mid_score NUMBER(3) NOT NULL, 
	final_score NUMBER(3) NOT NULL, 
	grade char(1), 
	-- 기본키 설정
	CONSTRAINT score_pk PRIMARY KEY(stu_no, subject_id),
	-- 외래키 설정(테이블 사이의 참고 관계)
	CONSTRAINT score_stuno_fk FOREIGN KEY (stu_no) -- score 테이블 컬럼
		REFERENCES student(stu_no) 				   -- 참조하는 테이블(컬럼)
);

-- 기본키 제약조건 not null
ALTER TABLE SCORE MODIFY stu_no char(6) NOT NULL;
ALTER TABLE SCORE MODIFY subject_id char(5) NOT NULL;

INSERT INTO score VALUES('2021A1', 'KO211', 80, 90, NULL);
INSERT INTO score VALUES('2021B2', 'KO211', 87, 76, NULL);
INSERT INTO score VALUES('2021B5', 'KO211', 67, 76, NULL);
INSERT INTO score VALUES('2021A1', 'EN211', 84, 89, NULL);
INSERT INTO score VALUES('2021B2', 'EN211', 78, 79, NULL);
INSERT INTO score VALUES('2021B5', 'EN211', 92, 92, NULL);
INSERT INTO score VALUES('2021A1', 'EC211', 85, 95, NULL);
INSERT INTO score VALUES('2021B2', 'EC211', 85, 95, NULL);
INSERT INTO score VALUES('2021B5', 'EC211', 56, 75, NULL);
INSERT INTO score VALUES('2021A1', 'PR211', 79, 95, NULL);
INSERT INTO score VALUES('2021B2', 'PR211', 88, 85, NULL);
INSERT INTO score VALUES('2021B5', 'PR211', 69, 78, NULL);


-- 조건 넣어보기
UPDATE SCORE SET GRADE = CASE 
	WHEN (((MID_SCORE + FINAL_SCORE) / 2) >= 90) THEN 'A'
	WHEN (((MID_SCORE + FINAL_SCORE) / 2) >= 80) THEN 'B'
	ELSE 'C'
	END;
INSERT INTO score VALUES('2021B5', 'PR211', 90, 90, 'C');

-- INSERT , UPDATE : FK 제약조건 위반 발생 가능
INSERT INTO score VALUES('2021A1', 'KO211', 88, 85, 'B');
INSERT INTO score VALUES('2021B2', 'EN211', 94, 95, 'A'); 
INSERT INTO score VALUES('2021A1', 'PR211', 78, 83, 'B'); 

-- FK 위반(무결성 위반, 참조하는 테이블 필드(부모)에 없는 값)
-- integrity constraint (JCPDEV.SCORE_STUNO_FK) violated - partent key not found
-- INSERT INTO score VALUES('2021A6', 'KO211', 88, 85, 'B');
-- 참조되고 있는 데이터를 삭제할 경우, 오류(자식 레코드가 있음) 
-- integrity constraint (JCPDEV.SCORE_STUNO_FK) violated - child record found
-- DELETE FROM STUDENT WHERE STU_NAME = 'Lee';


SELECT * FROM SCORE;

-- 테이블 제거
DROP TABLE score;

UPDATE CUSTOM# SET CUSTOM_EMAIL = 'momo@naver.com' WHERE CUSTOM_ID = 'momo';
