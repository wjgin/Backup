-- java와 연동 sql 테스트

-- 사용자 등록시 이미 존재하는 id를 입력했을 때,
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID = 'nana'; -- 아이디가 존재할 때, 단일 값 1 
SELECT count(*) FROM CUSTOM# WHERE CUSTOM_ID = 'nana2'; -- 아이디가 존재하지 않을 때, 단일 값 0
 
SELECT * FROM CUSTOM# WHERE CUSTOM_ID = 'nana'; -- 아이디가 존재할 때, ROW 1개	NOT null
SELECT * FROM CUSTOM# WHERE CUSTOM_ID = 'nana2'; -- 아이디가 존재하지 않을 때, ROW  0개		NULL
--			ㄴ java에서 조회 결과에 null 확인

UPDATE "CUSTOM#" SET CUSTOM_REG_DATE = SYSDATE ;