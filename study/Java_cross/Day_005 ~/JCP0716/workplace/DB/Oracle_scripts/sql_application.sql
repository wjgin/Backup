SELECT * FROM "BOOKRENT#" ;

UPDATE "BOOKRENT#" SET STATE = 'T'
WHERE EXP_DATE < '2021-10-19' AND RETURN_DATE IS NULL ;

ROLLBACK ; -- ���� �������� auto_commit => ROLLBACK ȿ�� ����

-- ���� auto_commit ���� : ������ ���� - �������� - auto commit
--					�� �����ͺ��̽� - Ʈ����� ��� - manual commit�� ����
UPDATE "BOOKRENT#" SET STATE = 'T'
WHERE EXP_DATE < '2021-10-19' AND RETURN_DATE IS NULL ;

-- Ʈ���輱 ����
DELETE FROM "BOOKRENT#" b WHERE IDX = 2 AND BCODE = 'C1101';
DELETE FROM "BOOKRENT#" b WHERE IDX = 3 AND BCODE = 'A1102';
DELETE FROM "BOOKRENT#" b WHERE IDX = 3 AND BCODE = 'B1101';
SELECT * FROM "BOOKRENT#" b ;
ROLLBACK; -- ���� ���̺� ������ ���
-- Ʈ���輱 ����

-- ���ο� Ʈ���輱
DELETE FROM "BOOKRENT#" b WHERE IDX = 2 AND BCODE = 'C1101';
SELECT * FROM "BOOKRENT#" b ;
COMMIT;
-- Ʈ����� ��
ROLLBACK; -- COMMIT �� ROLLBACK ���� ���� ����



-- ���ν��� �⺻ ����
-- �͸� ���ν���
DECLARE
-- ���� ����
	v_code char(5);	-- �Ϲ����� ����(���� Ÿ�� ���� ����)
	v_title book#.title%TYPE; -- book# ���̺��� title �÷� ���� => �� ���־��� ���
BEGIN -- ���ν��� ����
	SELECT BCODE, TITLE INTO v_code, v_title -- ��ȸ ����� ������ ������(into) 
	FROM "BOOK#" WHERE BCODE = 'A1101';	-- ������ ���� 1��, �������� �ٸ� �������
	dbms_output.put_line('�׽�Ʈ...');
	dbms_output.put_line(v_code || '-' || v_title);	-- ���ڿ� ���� ||
END; -- ���ν��� ����

-- tbltemp ���̺��� book#���̺�� �����ϰ� ����(���� ������ �������� ����, null ���Ǹ� ������)
CREATE TABLE tbltemp
AS 
SELECT * FROM "BOOK#" WHERE BCODE = ''; -- ���� ���� ������ �־ �÷��� ������ ����

SELECT * FROM tbltemp;



-- book# ���̺��� select �� ��� 1���� �ٸ� ���̺�(tbltemp)�� �߰�
DECLARE
	v_code char(5) := 'A1101';	-- ���� ����� ���ÿ� ����(���� :=)
	v_row book#%ROWTYPE;	-- �� ���� ����
BEGIN
	SELECT * INTO v_row
	FROM "BOOK#" WHERE bcode = v_code;
	INSERT INTO tbltemp VALUES v_row;
END ;
COMMIT; -- insert�� �ݿ��ϱ� ���ؼ� commit�� �������



-- ���� ���ν���
CREATE OR REPLACE PROCEDURE search_book(	-- ���ν��� �̸�(�ĺ���) �ο�
	-- �Ű� ���� ����
	v_code book#.bcode%TYPE	-- ���ڷ� ����� ����
)
IS -- �Ű� ���� �̿��� ���� ���� (�Ϲ� ���� ����)
	v_row book#%rowtype;
BEGIN
	SELECT * INTO v_row
	FROM "BOOK#" WHERE bcode = v_code;
	INSERT INTO tbltemp VALUES v_row;
	COMMIT;	-- ������ �߰�
	EXCEPTION
	when no_data_found THEN NULL;
END ;


-- view, porcedure, trigger -> create or replace : ������ ���� ������ ��ü
-- ���� ���ν��� ����
BEGIN
	SEARCH_book('B1101');	-- ���ν��� ���࿡ �ʿ��� ���� ����(v_code�� 'B1101'�� �����ؼ� ����)
END;

ROLLBACK;	

SELECT * FROM TBLTEMP ;




-- ���� : bookrent ���̺��� �����ϴ� ���ν���
BEGIN
	RETURN_update(4, 'C1101', '2020-10-20');	-- idx 4�� ȸ���� C1101 ������ 2020-10-20�� �ݳ� -> ��ü
END;
BEGIN
	RETURN_update(4, 'C1101', '2020-10-02');	-- idx 4�� ȸ���� C1101 ������ 2020-10-02�� �ݳ� -> ��ü �ƴ�
END;


-- ���ν��� ���� ���� : update �ݳ���¥, update ��ü ����(state = 'T')
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

-- ���ν������� ù �� ������Ʈ�� �Ϸ�ǰ� �ι�° ������Ʈ���� ������ ���ٸ� �ڵ����� rollback ��





