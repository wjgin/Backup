-- ���̺� ���� ����
CREATE TABLE customer (
	idx int auto_increment primary key, -- auto_increment �ٷ� ���� ����
	name varchar(20)NOT NULL,
	password varchar(20)NOT NULL,
	email varchar(30)NOT NULL,
	address varchar(30),
	gender varchar(10) not null ,
	age tinyint,
	hobby varchar(30)
);


-- varchar�� ũ��� ���ڼ�(�� �� ��� ����)

-- ������ ���� ����
insert into customer(name, password, email, address, gender, age, hobby)
	values ("�浿��", "qlalfwjsgh", "kingdong@gmail.com", "�ݵ�", "����", 33, "������, ����, ������");
insert into customer(name, password, email, address, gender, age, hobby)
	values ("ȫ�浿", "ghdrkfghdrkf", "kingdong@naver.com", "����", "����", 55, "��, �౸");


-- ������ ���� �䱸����: email, address ����
-- �˻�����: idx(primary key)
update customer set email = 'kingdong@naver.com', address = 'LA' where idx = 1;

delete from customer where idx = 2;

select * from customer;
commit;