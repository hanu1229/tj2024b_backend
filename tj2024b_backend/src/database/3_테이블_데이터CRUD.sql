# 1. 데이터베이스 생성 및 삭제 및 활성화
drop database if exists mydb0102;
create database mydb0102;
use mydb0102;

# 2. 테이블 생성
create table table1 (
	mno int auto_increment,
    mname varchar(30) not null unique,
    mcount int,
    constraint primary key(mno)
);

show tables;
select * from table1;
drop table table1;
set SQL_SAFE_UPDATES = 0;

# DML : 데이터베이스 조작어
# 1. insert 2. select 3. update 4. delete
#	  [C]		[R]		  [U]		[D]

# [1] insert : 레코드(행/튜플/가로)
# insert into 테이블명(속성명1, 속성명2, ...) values (값1, 값2, ...);
insert into table1(mname, mcount) values ("박명수", 10);
insert into table1(mname, mcount) values ("유재석", 20);
# mno속성의 초기값을 생략하면 auto_increment이므로 자동으로 번호가 부여된다.
insert into table1(mno, mname, mcount) values (3, "강호동", 30);
# 테이블의 모든 속성들을 순서대로 초기값을 대입할 경우 속성명은 생략해도 된다.
insert into table1 values (4, "신동엽", 40);
insert into table1 values (7, "이수근", 70);
# insert에서 여러개의 레코드를 한번에 삽입하기
insert into table1 values (5, "서장훈", 50), (6, "하하", 60);
insert into table1 (mname, mcount) values ("김준현", 0);

# [2] select : 레코드(행/듀플) 조회 *은 속성 전체
# 전체 속성의 레코드 조회 : select * from 테이블명;
select * from table1;
# 특정 속성의 레코드 조회 : select 속성명 from 테이블명;
select mno from table1;
# 한번에 특정 속성의 레코드 조회 : select 속성명1, 속성명2, ... from 테이블명;
select mno, mname from table1;
# 레코드 조회할때 속성값 조건, [조건절] where 조건(속성명 = 값);
# mname 속성값이 "유재석"인 레코드만 조회
select * from table1 where mname = "유재석";
select * from table1 where mno = 3;

# [3] update :
# 1. 전체 레코드의 속성값 수정 : update 테이블명 set 속성명 = 새로운값;
# 오류 : mySQL workbench save mode 끄기 : set SQL_SAFE_UPDATES = 0;
# 오류 : mySQL workbench save mode 켜기 : set SQL_SAFE_UPDATES = 1;
update table1 set mcount = 0;
# 2. 특정 레코드의 속성값만 수정 : update 테이블명 set 속성명 = 새로운값 where 조건;
update table1 set mcount = 100 where mname = "유재석";
# 3. 여러 속성값을 수정 : update 테이블명 set 속성명1 = 새로운값, 속성명2 = 새로운값, ... where 조건;
update table1 set mcount = 100, mname = "강호동2" where mname = "강호동";

# [4] delete :
# delete from 테이블명 where 속성명 = 값;
delete from table1 where mno = 3;