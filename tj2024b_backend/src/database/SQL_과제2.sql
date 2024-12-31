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

# 카테고리 테이블 생성
create table categoryt(
	cno int auto_increment,
    cname varchar(100) not null,
    origin varchar(30) not null,
    cdate datetime not null default now(),
    constraint primary key(cno)
);

# 제품 테이블 생성
create table productt(
	pno int auto_increment,
    pname varchar(100) not null,
    prduct int unsigned default 0,
    pcount int unsigned default 0,
    constraint primary key(pno),
    cno int,
    constraint foreign key(cno) references categoryt(cno)
);

# 주문 테이블 생성
create table ordert(
	ono		int auto_increment	, # 주문 번호
    odate	datetime not null default now() , # # 주문 날짜
    arrival	datetime not null , # 배송 예상 날짜
    today	bool not null default false,  # 당일 배송 논리
    constraint primary key(ono)
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
show tables;
select * from membert;
select * from categoryt;
select * from productt;
select * from ordert;
select * from detailt;