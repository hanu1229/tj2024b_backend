drop database if exists studentservice;
create database studentservice;
use studentservice;

# 테이블 생성
create table student (
	sno int unsigned auto_increment,
    sname varchar(30) not null,
    kscore int unsigned not null,
    escore int unsigned not null,
    mscore int unsigned not null,
    constraint primary key(sno)
);
# 샘플 데이터
insert into student(sname, kscore, escore, mscore) values ('유재석', 100, 90, 80);
insert into student(sname, kscore, escore, mscore) values ('강호동', 70, 100, 90);
insert into student(sname, kscore, escore, mscore) values ('신동엽', 90, 90, 90);
insert into student(sname, kscore, escore, mscore) values ('서장훈', 30, 70, 90);
insert into student(sname, kscore, escore, mscore) values ('이수근', 90, 90, 20);
# 조회
select * from student;