#SQL 과제1 : 키오스크 개발의 메모리 설계를 하고 DB와 테이블 생성을 SQL로 작성하여 제출하시오.
/*
	https://www.youtube.com/watch?v=ksuYwD1oC3A
    위 링크와 같은 프로그램을 만들기 위한 DB설계를 하시오.
    [요구사항]
		1. 여러개 카테고리중에 카테고리를 선택해서 카테고리 별로 제품들을 출력/확인 한다.
        2. 해당 제품을 선택해서 수량을 입력받아 주문처리한다. 단, 하나의 주문이 여러개의 제품을 주문할 수 있다.
        3. 주문번호를 받아서 대기한다.
        4. 설계조건
			1. [메모리 설계 필수 속성]
				- 식별자 코드, 카테고리명, 가격, 제품명, 주문수량, 주문날짜를 하되 추가 가능합니다.
			2. 테이블간의 데이터 중복을 최소화한다.
            3. 총 테이블은 3개 이상으로 설계한다.
            4. 적절한 타입과 제약조건을 최대한 활용하시오.
            5. DB명, 테이블명, 속성명은 임의로 합니다.
	* 제출 : 카카오톡방에 SQL 과제 코드가 존재하는 본인 git 상세주소 제출
*/
show databases;
# 데이터베이스 생성
create database kioskProgram;
# 데이터베이스 생성 확인
show databases;
# 데이터베이스 선택
use kioskProgram;
# 데이터베이스 카테고리 테이블 생성
create table category_table(
	c_code int auto_increment,
    c_name varchar(10) not null unique,
    constraint primary key(c_code)
);

# 데이터베이스 제품 테이블 생성
create table product_table(
	p_code int auto_increment,
    p_name varchar(10) not null unique,
    c_code int,
    constraint primary key(p_code),
    constraint foreign key(c_code) references category_table(c_code)
);

# 데이터베이스 주문목록저장 테이블 생성
create table save_order_table(
	so_code int auto_increment,
    so_date date default now(),
    constraint primary key(so_code)
);

# 데이터베이스 현재주문목록 테이블 생성
create table today_order_table(
	to_code int auto_increment,
    so_code int not null,
    p_code int not null,
    constraint primary key(to_code),
    constraint foreign key(so_code) references save_order_table(so_code),
    constraint foreign key(p_code) references product_table(p_code)
);

show tables;
select * from category_table;
select * from product_table;
select * from save_order_table;
select * from today_order_table;
drop table if exists category_table;
drop table if exists product_table;
drop table if exists save_order_table;
drop table if exists today_order_table;
