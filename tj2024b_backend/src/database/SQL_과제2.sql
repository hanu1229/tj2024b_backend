show databases;
create database kurly;
use kurly;
show tables;

# 회원정보 테이블 생성
create table membert(
	mno int auto_increment,
    mname varchar(30) not null,
    phone varchar(13) not null unique,
    address text not null,
    constraint primary key(mno)
);

# 주문상세 테이블 생성
create table detailt (
	dno int auto_increment,
    dcount smallint unsigned not null,
    ono int not null,
    pno int not null,
    mno int not null,
    constraint primary key(dno),
    constraint foreign key(ono) references ordert(ono),
    constraint foreign key(pno) references productt(pno),
    constraint foreign key(mno) references membert(mno)
);